package custom.data.source

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
		
		
        "/home/verify" {
            controller = "home"
            action = "verify"
        }		
    }
}
