
package business.core


class BusinessCoreController {


    def index() {
        log.info("This is index() from BusinessCoreController == BusinessCorePlugin")
        render "This is index() from BusinessCoreController == BusinessCorePlugin"
    }
	

    def core() {
        log.info("This is coreBusiness() from BusinessCoreController == core")
		String viewName = 'businessView'
		render view: viewName,  model: [param1: "param1Value", param2: "param2Value"]
  
    }		
}