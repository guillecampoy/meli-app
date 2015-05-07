package com.meli

class Company {

    String nombre
    String password
    static  hasMany = [employee:Employee]

    static constraints = {
    	nombre size: 3..10, unique: true
    }
}
