package copy.bug

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration
import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent
import org.springframework.context.ApplicationListener

class Application extends GrailsAutoConfiguration implements ApplicationListener<EmbeddedServletContainerInitializedEvent> {
//    static void main(String[] args) {
//        GrailsApp.run(Application, args)
//    }

    static int serverPort

    static void main(String[] args) {
        GrailsApp.run(Application, args)
    }

    @Override
    void onApplicationEvent(EmbeddedServletContainerInitializedEvent event) {
        serverPort = event.getEmbeddedServletContainer().getPort()
    }
}