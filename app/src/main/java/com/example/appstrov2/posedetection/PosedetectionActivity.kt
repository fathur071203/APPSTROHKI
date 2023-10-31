package com.example.appstrov2.posedetection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appstrov2.R
import com.example.appstrov2.databinding.ActivityPosedetectionBinding

class PosedetectionActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPosedetectionBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityPosedetectionBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}