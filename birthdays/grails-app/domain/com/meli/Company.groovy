package com.meli

class Company {

    String nombre
    String password
    static  hasMany = [employee:Employee]
}
