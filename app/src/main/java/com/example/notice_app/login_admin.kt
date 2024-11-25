package com.example.notice_app

import android.app.DatePickerDialog
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class login_admin : AppCompatActivity() {
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var teacherid:EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_admin)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val register:Button = findViewById(R.id.registerbutton_t)
        register.setOnClickListener{
            val intent=Intent(this,Registration_t::class.java)
            startActivity(intent)
        }


        passwordEditText = findViewById(R.id.password_t)
        loginButton = findViewById(R.id.login_button_t)
        teacherid = findViewById(R.id.teacherid)



        loginButton.setOnClickListener {

            val password = passwordEditText.text.toString()
            val teacherid = teacherid.text.toString()


            // Retrieve saved credentials from SharedPreferences

            val sharedPreferences: SharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
            val savedPassword = sharedPreferences.getString("password", "")
            val savedrollno = sharedPreferences.getString("rollno","")
            // Authenticate
            if (teacherid== savedrollno && password == savedPassword) {
                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()

                // Navigate to DashboardActivity
                val intent = Intent(this, dashboard_t::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "   Mismatched Teacherid or Password! or You are not registered", Toast.LENGTH_LONG).show()
            }
        }

        val dob = findViewById<EditText>(R.id.dob)
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
            DatePickerDialog(this@login_admin, { _, selectedYear, selectedMonth, selectedDay ->
                // Format and set the selected date in the EditText
                val formattedDate = "${selectedDay}/${selectedMonth + 1}/$selectedYear"
                dobEditText.setText(formattedDate)
            }, year, month, day)

        // Set maximum date to today
        datePickerDialog.datePicker.maxDate = calendar.timeInMillis

        datePickerDialog.show()
    }
}
