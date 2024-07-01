package com.ranis.homeworknumberone

class SUV(brand: String, model: String, year: Int, enginePower: Int, val isOffRoad: Boolean) : Car(brand, model, year, enginePower) {
    override fun displayInfo() {
        println("Car: $brand $model, Year: $year, Off-Road Capable: $isOffRoad")
    }
}
