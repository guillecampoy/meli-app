package com.meli

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Employee)
class EmployeeSpec extends Specification {

    def setup() {
    }

    void "deberiaCrearUnEmpleadoConNombreJuan"() {
    	when: "Creo un empleado con nombre Juan"
    		def employee = new Employee(name: "Juan")
    	then: "El nombre debería ser igual a Juan"
    		employee.name == "Juan"

    }

    void "deberiaCrearUnEmpleadoConFechaDeNacimiento17/05/1989"() {
    	when: "Creo un empleado con fecha de cumpleaños 17/05/1989"
    		def date = new GregorianCalendar(1989, Calendar.MAY, 17).time
    		def employee = new Employee(name: "a", birthday: date)
    	then: "El nombre debería ser igual a Juan"
    		employee.birthday == date
    }

    void "deberiaCrearUnEmpleadoSinRegalo"() {
    	when: "Creo un empleado sin regalo"
    		def employee = new Employee()
    	then: "La cantidad de regalo debería ser 0"
    		!employee.hasCurrentGift()
    }

    void "deberiaCrearUnEmpleadoConDosRegalos"(){
        when: "Creo un empleado con un regalo"
            def employee = new Employee()
            def currentYear = new Date()[Calendar.YEAR] - 1
            def lastYear = new Date()[Calendar.YEAR] - 2
            employee.addGift(new Gift(year: lastYear))
            employee.addGift(new Gift(year: currentYear))
        then: "El empleado debería tener dos regalos"
            employee.gifts.size() == 2
            
    }

    void "deberiaCrearUnEmpleadoConUnRegaloParaAñoActual"(){
        when: "Creo un empleado con un regalo para el año actual"
            def employee = new Employee()
            def gift = new Gift(year: new Date()[Calendar.YEAR])
            employee.addGift(gift)
        then: "El empleado debería tener un regalo correspondiente al año actual"
            employee.hasCurrentGift()

    }

    void "deberiaCrearUnEmpleadoConUnRegaloParaAñoAnterior"(){
        when: "Creo un empleado con un regalo"
            def employee = new Employee()
            def year = new Date()[Calendar.YEAR] - 1
            def gift = new Gift(year: year)
            employee.addGift(gift)
        then: "El empleado debería tener un regalo correspondiente al año anterior"
            !employee.hasCurrentGift()

    }
}
