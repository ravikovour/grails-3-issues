package com.mycompany.reg

//import grails.gorm.transactions.Transactional
//import grails.transaction.Transactional

import org.springframework.transaction.annotation.Transactional

import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.*

import com.student.University
import com.student.Course
import java.sql.SQLException

@Transactional
class RegService {

	@Transactional(propagation = Propagation.REQUIRED)
    public void  createRegRecords() {
		
		println "RegtService ===> createRegRecords() === start"

		   /*** Create new University entry ***/
	   
		    def i_universityId = 4
			def i_univerisityCode = "UNI-4"
			def i_univesityName = "University-4"
			def i_country = "USA"
            
			def universityEntity = new University(
                    universityId: i_universityId,
                    univeristyCode: i_univerisityCode,
                    univesityName: i_univesityName,
                    country: i_country
            )		   
		   
		   universityEntity.save(flush:true)
		   
		  /* Test by throwing Runtime Exception */	
		  //throw new RuntimeException("Test Rollback Exception")
		  
		  /*** Create new Course entry ***/
	
			def i_courseId = 4
            def i_courseCode = "EEEEEE"	// This will throw SQLEXception: value too large for column "COURSE"."COURSE_CODE" (actual: 6, maximum: 3)
            def i_courseName = "Civil"
     
            def courseEntity = new Course(
                    courseId: i_courseId,
                    courseCode: i_courseCode,
                    courseName: i_courseName
            )
  
           courseEntity.save(flush:true)		
	
		println "RegtService ===> createRegRecords() === end"
    }
}
