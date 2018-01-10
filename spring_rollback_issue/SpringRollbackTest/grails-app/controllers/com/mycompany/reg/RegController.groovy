package com.mycompany.reg

class RegController {

	def regService;
	
    def index() { 
    	println "Reg Controller ===> index() ===> Start"
		
		regService.createRegRecords() 
		
		
		println "Reg Controller ===> index() ==> End"
    }
}
