package com.example.androidfundamentals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.androidfundamentals.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Checkbox and Radiobutton
        binding.btnCheckboxRadiobutton.setOnClickListener {
            Intent(this, ConstraintActivity::class.java).also {
                startActivity(it)
            }
        }

        // Toast message
        binding.btnToast.setOnClickListener {
            Toast.makeText(this, "Hi, I am Toast!", Toast.LENGTH_SHORT).show()
        }

        // Intent and starting birthday activity
        binding.btnIntent.setOnClickListener {
            Intent(this, HappyBirthday::class.java).also {
                startActivity(it)
            }
        }

        // Passing data between activities
        binding.btnPassingData.setOnClickListener {
            Intent(
                this,
                PassingDataActivity::class.java
            ).also { startActivity(it) }
        }

        // Implicit Intent
        binding.btnImplicitIntent.setOnClickListener {
            Intent(this, ImplicitIntentActivity::class.java).also {
                startActivity(it)
            }
        }

        // btnFinance
        binding.btnFinance.setOnClickListener {
            Intent(
                this,
                FinanceActivity::class.java
            ).also { startActivity(it) }
        }
    }
}