package com.ranis.homeworknumberone

import android.speech.tts.TextToSpeech.Engine

open class Car(val brand: String, val model: String, val year: Int, val enginePower: Int) {
    open fun displayInfo() {
        println("Car: $brand $model, Year: $year, Engine Power: $enginePower")
    }
}