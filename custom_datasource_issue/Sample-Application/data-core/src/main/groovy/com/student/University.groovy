package com.student

import javax.persistence.*



@Entity
@Table(name = "UNIVERSITY")
class University implements Serializable {


    @Id
    @Column(name = "UNIVERSITY_ID")
    int universityId


    @Column(name = "UNIVERSITY_CODE")
    String univeristyCode


    @Column(name = "NAME")
    String univesityName


    @Column(name = "COUNTRY")
    String country



    public String toString() {
        """University[
					universityId=$universityId, 
					univeristyCode=$univeristyCode, 
					univesityName=$univesityName, 
					country=$country]"""
    }


    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof University)) return false
        University that = (University) o
        if (universityId != that.universityId) return false
        if (univeristyCode != that.univeristyCode) return false
        if (univesityName != that.univesityName) return false
        if (country != that.country) return false
        return true
    }


    int hashCode() {
        int result
        result = (universityId != null ? universityId.hashCode() : 0)
        result = 31 * result + (univeristyCode != null ? univeristyCode.hashCode() : 0)
        result = 31 * result + (univesityName != null ? univesityName.hashCode() : 0)
        result = 31 * result + (country != null ? country.hashCode() : 0)
        return result
    }


}
