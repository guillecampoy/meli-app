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

    private Integer getCurrentYear(){
        def nowCalendar = Calendar.instance
        Date nowDate = nowCalendar.time
        nowDate[Calendar.YEAR]
    }


    def listEmployeeHistoricalGifts() {
        def idEmployee = params.idEmployee
        Employee employee = Employee.findById(idEmployee)
        def gifts = employee.gifts
        return new ModelAndView("historicalGifts", [gifts : gifts])
    }

    def setGiftForEmployee() { 
        def idItem = params.idGift
        def idEmployee = params.idEmployee
        Employee employee = Employee.findById(idEmployee)
        Gift gift = new Gift(idItem: idItem, year: getCurrentYear())
        employee.addGift(gift)
        employee.save()
    }

}
