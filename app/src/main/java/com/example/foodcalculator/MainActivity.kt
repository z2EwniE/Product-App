package com.example.foodcalculator

import android.content.Intent
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
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val launchSecondActivityButton = findViewById<View>(R.id.button)
        val checkBoxBuffalo = findViewById<CheckBox>(R.id.checkBox)
        val checkBoxSweetChili = findViewById<CheckBox>(R.id.checkBox2)
        val checkBoxTeriyaki = findViewById<CheckBox>(R.id.checkBox3)
        val checkBoxHoneyMustard = findViewById<CheckBox>(R.id.checkBox4)
        val checkBoxHotSauce = findViewById<CheckBox>(R.id.checkBox5)
        val checkBoxParmesanCheese = findViewById<CheckBox>(R.id.checkBox6)

        // Find the checkbox views




        // Find the TextView to display the result
        resultTextView = findViewById(R.id.resultTextView)

        calculateButton = findViewById(R.id.calculateButton)
        // Set a click listener on the button
        val intent = Intent(this, SecondActivity::class.java)
        val dataToSend = ArrayList<String>()

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

            intent.putStringArrayListExtra("key",dataToSend)
            startActivity(intent)

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

