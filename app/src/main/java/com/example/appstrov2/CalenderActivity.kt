package com.example.appstrov2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appstrov2.databinding.ActivityCalenderBinding

class CalenderActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCalenderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCalenderBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}