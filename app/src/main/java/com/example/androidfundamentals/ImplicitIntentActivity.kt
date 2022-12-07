package com.example.androidfundamentals

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.androidfundamentals.databinding.ActivityImplicitIntentBinding

class ImplicitIntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityImplicitIntentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val contract = registerForActivityResult(ActivityResultContracts.GetContent()) {
            binding.ivImplicitPhoto.setImageURI(it)
        }

        binding.btnTakePhoto.setOnClickListener {
            contract.launch("image/*")
        }
    }
}