package com.example.androidfundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.androidfundamentals.databinding.ActivityMainBinding
import com.example.androidfundamentals.fragment.HomeFragment
import com.example.androidfundamentals.fragment.MessagesFragment
import com.example.androidfundamentals.fragment.ProfileFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Toggle for drawer layout
        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.drawerNavigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.miDrawerHome -> setCurrentFragment(HomeFragment())
                R.id.miDrawerMessages -> setCurrentFragment(MessagesFragment())
                R.id.miDrawerProfile -> setCurrentFragment(ProfileFragment())
                R.id.miDrawerLogout -> finish()
            }
            // Close drawer when click on any item
            binding.drawerLayout.closeDrawer(GravityCompat.START)

            true
        }

        // Initial fragment that shows up when we open the app
        setCurrentFragment(HomeFragment())

        // Set fragments to each menu item
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.miHome -> setCurrentFragment(HomeFragment())
                R.id.miMessages -> setCurrentFragment(MessagesFragment())
                R.id.miProfile -> setCurrentFragment(ProfileFragment())
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
        // Handle item selection for app bar menu items
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

        // Handle toggle selection for drawer navigation
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}