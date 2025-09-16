package com.example.lab_week_03

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentContainerView // Import this class

interface CoffeeListener {
    fun onSelected(coffeeId: Int)
}

class MainActivity : AppCompatActivity(), CoffeeListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.fragment_container)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Make sure you have created ListFragment.kt and DetailFragment.kt files
        if (savedInstanceState == null) {
            findViewById<FragmentContainerView>(R.id.fragment_container).let { containerLayout ->
                val listFragment = ListFragment() // Assumes ListFragment exists
                supportFragmentManager.beginTransaction()
                    .add(containerLayout.id, listFragment)
                    .commit()
            }
        }
    }

    override fun onSelected(id: Int) {
        findViewById<FragmentContainerView>(R.id.fragment_container).let { containerLayout ->
            val detailFragment = DetailFragment.newInstance(id) // Assumes DetailFragment exists
            supportFragmentManager.beginTransaction()
                .replace(containerLayout.id, detailFragment)
                .addToBackStack(null)
                .commit()
        }
    }
}