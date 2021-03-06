package com.meli

import org.springframework.web.servlet.ModelAndView

class UsuarioController {

    UsuarioService usuarioService

    static allowedMethods = [loginUsuario: "POST"]

    def gotoCreateUsuario(){
    def companies = Company.findAll()   
    def roles = Role.findAll() 
    // def roles =   
		render(view: '/usuario/createUsuario', model: [companies: companies, roles: roles])	
    }

    def createUsuario () {

    	def username = params.userName
    	def password = params.password
      def idCompany = params.idCompany
      def rol       = params.rol

        def usuario = usuarioService.saveUsuario(username, password, idCompany, rol)

        if (!usuario.hasErrors()) {

        	def valor = true
       		redirect (controller: "login", action: "goToLogin")       	}
       	else{
		    render(view: '/usuario/createUsuario', model: [usuario: usuario])
		}
        
   	}

   	def createUsuarioSuccess(){


   	}

    def loginUsuario () {
        def username = params.userName
        def password = params.password

        def user
        def company
      
        def usuarioOK = usuarioService.loginUsuario(username, password)

        if (usuarioOK) {
          user = Usuario.findByUserName(username)
          company = user.getCompany()
          [usuario:user ,company:company]

        }else{
          redirect (controller: "login", action: "goToLoginFalse")
          }

        
    }

}
