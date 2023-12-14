package com.example.appstrov2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.appstrov2.R
import com.example.appstrov2.ui.HomeActivity

class SplashScreen : AppCompatActivity() {
    private val SPLASH_TIME_OUT = 4000 // 4 detik

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        // Buat Handler untuk menunda tindakan selama beberapa detik
        Handler().postDelayed({
            // Arahkan ke aktivitas berikutnya setelah jeda waktu selesai
            val intent = Intent(this, OnBoarding::class.java)
            startActivity(intent)
            finish() // Tutup aktivitas SplashScreen agar tidak bisa kembali lagi
        }, SPLASH_TIME_OUT.toLong())
    }
}