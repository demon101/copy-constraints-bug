package copy.bug

import grails.plugin.json.builder.JsonGenerator

abstract class ApiControllerHelper {
    static responseFormats = ['json']
    static allowedMethods = [index: "GET", show: "GET", save: "POST", update: "PUT", delete: "DELETE"]
    static namespace = 'api'

    static def DATE_FORMAT = 'dd.MM.yyyy'

    def jsonGenerator = new JsonGenerator.Options()
            .excludeFieldsByName('errors','constraintsMap','constraints')
            .dateFormat(DATE_FORMAT)
            .build()

//     abstract def save()
//     abstract def update()
//     abstract def delete()
//     abstract def index()
//     abstract def show()

    protected def errorsToString(def object) {
        object.errors.allErrors.collect {
            "${it.field} - " + g.message([error: it])
        }
    }
}
