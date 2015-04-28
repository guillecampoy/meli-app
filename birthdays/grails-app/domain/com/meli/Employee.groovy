package com.meli

class Employee {

	String name
    String lastName
	Date birthday
	def gifts = []

    static constraints = {
    }

    Boolean hasCurrentGift() {
    	def year = new Date()[Calendar.YEAR]
    	gifts.any { gift -> gift.year == year }
    }

    void addGift(Gift gift) {
        if(this.gifts.any { g -> gift.year == g.year}) {
            throw new Exception()
        }
    	this.gifts.add(gift)
    }

    String toString() {
    	name + " " + birthday
    }
}
