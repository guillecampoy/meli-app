package com.meli

import org.springframework.web.servlet.ModelAndView

class CompanyController {

    static scaffold = true
    CompanyService companyService

    def gotoCreateCompany(){
		render(view: '/company/createCompany')	
    }

    def createCompany () {

    	def username = params.nombre
    	def password = params.password

        def company = companyService.saveCompany(username, password)

        if (!company.hasErrors()) {

        	def valor = true
       		redirect (controller: "login", action: "goToLogin")
       	}
       	else{
		    render(view: '/company/createCompany', model: [company: company])
		}
        
   	}

   	def createCompanySuccess(){


   	}

    def loginCompany (){
        def username = params.nombre
        def password = params.password

        def company = companyService.loginCompany(username, password)

        [company:company]



    }

}
