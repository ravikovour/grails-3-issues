package user.core

class LoginController {

    def index() { 
	
		println "UserCore LoginController index ===> "
		
		redirect action: 'auth', params: params

	}
	
	 def auth = {

        println "UserCore LoginController - auth entered"

        String view = 'auth'

		//This should redirect to auth.gsp present in user-core plugin views/login/auth.gsp. 
		//Giving error 
        render view: view, plugin: "userCore"
		
		/*** Following line redirects to spring-security plugin auth.gsp ***/
		//render view: view

	}
}
