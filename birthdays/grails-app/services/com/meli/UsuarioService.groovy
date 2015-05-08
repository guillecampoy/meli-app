package com.meli

import grails.transaction.Transactional

@Transactional
class UsuarioService {

    def saveUsuario(username, password, idCompany /*rol*/) {

         def usuario = new Usuario()
            usuario.userName = username
            usuario.password = password

       /*
            def company = new Company()
            company.id = idCompany;
            usuario.setCompany(company)
        */
            def company = Company.findById(idCompany)
            usuario.company = company
       //     usuario.idCompany = idCompany
            // rol

            if (true) {
                usuario.save()
            }
            else {
                return usuario
                }
    }


    def loginUsuario (userName, password){
        def usuario = Usuario.findByUserName(userName: userName)
        def logueoOk = false
        if (usuario) {
            if (usuario.password == password){
                logueoOk = true
                return logueoOk

            }
        }
    }



}


