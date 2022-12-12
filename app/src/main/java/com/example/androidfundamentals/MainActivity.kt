package com.example.androidfundamentals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Spinner
import android.widget.Toast
import com.example.androidfundamentals.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Checkbox and Radiobutton
        binding.btnCheckboxRadiobutton.setOnClickListener {
            Intent(this, ConstraintActivity::class.java).also {
                startActivity(it)
            }
        }

        // Toast message
        binding.btnToast.setOnClickListener {
            Toast.makeText(this, "Hi, I am Toast!", Toast.LENGTH_SHORT).show()
        }

        // Intent and starting birthday activity
        binding.btnIntent.setOnClickListener {
            Intent(this, HappyBirthday::class.java).also {
                startActivity(it)
            }
        }

        // Passing data between activities
        binding.btnPassingData.setOnClickListener {
            Intent(
                this,
                PassingDataActivity::class.java
            ).also { startActivity(it) }
        }

        // Implicit Intent
        binding.btnImplicitIntent.setOnClickListener {
            Intent(this, ImplicitIntentActivity::class.java).also {
                startActivity(it)
            }
        }

        // btnFinance
        binding.btnFinance.setOnClickListener {
            Intent(
                this,
                FinanceActivity::class.java
            ).also { startActivity(it) }
        }

        // Alert Dialog
        binding.btnAlertDialog.setOnClickListener {
            Intent(this, AlertDialogActivity::class.java).also {
                startActivity(it)
            }
        }

        // Spinner Button
        binding.btnSpinner.setOnClickListener {
            Intent(this, SpinnerActivity::class.java).also {
                startActivity(it)
            }
        }

        // Recycler View
        binding.btnRecyclerView.setOnClickListener {
            Intent(this, RecyclerViewActivity::class.java).also {
                startActivity(it)
            }
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