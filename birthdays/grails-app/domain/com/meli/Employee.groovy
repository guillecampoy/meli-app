package com.meli

class Employee {

	String name
	Date birthday
	def gifts = []

    static constraints = {
    }

    Boolean hasCurrentGift() {
    	def year = new Date()[Calendar.YEAR]
    	gifts.any { gift -> gift.year == year }
    }

    void addGift(Gift gift) {
    	this.gifts.add(gift)
    }

    String toString() {
    	name + " " + birthday
    }
}
