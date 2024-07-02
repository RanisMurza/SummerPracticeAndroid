package com.ranis.homeworknumberone

class Crossover(brand: String, model: String, year: Int, enginePower: Int, val driveType: String) : Car(brand, model, year, enginePower) {
    override fun displayInfo() {
        println("Car: $brand $model, Year: $year, Engine Power: $enginePower, Drive Type: $driveType")
    }
}