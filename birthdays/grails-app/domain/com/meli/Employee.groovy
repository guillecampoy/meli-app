package com.meli

import java.text.SimpleDateFormat

class Employee {

	String name
    String lastName
	Date birthday
    static belongsTo = [company:Company]
    static final dateFormat = new SimpleDateFormat("dd-MM-yyyy")

	static hasMany = [gifts:Gift]

    static constraints = {
    }

    Boolean hasCurrentGift() {
    	def year = new Date()[Calendar.YEAR]
    	gifts.any { gift -> gift.year == year }
    }

    void addGift(Gift gift) {
        if(this.gifts.any { g -> gift.year == g.year}) {
            throw new BirthdayException()
        }

    	//this.gifts.add(gift) // Esta linea no funciona debido a como esta mapeada la entidad
        addToGifts(gift)
    }

    String toString() {
        if(birthday) name + " " + lastName + " " + dateFormat.format(birthday)
        else name + " " + lastName
    }

}
