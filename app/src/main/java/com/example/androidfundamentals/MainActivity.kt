package com.example.androidfundamentals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Checkbox and Radiobutton
        btnCheckboxRadiobutton.setOnClickListener {
            Intent(this, ConstraintActivity::class.java).also {
                startActivity(it)
            }
        }

        // Toast message
        btnToast.setOnClickListener {
            Toast.makeText(this, "Hi, I am Toast!", Toast.LENGTH_SHORT).show()
        }
    }
}