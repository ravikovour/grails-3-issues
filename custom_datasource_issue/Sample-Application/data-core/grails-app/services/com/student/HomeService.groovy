package com.student

import grails.gorm.transactions.Transactional

import com.student.University
import groovy.sql.Sql

@Transactional
class HomeService {

    def sessionFactory

    def verifyDataBaseEntities() {

    	    println "HomeService verifyDataBaseEntities entered"

            List universityListGorm = University.findAll()

            if(universityListGorm != null){
                println "University List  from db using GORM "+ universityListGorm.size()
            }
          
   }
   
   
   def testSessionFactoryConnection() {
	def connection
	try {
		println "HomeService testSessionFactoryConnection entered"
		connection = sessionFactory.currentSession.connection()
		//do something with connection 
		//Sql sql = new Sql(connection)
	}
	catch (Exception ex){
		//TODO log exception
	}
	finally{
		
	}

   }
}
