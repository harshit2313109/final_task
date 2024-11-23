package com.example.notice_app

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class login_admin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_admin)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
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
