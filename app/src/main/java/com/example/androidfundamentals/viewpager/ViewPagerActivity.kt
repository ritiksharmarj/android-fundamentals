package com.example.androidfundamentals.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidfundamentals.R
import com.example.androidfundamentals.databinding.ActivityViewPagerBinding
import com.google.android.material.tabs.TabLayoutMediator

class ViewPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val images = listOf(
            R.drawable.wallet,
            R.drawable.watch,
            R.drawable.leatherbelt,
            R.drawable.shoes,
            R.drawable.sunglass
        )

        binding.viewPager.adapter = ViewPagerAdapter(images)

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = "Tab ${position + 1}"
        }.attach()
    }
}