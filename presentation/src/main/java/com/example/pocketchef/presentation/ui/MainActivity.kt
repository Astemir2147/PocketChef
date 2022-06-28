package com.example.pocketchef.presentation.ui

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.pocketchef.presentation.R
import com.example.pocketchef.presentation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val navController by lazy { Navigation.findNavController(this, R.id.nav_host_fragment_activity_main) }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupNav()
        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    private fun setupNav() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.loginFragment -> {
                    hideBottomNav()

                }
                else -> showBottomNavigation()
            }
        }
    }
    private fun hideBottomNav() {
        findViewById<BottomNavigationView>(R.id.nav_view).visibility = View.GONE
    }

    private fun showBottomNavigation() {
        findViewById<BottomNavigationView>(R.id.nav_view).visibility = View.VISIBLE
    }
}