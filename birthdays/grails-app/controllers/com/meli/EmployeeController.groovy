package com.meli

import org.springframework.web.servlet.ModelAndView

class EmployeeController {

	static scaffold = true
    
    def employeeService

    def listAllWithBirtdayInCurrentMonth() {
    	def results = employeeService.getAllEmployeeByBirthdayMonth(getCurrentMonth())
    	return new ModelAndView("listAllWithBirtdayInCurrentMonth", [employeeList : results])
    }

    private Integer getCurrentMonth(){
    	def nowCalendar = Calendar.instance
		Date nowDate = nowCalendar.time
		nowDate[Calendar.MONTH] + 1
    }


    def listEmployeeHistoricalGifts() {
        def idEmployee = params.idEmployee
        Employee employee = Employee.findById(idEmployee)
        def gifts = employee.gifts
        return new ModelAndView("historicalGifts", [gifts : gifts])
    }

	//    def index() { } 

}
