package com.meli

import grails.transaction.Transactional

@Transactional
class UsuarioService {

    def saveUsuario(username, password, idCompany /*rol*/) {

         def usuario = new Usuario()
            usuario.userName = username
            usuario.password = password
            usuario.idCompany = idCompany
            // rol

            if (usuario.validate()) {
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


