package copy.bug

import groovy.transform.ToString

@ToString(includes=["id", "date"])
class WorkingPeriod {
    String note
    BigDecimal hours = 0G

    static constraints = {
        note nullable: true
        hours nullable: true
    }
}
