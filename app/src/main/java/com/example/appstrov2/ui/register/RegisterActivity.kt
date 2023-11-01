package com.example.appstrov2.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.appstrov2.R
import com.example.appstrov2.ViewModelFactory
import com.example.appstrov2.data.Result
import com.example.appstrov2.databinding.ActivityRegisterBinding
import com.example.appstrov2.ui.login.LoginActivity

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val factory : ViewModelFactory = ViewModelFactory.getInstance(this)
        val registerViewModel : RegisterViewModel by viewModels { factory }

        binding.btnRegister.setOnClickListener {
            registerViewModel.register(
                binding.edtName.text.toString(),
                binding.EmailText.text.toString(),
                binding.PasswordText.text.toString()
            ).observe(
                this,
            ) {
                if (it != null) {
                    when (it) {
                        is Result.Loading -> {
                            binding.progressBar.visibility = android.view.View.VISIBLE
                        }
                        is Result.Success -> {
                            binding.progressBar.visibility = android.view.View.GONE
                            Toast.makeText(this, "Register Success", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this, LoginActivity::class.java))
                        }
                        is Result.Error -> {
                            binding.progressBar.visibility = android.view.View.GONE
                            Toast.makeText(this, it.error, Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
        binding.txtLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}