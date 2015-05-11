package com.meli

class Usuario {

    String userName
    String password
    Company company
    Role role

    static belongsTo = [company:Company]

	 static constraints = {
	    	userName size: 3..10, unique: true
		password blank: false
		company blank: false
		role blank: false
	    }

}
