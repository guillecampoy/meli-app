package com.meli

import grails.rest.*

class EmpleadoController extends RestfulController {
	static responseFormats = ['json', 'xml']

	public EmpleadoController() {
		super(Employee)
	}

	def search() {
		def empleados = Employee.findAllByNameLike(params.name + "%")
		//def empleados = Employee.findAllByNameLike("Carlos" + "%")
		respond empleados
	}


}