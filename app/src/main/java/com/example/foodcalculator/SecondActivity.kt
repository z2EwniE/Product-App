package com.example.foodcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val displayText : TextView = findViewById(R.id.displaytxt)

        val receivedItems = intent.getStringArrayListExtra("key")
        if (receivedItems != null && receivedItems.isNotEmpty()) {
            val itemsText = receivedItems.joinToString(", ")
            displayText.text = "Checked items: $itemsText"
        }
    }
}