package com.example.androidfundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import com.example.androidfundamentals.databinding.ActivityConstraintBinding

class ConstraintActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityConstraintBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Checkbox and Radiobutton Fundamental
        binding.btnOrder.setOnClickListener {
            val checkedMeatRadioButtonId = binding.rgMeat.checkedRadioButtonId
            val meat = findViewById<RadioButton>(checkedMeatRadioButtonId)

            val cheese = binding.cbCheese.isChecked
            val onions = binding.cbOnions.isChecked
            val salad = binding.cbSalad.isChecked

            val orderString = "You ordered a burger with: \n" +
                    "${meat.text}" +
                    (if (cheese) "\nCheese" else "") +
                    (if (onions) "\nOnions" else "") +
                    (if (salad) "\nSalad" else "")

            binding.tvOrderResult.text = orderString
        }

        // Back to previous activity
        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}