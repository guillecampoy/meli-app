package com.meli

class Gift {

	Integer year
	String id_MeLi

    static constraints = {
    	year nullable: false
    	id_MeLi nullable: false, unique: true
    }
}
