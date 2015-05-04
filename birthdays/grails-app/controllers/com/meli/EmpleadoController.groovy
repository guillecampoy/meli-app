package com.meli

import grails.rest.*

class EmpleadoController extends RestfulController {
	static responseFormats = ['json', 'xml']

	public EmpleadoController() {
		super(Employee)
	}


}