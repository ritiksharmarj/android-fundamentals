package com.example.androidfundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidfundamentals.databinding.ActivityHappyBirthdayBinding

class HappyBirthday : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHappyBirthdayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var birthdayPersonName = intent.getStringExtra("EXTRA_NAME_TO")
        var wishesFrom = intent.getStringExtra("EXTRA_NAME_FROM")

        if (birthdayPersonName == null) {
            birthdayPersonName = "Sam"
        }

        if (wishesFrom == null) {
            wishesFrom = "Emma"
        }

        val birthdayPersonString = "Happy Birthday, $birthdayPersonName!"
        val wishesFromPersonString = "From $wishesFrom."

        binding.happyBirthdayTo.text = birthdayPersonString
        binding.happyBirthdayFrom.text = wishesFromPersonString
    }
}