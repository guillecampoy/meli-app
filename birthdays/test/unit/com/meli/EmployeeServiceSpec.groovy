package com.meli

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */

@TestFor(EmployeeService)
class EmployeeServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
    	
    	when: ""
    	def employee1 = new Employee(name: "Employee1", birthday: new GregorianCalendar(1989, Calendar.MAY, 17).time)
    	def employee2 = new Employee(name: "Employee2", birthday: new GregorianCalendar(1983, Calendar.OCTOBER, 7).time)
    	def employee3 = new Employee(name: "Employee3", birthday: new GregorianCalendar(1979, Calendar.OCTOBER, 8).time)
		employee1.save()
		employee2.save()
		employee3.save()

		then: ""
    	def result = service.getAllEmployeeByBirthdayMonth(Calendar.OCTOBER)
    	result.size() == 2

    }
}
