class UrlMappings {

	static mappings = {

		"/empleados"(resources: "empleado")
        "/regalos"(resources: "regalo")

		// "/empleados" (controller: "empleado" , action: "index", method: "GET")
        // "/empleados" (controller: "empleado" , action: "save", method: "POST")

        // "/empleados/${id}" (controller: "empleado" , action: "delete", method: "DELETE")
        // "/empleados/${id}" (controller: "empleado" , action: "delete", method: "PUT")

        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
