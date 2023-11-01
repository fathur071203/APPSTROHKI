package com.example.appstrov2.ui

import android.app.Dialog
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.appstrov2.AlertDialog
import com.example.appstrov2.CalenderActivity
import com.example.appstrov2.ChatActivity
import com.example.appstrov2.DetailProgramActivity
import com.example.appstrov2.ProfileActivity
import com.example.appstrov2.R
import com.example.appstrov2.databinding.ActivityHomeBinding
import com.example.appstrov2.posedetection.PosedetectionActivity
import com.google.firebase.database.collection.LLRBNode.Color


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

        binding.fab.setOnClickListener {
            val message : String? = "Are you sure you want to start this program?"
            showDialog(message)
        }


        }

    private fun showDialog(message : String?) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.activity_alert_dialog)
        dialog.window?.setBackgroundDrawable(ColorDrawable(android.graphics.Color.WHITE))

        val tvMessage : TextView = dialog.findViewById(R.id.tv_alert_message)
        val yes : TextView = dialog.findViewById(R.id.confirm_yes_logout_button)
        val no : TextView = dialog.findViewById(R.id.confirm_no_logout_button)


        tvMessage.text = message
        yes.setOnClickListener {
            startActivity(Intent(this, PosedetectionActivity::class.java))
        }
        no.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()

    }



}