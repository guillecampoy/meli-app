package com.meli

import org.springframework.web.servlet.ModelAndView

class CompanyController {

    static scaffold = true
    CompanyService companyService

    def createCompany () {

    	def username = params.nombre
    	def password = params.password

        def company = companyService.saveCompany(username, password)

        def valor = true

      //  return new ModelAndView('/', [valor: valor] )
        redirect(uri: "/")
    }

}
