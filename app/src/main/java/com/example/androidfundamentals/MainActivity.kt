package com.example.androidfundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.androidfundamentals.databinding.ActivityMainBinding
import com.example.androidfundamentals.fragment.HomeFragment
import com.example.androidfundamentals.fragment.MessagesFragment
import com.example.androidfundamentals.fragment.ProfileFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val homeFragment = HomeFragment()
        val messagesFragment = MessagesFragment()
        val profileFragment = ProfileFragment()

        // Initial fragment that shows up when we open the app
        setCurrentFragment(homeFragment)

        // Set fragments to each menu item
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.miHome -> setCurrentFragment(homeFragment)
                R.id.miMessages -> setCurrentFragment(messagesFragment)
                R.id.miProfile -> setCurrentFragment(profileFragment)
            }
            true
        }

        // Number badge on message icon to show "how many messages received".
        binding.bottomNavigationView.getOrCreateBadge(R.id.miMessages).apply {
            number = 10
            isVisible = true
        }
    }

    // Bottom Navigation Bar set initial fragment
    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
    }

    // Menu Implementation
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        when (item.itemId) {
            R.id.miFavorite -> Toast.makeText(this, "Clicked on Favorite", Toast.LENGTH_SHORT)
                .show()
            R.id.miClose -> finish()
            R.id.miFeedback -> Toast.makeText(this, "Clicked on Feedback", Toast.LENGTH_SHORT)
                .show()
            R.id.miSettings -> Toast.makeText(this, "Clicked on Settings", Toast.LENGTH_SHORT)
                .show()
            R.id.miNotifications -> Toast.makeText(
                this,
                "Clicked on Notifications",
                Toast.LENGTH_SHORT
            ).show()
        }

        return true
    }
}