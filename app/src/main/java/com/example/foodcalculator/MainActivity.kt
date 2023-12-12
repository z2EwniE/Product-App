package com.example.foodcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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


        // Set a click listener on the button
        resultTextView = findViewById(R.id.resultTextView)

        findViewById<View>(R.id.calculateButton).setOnClickListener {
            // Calculate the total number of selected sauces
            val totalCost = calculateTotalCost(
                checkBoxBuffalo.isChecked,
                checkBoxSweetChili.isChecked,
                checkBoxTeriyaki.isChecked,
                checkBoxHoneyMustard.isChecked,
                checkBoxHotSauce.isChecked,
                checkBoxParmesanCheese.isChecked
            )
            val formattedTotalCost = NumberFormat.getCurrencyInstance().format(totalCost)
            resultTextView.text = "Total Cost: $formattedTotalCost"
        }
    }

    private fun calculateTotalCost(vararg sauces: Boolean): Double {
        val prices = mapOf(
            "Buffalo" to 20.5,
            "Sweet Chili" to 20.3,
            "Teriyaki" to 13.75,
            "Honey Mustard" to 18.8,
            "Hot Sauce" to 100.2,
            "Parmesan Cheese" to 20.5
        )
    return sauces.map { sauce -> if (sauce) prices[sauce.toString()]
        ?: 0.0 else 0.0}.sum()

    }
}
