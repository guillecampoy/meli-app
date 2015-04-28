package com.meli

import org.springframework.web.servlet.ModelAndView

class EmployeeController {

	static scaffold = true
    
    def employeeService

    def listAllWithBirtdayInCurrentMonth() {
    	def results = employeeService.getAllEmployeeByBirthdayMonth(getCurrentMonth())
    	return new ModelAndView("index", [employeeList : results])
    }

    private Integer getCurrentMonth(){
    	def nowCalendar = Calendar.instance
		Date nowDate = nowCalendar.time
		nowDate[Calendar.MONTH] + 1
    }

    def listEmployeeHistorical(){

    }

	//    def index() { } 

}
