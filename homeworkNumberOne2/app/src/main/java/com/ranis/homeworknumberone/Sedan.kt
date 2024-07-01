package com.ranis.homeworknumberone

class Sedan(brand: String, model: String, year: Int, enginePower: Int, val typeOfDrive: String, val numberOfDoors: Int) : Car(brand, model, year, enginePower) {
    override fun displayInfo() {
        println("Car: $brand $model, Year: $year, Engine Power: $enginePower, Type of drive: $typeOfDrive, Number of doors: $numberOfDoors")
    }
}
