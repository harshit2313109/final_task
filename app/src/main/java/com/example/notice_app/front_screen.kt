package com.example.notice_app

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class front_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_front_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val spinner: Spinner = findViewById(R.id.spinner)
        val spinnerList = listOf("SELECT ROLE", "STUDENT", "TEACHER")
        val arrayAdapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, spinnerList)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?, view: android.view.View?, position: Int, id: Long
            ) {
                val selectedItem = parent?.getItemAtPosition(position).toString()
                Toast.makeText(
                    this@front_screen,
                    "you have selected $selectedItem",
                    Toast.LENGTH_SHORT
                ).show()

            }
             override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        val button:Button=findViewById(R.id.next_button)
        button.setOnClickListener {
            val selectedItem = spinner.selectedItem.toString() // Get selected spinner value

            when (selectedItem) {
                "STUDENT" -> {
                    val intent = Intent(this@front_screen, login_student::class.java)
                    startActivity(intent)
                }

                "TEACHER" -> {
                    val intent = Intent(this@front_screen, login_admin::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}