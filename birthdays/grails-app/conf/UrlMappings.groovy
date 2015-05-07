class UrlMappings {

	static mappings = {

		"/empleados"(resources: "empleado")
        "/empleadosrest"(resources: "EmpleadoRest")
        //"/regalos"(resources: "regalo")

		// "/empleados" (controller: "empleado" , action: "index", method: "GET")
        // "/empleados" (controller: "empleado" , action: "save", method: "POST")

        // "/empleados/${id}" (controller: "empleado" , action: "delete", method: "DELETE")
        // "/empleados/${id}" (controller: "empleado" , action: "delete", method: "PUT")

        "/regalos" (controller: "regalo" , action: "index", method: "GET")
        "/regalos" (controller: "regalo" , action: "save", method: "POST")
        "/regalos/${id}" (controller: "regalo" , action: "show", method: "GET")
        "/gift/show/${id}" (controller: "regalo" , action: "show", method: "GET")
        "/regalos/${id}" (controller: "regalo" , action: "delete", method: "DELETE")

        "/registrarse"(view:"/company/gotoCreateCompany")
        "/company/registrarse"(view:"/company/gotoCreateCompany")


        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        // "/"(view:"/index")
        "/"(controller:"login", action:"login")
        "500"(view:'/error')
	}
}
