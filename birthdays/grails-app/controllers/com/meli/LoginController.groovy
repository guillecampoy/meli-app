package com.meli

import org.springframework.web.servlet.ModelAndView

class LoginController {

	def index = {
		println "index"
		redirect (action: "login")
	}
	
	def login() {
		
	}

	def goToLogin(){
		return new ModelAndView("login", [ valor : true ])
	}

}