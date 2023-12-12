package com.example.foodcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var checkBoxBuffalo: CheckBox
    private lateinit var checkBoxSweetChili: CheckBox
    private lateinit var checkBoxTeriyaki: CheckBox
    private lateinit var checkBoxHoneyMustard: CheckBox
    private lateinit var checkBoxHotSauce: CheckBox
    private lateinit var checkBoxParmesanCheese: CheckBox
    private lateinit var resultTextView: TextView
    private lateinit var calculateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the checkbox views
        checkBoxBuffalo = findViewById(R.id.checkBox)
        checkBoxSweetChili = findViewById(R.id.checkBox2)
        checkBoxTeriyaki = findViewById(R.id.checkBox3)
        checkBoxHoneyMustard = findViewById(R.id.checkBox4)
        checkBoxHotSauce = findViewById(R.id.checkBox5)
        checkBoxParmesanCheese = findViewById(R.id.checkBox6)

        // Find the TextView to display the result
        resultTextView = findViewById(R.id.resultTextView)

        calculateButton = findViewById(R.id.calculateButton)
        // Set a click listener on the button
        calculateButton.setOnClickListener {
            // Calculate the total cost of selected sauces
            val totalCost = calculateTotalCost(
                checkBoxBuffalo.isChecked,
                checkBoxSweetChili.isChecked,
                checkBoxTeriyaki.isChecked,
                checkBoxHoneyMustard.isChecked,
                checkBoxHotSauce.isChecked,
                checkBoxParmesanCheese.isChecked
            )

            // Display the total cost in the TextView
            val formattedTotalCost = NumberFormat.getCurrencyInstance().format(totalCost)
            resultTextView.text = "Total Cost: $formattedTotalCost"
        }
    }

    private fun calculateTotalCost(vararg sauces: Boolean): Double {
        val sauceNames = listOf("Buffalo", "Sweet Chili", "Teriyaki", "Honey Mustard", "Hot Sauce", "Parmesan Cheese")

        val prices = mapOf(
            "Buffalo" to 20.5,
            "Sweet Chili" to 20.3,
            "Teriyaki" to 13.75,
            "Honey Mustard" to 18.8,
            "Hot Sauce" to 10.2,
            "Parmesan Cheese" to 20.5
        )

        return sauces.mapIndexed { index, isSelected ->
            if (isSelected) prices[sauceNames[index]] ?: 0.0 else 0.0
        }.sum()




    }
}

