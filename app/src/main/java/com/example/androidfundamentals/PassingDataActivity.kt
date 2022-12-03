package com.example.androidfundamentals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidfundamentals.databinding.ActivityPassingDataBinding

class PassingDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPassingDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnApply.setOnClickListener {
            val birthdayPersonName = binding.etNameTo.text.toString()
            val wishesFrom = binding.etNameFrom.text.toString()

            Intent(this, HappyBirthday::class.java).also {
                it.putExtra("EXTRA_NAME_TO", birthdayPersonName)
                it.putExtra("EXTRA_NAME_FROM", wishesFrom)
                startActivity(it)
            }
        }
    }
}