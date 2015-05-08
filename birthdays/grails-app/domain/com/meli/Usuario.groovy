package com.meli

class Usuario {

    String userName
    String password
    Company company
    // rol

    static belongsTo = [company:Company]

	 static constraints = {
	    	userName size: 3..10, unique: true
	    }

}