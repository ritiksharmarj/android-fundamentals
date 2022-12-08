package com.example.androidfundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.androidfundamentals.databinding.ActivitySpinnerBinding

class SpinnerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySpinnerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val customList = listOf("Banana", "Apple", "Mango", "Orange")
        val adapter = ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, customList)
        binding.spMonths.adapter = adapter

        binding.spMonths.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(
                    this@SpinnerActivity,
                    "You selected ${adapterView?.getItemAtPosition(position).toString()}",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }
    }
}