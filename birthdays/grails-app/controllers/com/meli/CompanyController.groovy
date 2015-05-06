package com.meli

class CompanyController {

    static scaffold = true

    def createCompany (username, password) {

        def company = com.meli.CompanyService.saveCompany(username, password)

        [company: company]

    }

}
