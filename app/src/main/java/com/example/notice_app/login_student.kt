package com.example.notice_app

import android.app.DatePickerDialog
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar


class login_student : AppCompatActivity() {


    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
     private lateinit var rollno:EditText
    private lateinit var registerbutton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_student)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        passwordEditText = findViewById(R.id.password_login)
        loginButton = findViewById(R.id.login_button)
        rollno = findViewById(R.id.rollno)

        registerbutton = findViewById(R.id.register_button)
        registerbutton.setOnClickListener{
            val intent = Intent(this,Registration_s::class.java)
            startActivity(intent)
        }

        loginButton.setOnClickListener {

            val password = passwordEditText.text.toString()
            val rollno = rollno.text.toString()

            // Retrieve saved credentials from SharedPreferences
            val sharedPreferences: SharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
            val savedPassword = sharedPreferences.getString("password", "")
            val savedrollno = sharedPreferences.getString("rollno","")
            // Authenticate
            if (rollno== savedrollno && password == savedPassword) {
                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()

                // Navigate to DashboardActivity
                val intent = Intent(this, dashboard_s::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Mismatched Roll no or Password! or You are not registered", Toast.LENGTH_LONG).show()
            }
        }
        val dob = findViewById<EditText>(R.id.dob_login)
        dob.setOnClickListener {
            showDatePickerDialog(dob)
        }
    }



        fun showDatePickerDialog(dobEditText: EditText) {
            // Get the current date
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            // Open DatePickerDialog
            val datePickerDialog =
                DatePickerDialog(this@login_student, { _, selectedYear, selectedMonth, selectedDay ->
                    // Format and set the selected date in the EditText
                    val formattedDate = "${selectedDay}/${selectedMonth + 1}/$selectedYear"
                    dobEditText.setText(formattedDate)
                }, year, month, day)

            // Set maximum date to today
            datePickerDialog.datePicker.maxDate = calendar.timeInMillis

            datePickerDialog.show()
        }
    }
