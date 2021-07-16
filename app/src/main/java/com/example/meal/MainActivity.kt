package com.example.meal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

        var totalCharges: Double = 0.00
        var tipAmount = " "


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mealAmount: EditText = findViewById(R.id.mealCost)
        val group: Spinner = findViewById(R.id.spnGroup)
        val charges: Button = findViewById(R.id.btnCharge)
        val result: TextView = findViewById(R.id.txtResult)

        charges.setOnClickListener{
            val tip: Double
            var totalMealAmount: Double
            totalMealAmount = mealAmount.text.toString().toDouble()
            val currency = DecimalFormat("$###,###.00")
            tipAmount = group.selectedItem.toString()
            tip = tipAmount.toDouble()
            totalCharges = totalMealAmount + (totalMealAmount * tip)
            val totalMealFormatted = currency.format(totalMealAmount)
            val totalChargesFormatted = currency.format(totalCharges)
            val percent = DecimalFormat("##%")
            val tipFormatted = percent.format(tip)
            result.text = "A meal cost with a tip of $tipFormatted for $totalMealFormatted amount is $totalChargesFormatted"

        }
    }
}