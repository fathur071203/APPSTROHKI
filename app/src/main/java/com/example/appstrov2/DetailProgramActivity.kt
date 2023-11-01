package com.example.appstrov2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appstrov2.databinding.ActivityDetailProgramBinding

class DetailProgramActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailProgramBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityDetailProgramBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnProgram.setOnClickListener {
            startActivity(Intent(this, VideoProgramActivity::class.java))
        }
    }
}