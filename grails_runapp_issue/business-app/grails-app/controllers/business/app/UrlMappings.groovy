package business.app

class UrlMappings {

    static mappings = {
 
        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
		
		
		"/businessapp/index" {
            controller = "businessCore"
            action = "index"
        }		

		
		"/businessapp/core" {
            controller = "businessCore"
            action = "core"
        }		

    }
}
