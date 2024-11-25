package com.example.notice_app

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


class Registration_s : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var username:EditText
    private lateinit var rollno:EditText
    private lateinit var registerButt: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registration_s)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        username = findViewById(R.id.username)
        emailEditText = findViewById(R.id.email)
        passwordEditText = findViewById(R.id.password)
        rollno = findViewById(R.id.rollno)
        registerButt = findViewById(R.id.register)

        registerButt.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val username = username.text.toString()
            var rollno=rollno.text.toString()

            // Validate email and password
            if ( rollno.isNotEmpty() && username.isNotEmpty() && email.isNotEmpty() && email.endsWith("@akgec.ac.in")) {
                if (password.isNotEmpty()) {
                    // Save email and password in SharedPreferences
                    val sharedPreferences: SharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
                    val editor: SharedPreferences.Editor = sharedPreferences.edit()
                    editor.putString("username",username)
                    editor.putString("email", email)
                    editor.putString("password", password)
                    editor.putString("rollno",rollno)
                    editor.apply()
                    editor.apply()
                    editor.apply()
                    editor.apply()

                    Toast.makeText(this, "Registered Successfully!", Toast.LENGTH_SHORT).show()

                    // Navigate to LoginActivity
                    val intent = Intent(this, login_student::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Password cannot be empty!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Enter a valid email ending with @akgec.ac.in!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
