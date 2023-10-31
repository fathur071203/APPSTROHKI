//package com.example.appstrov2
//
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.FrameLayout
//import com.example.appstrov2.databinding.ActivityCalenderBinding
//import com.example.appstrov2.databinding.ActivityMainBinding
//import com.example.appstrov2.databinding.ActivityVideoProgramBinding
//import com.example.appstrov2.posedetection.PosedetectionActivity
//
//
//class VideoProgram : AppCompatActivity() {
//    private lateinit var binding : ActivityVideoProgramBinding
//
//    private var exoPlayer: ExoPlayer? = null
//    private var playbackPosition = 0L
//    private var playWhenReady = true
//    override fun onCreate(savedInstanceState: Bundle?) {
//        binding = ActivityVideoProgramBinding.inflate(layoutInflater)
//        super.onCreate(savedInstanceState)
//        setContentView(binding.root)
//        val frameLayout = binding.root.findViewById<FrameLayout>(R.id.root)
//
//
//
//        binding.fab.setOnClickListener {
//            startActivity(Intent(this, PosedetectionActivity::class.java))
//        }
//
//        val videoItem = MediaItem.fromUri("https://github.com/dicodingacademy/assets/releases/download/release-video/VideoDicoding.mp4")
//        val player = ExoPlayer.Builder(this).build().also { exoPlayer ->
//            exoPlayer.setMediaItem(videoItem)
//            exoPlayer.prepare()
//        }
//
//    }
//
//
//
//}