package com.meli

class Role {

	String tipo

	static mapping = {
		cache true
	}

	static constraints = {
		tipo blank: false, unique: true
	}
}
