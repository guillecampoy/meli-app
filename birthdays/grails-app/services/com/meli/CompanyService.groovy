package com.meli

import grails.transaction.Transactional

@Transactional
class CompanyService {

    def saveCompany(username, password) {
        def company = new Company()
            company.nombre = username
            company.password = password
            company.save()

    }

    def loginCompany (username, password){
        def company = Company.findByNombre(nombre: username)
        def logueoOk = false
        if (company) {
            if (company.password == password){
                logueoOk = true
                return logueoOk

            }
        }
    }



}


