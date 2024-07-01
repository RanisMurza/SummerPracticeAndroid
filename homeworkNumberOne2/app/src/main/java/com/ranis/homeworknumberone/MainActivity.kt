package com.ranis.homeworknumberone

import android.os.Bundle
import android.text.Editable
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ranis.homeworknumberone.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var button: Button? = null
    private var editText: EditText? = null

    private var viewBinding: ActivityMainBinding? = null
    private val brands = listOf("Toyota", "Toyota", "Fiat", "Hyundai", "Ferrari", "Ford", "Ford")
    private val models = listOf("Rav4", "Camry", "Albea", "Tucson", "F50", "Mustang", "GT40")
    private val typeOfDrive = setOf("full", "rear", "front")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        editText = findViewById(R.id.edit_text)

        button?.setOnClickListener {
            val numberEntered = editText?.text.toString().toIntOrNull() ?: 0
            button!!.isEnabled = false
            editText!!.isEnabled = false
            Toast.makeText(this, "Numbers of cars: ${editText?.text}", Toast.LENGTH_SHORT).show()
            startRacing(numberEntered)
        }
    }

    fun startRacing(numCars: Int) {
        var carsForRace = List(numCars) { createRandomCar() }.toMutableList()
        var numberRound = 1
        while (carsForRace.size > 1){
            println("$numberRound round")
            numberRound++
            val winners = mutableListOf<Car>()
            repeat(carsForRace.size / 2){
                val indexFirstCar = (0..<carsForRace.size).random()
                val car1: Car = carsForRace[indexFirstCar]
                carsForRace.removeAt(indexFirstCar)
                val indexSecondCar = (0..<carsForRace.size).random()
                val car2: Car = carsForRace[indexSecondCar]
                carsForRace.removeAt(indexSecondCar)
                val winner = race(car1, car2)
                winners.add(winner)
                println("Race between ${car1.brand} ${car1.model} and ${car2.brand} ${car2.model}, Winner: ${winner.brand} ${winner.model}")
            }
            for (winner in winners) {
                carsForRace += winner
            }
            winners.clear()
        }
        println("Final winner: ${carsForRace[0].brand} ${carsForRace[0].model}")
    }

    private fun createRandomCar(): Car{
        val randomNumber: Int = (0..6).random()
        val randomBrand: String = brands[randomNumber]
        val randomModels: String = models[randomNumber]
        val randomYear = (1990..2024).random()
        val randomEnginePower = (80..400).random()
        val randomTypeOfDrive = typeOfDrive.random()
        val randomRoofReclineTime = (10..40).random()

        return when((1..4).random()){
            1 -> Sedan(randomBrand, randomModels, randomYear, randomEnginePower, randomTypeOfDrive, 4)
            2 -> Convertible(randomBrand, randomModels, randomYear, randomEnginePower,randomRoofReclineTime)
            3 -> Crossover(randomBrand, randomModels, randomYear, randomEnginePower, randomTypeOfDrive)
            4 -> SUV(randomBrand, randomModels, randomYear, randomEnginePower,true)
            else -> {Sedan(randomBrand, randomModels, randomYear, randomEnginePower, randomTypeOfDrive, 4)}
        }
    }

    fun race(car1: Car, car2: Car): Car {
        return if (car1.year > car2.year) car1 else car2
    }
}

