package com.example.appstrov2.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.appstrov2.ViewModelFactory
import com.example.appstrov2.databinding.ActivityLoginBinding
import androidx.activity.viewModels
import com.example.appstrov2.ui.HomeActivity
import com.example.appstrov2.ui.register.RegisterActivity
import com.example.appstrov2.data.Result
import com.example.appstrov2.data.UserPreferences
import com.example.appstrov2.data.Username

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private var modelUser : Username = Username()
    private lateinit var userPreferences: UserPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)


        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val viewModelFactory : ViewModelFactory = ViewModelFactory.getInstance(this)
        val loginViewModel : LoginViewModel by viewModels {
            viewModelFactory
        }

        binding.btnLogin.setOnClickListener {
            loginViewModel.postLogin(
                binding.EmailText.text.toString(),
                binding.PasswordText.text.toString()
            ).observe(this) {
                if (it != null) {
                    when (it) {
                        is Result.Loading -> {
                            binding.progressBar.visibility = View.VISIBLE
                        }
                        is Result.Success -> {
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(this, "Login ${it.data.message}", Toast.LENGTH_SHORT).show()
                            val saveResponse = it.data
                            tokenSave(saveResponse.loginResult.token)
                            startActivity(Intent(this, HomeActivity::class.java))
                        }
                        is Result.Error -> {
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(this, it.error, Toast.LENGTH_SHORT).show()

                        }
                    }
                }
            }
        }

        binding.txtRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }



    }
    private fun tokenSave(token: String) {
        modelUser.tokenName = token
        userPreferences.setUserPreferences(modelUser)

    }
    companion object {
        private const val EX = "EX"
    }
}