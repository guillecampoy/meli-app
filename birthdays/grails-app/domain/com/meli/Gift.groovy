package com.meli

class Gift {

	Integer year
	String idItem

    static constraints = {
    	year nullable: false
    	idItem nullable: false, unique: true
    }
}
