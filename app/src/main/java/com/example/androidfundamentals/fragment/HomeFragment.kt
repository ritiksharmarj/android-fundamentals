package com.example.androidfundamentals.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.androidfundamentals.*
import com.example.androidfundamentals.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

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

        return binding.root
    }
}