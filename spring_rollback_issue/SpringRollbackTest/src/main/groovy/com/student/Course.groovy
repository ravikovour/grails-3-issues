/** *****************************************************************************
 Copyright 2013 Ellucian Company L.P. and its affiliates.
 ****************************************************************************** */
package com.student

import javax.persistence.*

/**
 * Course JPA Entity
 */

@Entity
@Table(name = "COURSE")
class Course implements Serializable {


    @Id
    @Column(name = "COURSE_ID")
    int courseId


    @Column(name = "COURSE_CODE")
    String courseCode


    @Column(name = "COURSE_NAME")
    String courseName


    public String toString() {
        """Course[
					courseId=$courseId, 
					courseCode=$courseCode, 
					courseName=$courseName]"""
    }


    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof Course)) return false
        Course that = (Course) o
        if (courseId != that.courseId) return false
        if (courseCode != that.courseCode) return false
        if (courseName != that.courseName) return false
        return true
    }


    int hashCode() {
        int result
        result = (courseId != null ? courseId.hashCode() : 0)
        result = 31 * result + (courseCode != null ? courseCode.hashCode() : 0)
        result = 31 * result + (courseName != null ? courseName.hashCode() : 0)
        return result
    }


}
