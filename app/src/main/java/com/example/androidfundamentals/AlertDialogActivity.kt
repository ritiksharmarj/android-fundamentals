package com.example.androidfundamentals

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.androidfundamentals.databinding.ActivityAlertDialogBinding

class AlertDialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAlertDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Dialog 1
        val addContactDialog = AlertDialog.Builder(this)
            .setTitle("Add Contact")
            .setMessage("Do you want to add Mr. Poop to your contact list?")
            .setIcon(R.drawable.ic_add_contact)
            .setPositiveButton("Yes") { _, _ ->
                Toast.makeText(this, "You added Mr. Poop", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No") { _, _ ->
                Toast.makeText(this, "You didn't add Mr. Poop", Toast.LENGTH_SHORT).show()
            }.create()

        binding.btnDialog1.setOnClickListener {
            addContactDialog.show()
        }

        val options = arrayOf("Mango", "Apple", "Papaya", "Orange", "Banana")
        // Dialog 2
        val singleChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of these options")
            .setSingleChoiceItems(
                options,
                2
            ) { _, i ->
                Toast.makeText(this, "You clicked on ${options[i]}", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Accept") { _, _ ->
                Toast.makeText(this, "You accepted the SingleChoiceDialog", Toast.LENGTH_SHORT)
                    .show()
            }
            .setNegativeButton("Decline") { _, _ ->
                Toast.makeText(this, "You declined the SingleChoiceDialog", Toast.LENGTH_SHORT)
                    .show()
            }.create()

        binding.btnDialog2.setOnClickListener {
            singleChoiceDialog.show()
        }

        // Dialog 3
        val multiChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of these options")
            .setMultiChoiceItems(
                options,
                booleanArrayOf(false, false, false, false, true)
            ) { _, i, isChecked ->
                if (isChecked) {
                    Toast.makeText(this, "You checked ${options[i]}", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "You unchecked ${options[i]}", Toast.LENGTH_SHORT).show()
                }
            }
            .setPositiveButton("Accept") { _, _ ->
                Toast.makeText(this, "You accepted the MultiChoiceDialog", Toast.LENGTH_SHORT)
                    .show()
            }
            .setNegativeButton("Decline") { _, _ ->
                Toast.makeText(this, "You declined the MultiChoiceDialog", Toast.LENGTH_SHORT)
                    .show()
            }.create()

        binding.btnDialog3.setOnClickListener {
            multiChoiceDialog.show()
        }
    }
}