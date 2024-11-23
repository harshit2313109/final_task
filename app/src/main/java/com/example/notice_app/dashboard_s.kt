package com.example.notice_app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import nl.joery.animatedbottombar.AnimatedBottomBar

class dashboard_s : AppCompatActivity() {

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

        val bottomBar = findViewById<nl.joery.animatedbottombar.AnimatedBottomBar>(R.id.bottom_bar)

        // Load the default fragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainers, HomeFragment())
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
                    R.id.tab_home -> loadFragment(HomeFragment())
                    R.id.tab_course-> loadFragment(courseFragment())
                    R.id.tab_society -> loadFragment(societyFragment())

                }
            }
        })
    }
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainers, fragment)
            .commit()
    }
}
