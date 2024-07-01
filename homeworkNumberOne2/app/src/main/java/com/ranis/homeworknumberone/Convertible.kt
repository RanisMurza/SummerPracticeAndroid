package com.ranis.homeworknumberone

import android.health.connect.datatypes.units.Power

class Convertible(brand: String, model: String, year: Int, enginePower: Int,  val roofReclineTime: Int) : Car(brand, model, year, enginePower) {
    override fun displayInfo() {
        println("Car: $brand $model, Year: $year, Engine Power: $enginePower, Roof Recline Time: $roofReclineTime")
    }
}