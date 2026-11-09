
package com.example.studentloginapp

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etIdNumber: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvMessage: TextView
    private lateinit var rgAccountType: RadioGroup
    private lateinit var rbStudent: RadioButton
    private lateinit var rbAdmin: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Connect XML components
        etUsername = findViewById(R.id.etUsername)
        etIdNumber = findViewById(R.id.etIdNumber)
        btnLogin = findViewById(R.id.btnLogin)
        tvMessage = findViewById(R.id.tvMessage)

        rgAccountType = findViewById(R.id.rgAccountType)
        rbStudent = findViewById(R.id.rbStudent)
        rbAdmin = findViewById(R.id.rbAdmin)

        // Change hints based on account type
        rgAccountType.setOnCheckedChangeListener { _, checkedId ->

            if (checkedId == R.id.rbStudent) {
                etUsername.hint = "Student Name"
                etIdNumber.hint = "Student ID Number"

            } else if (checkedId == R.id.rbAdmin) {
                etUsername.hint = "Admin Username"
                etIdNumber.hint = "Admin ID"
            }

            etUsername.text.clear()
            etIdNumber.text.clear()
            tvMessage.text = ""
        }

        // Login Button
        btnLogin.setOnClickListener {

            val username = etUsername.text.toString().trim()
            val idNumber = etIdNumber.text.toString().trim()

            // Check empty fields
            if (username.isEmpty() || idNumber.isEmpty()) {
                tvMessage.text = "Please fill in all fields."
                tvMessage.setTextColor(Color.RED)
                return@setOnClickListener
            }

            // STUDENT LOGIN
            if (rbStudent.isChecked) {

                if (
                    username.equals("Juan Dela Cruz", ignoreCase = true) &&
                    idNumber == "2026001"
                ) {

                    tvMessage.text =
                        "STUDENT LOGIN SUCCESSFUL!\nWelcome, $username!"

                    tvMessage.setTextColor(Color.rgb(22, 163, 74))

                    Toast.makeText(
                        this,
                        "Welcome to PLMUN GO Student!",
                        Toast.LENGTH_SHORT
                    ).show()

                } else {

                    tvMessage.text =
                        "Invalid Student Name or ID Number."

                    tvMessage.setTextColor(Color.RED)
                }

            }

            // ADMIN LOGIN
            else if (rbAdmin.isChecked) {

                if (
                    username.equals("admin", ignoreCase = true) &&
                    idNumber == "ADMIN001"
                ) {

                    tvMessage.text =
                        "ADMIN LOGIN SUCCESSFUL!\nWelcome, Admin!"

                    tvMessage.setTextColor(Color.rgb(22, 163, 74))

                    Toast.makeText(
                        this,
                        "Welcome to PLMUN GO Admin!",
                        Toast.LENGTH_SHORT
                    ).show()

                } else {

                    tvMessage.text =
                        "Invalid Admin Username or ID."

                    tvMessage.setTextColor(Color.RED)
                }
            }
        }
    }
}
