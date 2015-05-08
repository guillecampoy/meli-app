package com.meli

import org.springframework.web.servlet.ModelAndView

class UsuarioController {

    UsuarioService usuarioService

    def gotoCreateUsuario(){
    def companies = Company.findAll()   
    // def roles =   
		render(view: '/usuario/createUsuario', model: [companies: companies])	
    }

    def createUsuario () {

    	def username = params.nombre
    	def password = params.password
      def idCompany = params.idCompany
      // rol usuario

        def usuario = usuarioService.saveUsuario(username, password, idCompany/* rol usuario*/)

        if (!usuario.hasErrors()) {

        	def valor = true
       		redirect (controller: "login", action: "goToLogin")
       	}
       	else{
		    render(view: '/usuario/createUsuario', model: [usuario: usuario])
		}
        
   	}

   	def createUsuarioSuccess(){


   	}

    def loginUsuario (){
        def username = params.userName
        def password = params.password

        def usuario = usuarioService.loginUsuario(username, password)

        [usuario:usuario]



    }

}
