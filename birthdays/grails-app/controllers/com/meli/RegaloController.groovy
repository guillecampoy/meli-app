package com.meli

import grails.rest.*

class RegaloController extends RestfulController {
	static responseFormats = ['json', 'xml']

	public RegaloController() {
		super(Gift)
	}

}
