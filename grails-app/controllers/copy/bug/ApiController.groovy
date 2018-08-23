package copy.bug

import grails.transaction.Transactional
import grails.validation.Validateable
import org.springframework.http.HttpStatus

@Transactional(readOnly = true)
class ApiController {

    @Transactional
    def save() {
        def period = new WorkingPeriod()
        def command = new HoursCommand()

//        bindData(period, command, [exclude: ['hours','class', 'constraints']]) //works
//        bindData(period, command) //works
        bindData(period, command, [exclude: ['hours']]) // fails

        if(!period.save(flush: true)) {
            log.error "Wrong parameters ${period.errors}"
            throw new IllegalArgumentException(""+period.errors)
        }

        render(status: HttpStatus.NO_CONTENT)
    }
}

class HoursCommand implements Validateable {
    Hours hours

    static constraints = {
        hours nullable: true
    }
}

class Hours {
    BigDecimal work = 0G
}
