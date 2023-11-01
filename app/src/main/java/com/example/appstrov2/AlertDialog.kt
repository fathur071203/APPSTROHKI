package com.example.appstrov2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.appstrov2.databinding.ActivityAlertDialogBinding

class AlertDialog : AppCompatActivity() {

    private lateinit var binding : ActivityAlertDialogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAlertDialogBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
}