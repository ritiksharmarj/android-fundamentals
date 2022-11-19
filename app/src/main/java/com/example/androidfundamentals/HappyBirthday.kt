package com.example.androidfundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_happy_birthday.*

class HappyBirthday : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_happy_birthday)

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

        happyBirthdayTo.text = birthdayPersonString
        happyBirthdayFrom.text = wishesFromPersonString
    }
}