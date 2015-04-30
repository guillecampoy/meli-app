package com.meli

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification


/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Employee)
@Mock(Gift)
class EmployeeSpec extends Specification {

    def employeeService

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

    void "deberiaCrearUnEmpleadoConDosRegalos"() {
        when: "Creo un empleado con un regalo"
            def employee = new Employee(name: "Juan", lastName: "Peres")
            def currentYear = new Date()[Calendar.YEAR]
            def lastYear = new Date()[Calendar.YEAR] - 1
            def gift1 = new Gift(idItem: 1, year: lastYear)
            def gift2 = new Gift(idItem: 1, year: currentYear)
            //employee.addGift(gift1)
            employee.addGift(gift1)
            employee.addGift(gift2)
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


    void "deberiaDarErrorAlCrearUnEmpleadoConDosRegalosParaElMismoAño"(){
        when: "Creo un empleado con un regalo"
            def employee = new Employee()
            def year = new Date()[Calendar.YEAR]
            def gift1 = new Gift(year: year)
            def gift2 = new Gift(year: year)
            employee.addGift(gift1)
            employee.addGift(gift2)
        then: "Deberia dar error"
            thrown BirthdayException
    }

}
