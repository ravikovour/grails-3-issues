package weblogicapp1

import grails.plugin.springsecurity.annotation.Secured

class ProductAnnouncementController {

    @Secured('ROLE_USER')
    def index() {
        println "TESTING!!!!"
        render view: 'home'
    }
}
