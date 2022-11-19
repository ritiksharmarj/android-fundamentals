package com.example.androidfundamentals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_passing_data.*

class PassingDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passing_data)

        btnApply.setOnClickListener {
            val birthdayPersonName = etNameTo.text.toString()
            val wishesFrom = etNameFrom.text.toString()

            Intent(this, HappyBirthday::class.java).also {
                it.putExtra("EXTRA_NAME_TO", birthdayPersonName)
                it.putExtra("EXTRA_NAME_FROM", wishesFrom)
                startActivity(it)
            }
        }
    }
}