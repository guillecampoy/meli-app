package com.meli

class CompanyController {

    static scaffold = true
    CompanyService companyService

    def createCompany () {

    	def username = params.nombre
    	def password = params.password

        def company = companyService.saveCompany(username, password)

        [company: company]

        redirect(uri: "/")
    }

}
