package com.example.androidfundamentals.fragment

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.androidfundamentals.*
import com.example.androidfundamentals.databinding.FragmentHomeBinding
import com.example.androidfundamentals.viewpager.ViewPagerActivity

class HomeFragment : Fragment() {

    private lateinit var requestLauncher: ActivityResultLauncher<String>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)

        // Checkbox and Radiobutton
        binding.btnCheckboxRadiobutton.setOnClickListener {
            Intent(activity, ConstraintActivity::class.java).also {
                startActivity(it)
            }
        }

        // Toast message
        binding.btnToast.setOnClickListener {
            Toast.makeText(activity, "Hi, I am Toast!", Toast.LENGTH_SHORT).show()
        }

        // Intent and starting birthday activity
        binding.btnIntent.setOnClickListener {
            Intent(activity, HappyBirthday::class.java).also {
                startActivity(it)
            }
        }

        // Passing data between activities
        binding.btnPassingData.setOnClickListener {
            Intent(
                activity,
                PassingDataActivity::class.java
            ).also { startActivity(it) }
        }

        // Implicit Intent
        binding.btnImplicitIntent.setOnClickListener {
            Intent(activity, ImplicitIntentActivity::class.java).also {
                startActivity(it)
            }
        }

        // btnFinance
        binding.btnFinance.setOnClickListener {
            Intent(
                activity,
                FinanceActivity::class.java
            ).also { startActivity(it) }
        }

        // Alert Dialog
        binding.btnAlertDialog.setOnClickListener {
            Intent(activity, AlertDialogActivity::class.java).also {
                startActivity(it)
            }
        }

        // Spinner Button
        binding.btnSpinner.setOnClickListener {
            Intent(activity, SpinnerActivity::class.java).also {
                startActivity(it)
            }
        }

        // Recycler View
        binding.btnRecyclerView.setOnClickListener {
            Intent(activity, RecyclerViewActivity::class.java).also {
                startActivity(it)
            }
        }

        // View Pager
        binding.btnViewPager.setOnClickListener {
            Intent(activity, ViewPagerActivity::class.java).also {
                startActivity(it)
            }
        }

        // Shared Preferences
        binding.btnSharedPreferences.setOnClickListener {
            Intent(activity, SharedPreferences::class.java).also {
                startActivity(it)
            }
        }

        // Request for notification permission on click on notification button
        requestLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if (it) {
                startActivity(Intent(activity, NotificationActivity::class.java))
            } else {
                Toast.makeText(activity, "Permission is not granted.", Toast.LENGTH_SHORT).show()
            }
        }

        // Notification
        binding.btnNotificationActivity.setOnClickListener {
            askForNotificationPermission()
        }

        return binding.root
    }

    private fun askForNotificationPermission() {
        requestLauncher.launch(android.Manifest.permission.POST_NOTIFICATIONS)
    }
}