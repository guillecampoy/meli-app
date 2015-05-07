package com.meli

import grails.rest.*

class EmpleadoController extends RestfulController {
	static responseFormats = ['json', 'xml']

	public EmpleadoController() {
		super(Employee)
	}

	def search(String name) {
		def empleados = Employee.findAll()
		//def empleados = Employee.findAllByNameLike(name)
		//def empleados = Employee.findAllByNameLike("Carlos" + "%")
		respond empleados
	}


}