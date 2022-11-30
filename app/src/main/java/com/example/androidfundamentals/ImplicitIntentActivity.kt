package com.example.androidfundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_implicit_intent.*

class ImplicitIntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intent)

        val contract = registerForActivityResult(ActivityResultContracts.GetContent()) {
            ivImplicitPhoto.setImageURI(it)
        }

        btnTakePhoto.setOnClickListener {
            contract.launch("image/*")
        }
    }
}