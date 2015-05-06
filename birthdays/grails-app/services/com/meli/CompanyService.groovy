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
}
