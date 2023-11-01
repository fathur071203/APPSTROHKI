package com.example.appstrov2.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appstrov2.CalenderActivity
import com.example.appstrov2.ChatActivity
import com.example.appstrov2.DetailProgramActivity
import com.example.appstrov2.ProfileActivity
import com.example.appstrov2.R
import com.example.appstrov2.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.bottomNavigationView.background = null
        binding.bottomNavigationView.menu.getItem(2).isEnabled = false

        binding.btnProgram.setOnClickListener {
            startActivity(Intent(this, DetailProgramActivity::class.java))
        }

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                }
                R.id.menu_chat -> {
                    startActivity(Intent(this, ChatActivity::class.java))
                }
                R.id.menu_calendar -> {
                    startActivity(Intent(this, CalenderActivity::class.java))
                }
                R.id.menu_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                }
            }
            true
        }

        binding





        }



}