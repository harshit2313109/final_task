package com.example.notice_app

import android.content.Context
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


class Registration_t : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var username:EditText
    private lateinit var teacherid:EditText
    private lateinit var registerButt: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registration_t)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        username = findViewById(R.id.username_t)
        emailEditText = findViewById(R.id.email_t)
        passwordEditText = findViewById(R.id.password_t)
        teacherid = findViewById(R.id.teacher_id)
        registerButt = findViewById(R.id.register)

        registerButt.setOnClickListener {
            val email_t= emailEditText.text.toString()
            val password_t = passwordEditText.text.toString()
            val username_t = username.text.toString()
            var teacherid=teacherid.text.toString()

            // Validate email and password
            if ( teacherid.isNotEmpty() && username_t.isNotEmpty() && email_t.isNotEmpty() && email_t.endsWith("@akgec.ac.in")) {
                if (password_t.isNotEmpty()) {
                    // Save email and password in SharedPreferences
                    val sharedPreferences: SharedPreferences = getSharedPreferences("UserPrefs",Context.MODE_PRIVATE)
                    val editor: SharedPreferences.Editor = sharedPreferences.edit()
                    editor.putString("username",username_t)
                    editor.putString("email", email_t)
                    editor.putString("password", password_t)
                    editor.putString("teacherid",teacherid)
                    editor.apply()
                    editor.apply()
                    editor.apply()
                    editor.apply()

                    Toast.makeText(this, "Registered Successfully!", Toast.LENGTH_SHORT).show()

                    // Navigate to LoginActivity
                    val intent = Intent(this, login_admin::class.java)
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
