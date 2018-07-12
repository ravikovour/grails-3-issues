package com.student

class HomeController {


    def homeService

    def index() {
        System.out.println("Home Controller Enter");
        homeService.verifyDataBaseEntities();
        System.out.println("Home Controller exit");
        render view: "home"
    }
	
	def verify() {
        System.out.println("Home Controller Verify Enter");
        homeService.testSessionFactoryConnection();
        System.out.println("Home Controller exit");
        render view: "home"
    }

}
