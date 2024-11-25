package com.example.notice_app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

import nl.joery.animatedbottombar.AnimatedBottomBar

class dashboard_t : AppCompatActivity() {

    class HomeFragment : Fragment(R.layout.fragment_home_t)
    class addFragment : Fragment(R.layout.fragment_add_t)
    class analysisFragment : Fragment(R.layout.fragment_analytics_t)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard_t)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bottomBar = findViewById<AnimatedBottomBar>(R.id.bottom_bar)

        // Load the default fragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer,fragment_home_t.newInstance(
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
                        .replace(R.id.fragmentContainer, fragment_home_t.newInstance(
                            param1 = "param1",
                            param2 = "param2"
                        ))
                        .commit()
                    R.id.tab_add  ->  supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer,fragment_add_t.newInstance(
                            param1 = "param1",
                            param2 = "param2"
                        ))
                        .commit()
                    R.id.tab_analysis -> supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, fragment_anaytics_t.newInstance(
                            param1 = "param1",
                            param2 = "param2"
                        ))
                        .commit()

                }
            }
        })
    }

}

// Rest of your fragment cod

