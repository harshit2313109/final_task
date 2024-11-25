package com.example.notice_app

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

import nl.joery.animatedbottombar.AnimatedBottomBar

class dashboard_s: AppCompatActivity() {

    class HomeFragment : Fragment(R.layout.fragment_home_s)
    class courseFragment : Fragment(R.layout.fragment_courses_s)
    class societyFragment : Fragment(R.layout.fragment_society_s)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard_s)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bottomBar = findViewById<AnimatedBottomBar>(R.id.bottom_bar)

        // Load the default fragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainers,fragment_home_s.newInstance(
                    param1 = "param1",
                    param2 = "param2"
                ) )
                .commit()
        }
        bottomBar.setOnTabSelectListener(object : AnimatedBottomBar.OnTabSelectListener {
            override fun onTabSelected(
                lastIndex: Int,
                lastTab: AnimatedBottomBar.Tab?,
                newIndex: Int,
                newTab: AnimatedBottomBar.Tab
            ) {
                when (newTab.id) {
                    R.id.tab_home -> supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainers, fragment_home_s.newInstance(
                        param1 = "param1",
                        param2 = "param2"
                    ))
                    .commit()
                    R.id.tab_course  ->  supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainers,fragment_courses_s.newInstance())
                    .commit()
                    R.id.tab_society -> supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainers, fragment_society_s.newInstance())
                    .commit()

                }
            }
        })
    }

        }

        // Rest of your fragment cod

