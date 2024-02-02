package com.example.appstrov2.posedetection
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.example.appstrov2.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.mediapipe.tasks.vision.core.RunningMode
import com.google.mediapipe.tasks.vision.poselandmarker.PoseLandmarker
import com.google.mediapipe.tasks.vision.poselandmarker.PoseLandmarkerResult
import kotlin.math.atan2

class OverlayView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private var results: PoseLandmarkerResult? = null
    private var pointPaint = Paint()
    private var linePaint = Paint()

    private var scaleFactor: Float = 1f
    private var imageWidth: Int = 1
    private var imageHeight: Int = 1

    private var databaseReference: DatabaseReference
    private var movementCategory: String = ""

    init {
        initPaints()
        // Inisialisasi Firebase Database
        databaseReference = FirebaseDatabase.getInstance().getReference("pose_detection_results")
    }

    private fun initPaints() {
        linePaint.color = ContextCompat.getColor(context!!, R.color.mp_color_primary)
        linePaint.strokeWidth = LANDMARK_STROKE_WIDTH
        linePaint.style = Paint.Style.STROKE
        pointPaint.color = Color.BLACK
        pointPaint.strokeWidth = LANDMARK_STROKE_WIDTH
        pointPaint.style = Paint.Style.FILL
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        results?.let { poseLandmarkerResult ->
            for (landmark in poseLandmarkerResult.landmarks()) {
                for (normalizedLandmark in landmark) {
                    canvas.drawPoint(
                        normalizedLandmark.x() * imageWidth * scaleFactor,
                        normalizedLandmark.y() * imageHeight * scaleFactor,
                        pointPaint
                    )
                }

                PoseLandmarker.POSE_LANDMARKS.forEach {
                    val startLandmark = poseLandmarkerResult.landmarks().get(0).get(it!!.start())
                    val endLandmark = poseLandmarkerResult.landmarks().get(0).get(it.end())

                    // Draw lines
                    canvas.drawLine(
                        startLandmark.x() * imageWidth * scaleFactor,
                        startLandmark.y() * imageHeight * scaleFactor,
                        endLandmark.x() * imageWidth * scaleFactor,
                        endLandmark.y() * imageHeight * scaleFactor,
                        linePaint
                    )

                    if (it.start() in 11..15 && it.end() in 13..17) {
                        val angleDegrees = calculateAngle(
                            startLandmark.x(),
                            startLandmark.y(),
                            poseLandmarkerResult.landmarks().get(0).get(it.end()).x(),
                            poseLandmarkerResult.landmarks().get(0).get(it.end()).y()
                        )
                        val angleName = when (it.end()) {
                            13 -> "Sudut Bahu Kanan"
                            14 -> "Sudut Bahu Kiri"
                            15 -> "Sudut Tangan Kanan"
                            16 -> "Sudut Tangan Kiri"
                            else -> ""
                        }
                        canvas.drawText(
                            "$angleName sudut: ${angleDegrees}°",
                            startLandmark.x() * imageWidth * scaleFactor,
                            startLandmark.y() * imageHeight * scaleFactor,
                            pointPaint
                        )
                    } else if (it.start() in 23..27 && it.end() in 24..28 && it.end() != 25) {
                        val angleDegrees = calculateAngle(
                            startLandmark.x(),
                            startLandmark.y(),
                            poseLandmarkerResult.landmarks().get(0).get(it.end()).x(),
                            poseLandmarkerResult.landmarks().get(0).get(it.end()).y()
                        )
                        val angleName = when (it.end()) {
                            24 -> "Sudut Pinggul Kanan"
                            26 -> "Sudut Pinggul Kiri"
                            27 -> "Sudut Lutut Kanan"
                            28 -> "Sudut Lutut Kiri"
                            else -> ""
                        }
                        canvas.drawText(
                            "$angleName sudut: ${angleDegrees}°",
                            startLandmark.x() * imageWidth * scaleFactor,
                            startLandmark.y() * imageHeight * scaleFactor,
                            pointPaint
                        )
                    } else if ((it.start() == 32 && it.end() == 33) || (it.start() == 29 && it.end() == 30)) {
                        val angleDegrees = calculateAngle(
                            startLandmark.x(),
                            startLandmark.y(),
                            poseLandmarkerResult.landmarks().get(0).get(it.end()).x(),
                            poseLandmarkerResult.landmarks().get(0).get(it.end()).y()
                        )
                        canvas.drawText(
                            "${it} sudut: ${angleDegrees}°",
                            startLandmark.x() * imageWidth * scaleFactor,
                            startLandmark.y() * imageHeight * scaleFactor,
                            pointPaint
                        )
                    }
                }
                val sudutTanganKanan = calculateAngle(
                    poseLandmarkerResult.landmarks().get(0).get(15).x(),
                    poseLandmarkerResult.landmarks().get(0).get(15).y(),
                    poseLandmarkerResult.landmarks().get(0).get(16).x(),
                    poseLandmarkerResult.landmarks().get(0).get(16).y()
                )

                val sudutPinggulKanan = calculateAngle(
                    poseLandmarkerResult.landmarks().get(0).get(24).x(),
                    poseLandmarkerResult.landmarks().get(0).get(24).y(),
                    poseLandmarkerResult.landmarks().get(0).get(26).x(),
                    poseLandmarkerResult.landmarks().get(0).get(26).y()
                )
                val sudutBahuKanan = calculateAngle(
                    poseLandmarkerResult.landmarks().get(0).get(24).x(),
                    poseLandmarkerResult.landmarks().get(0).get(24).y(),
                    poseLandmarkerResult.landmarks().get(0).get(26).x(),
                    poseLandmarkerResult.landmarks().get(0).get(26).y()
                )

                // Add similar calculations for left knee
                val sudutLututKanan = calculateAngle(
                    poseLandmarkerResult.landmarks().get(0).get(27).x(),
                    poseLandmarkerResult.landmarks().get(0).get(27).y(),
                    poseLandmarkerResult.landmarks().get(0).get(28).x(),
                    poseLandmarkerResult.landmarks().get(0).get(28).y()
                )

                val sudutLututKiri = calculateAngle(
                    poseLandmarkerResult.landmarks().get(0).get(23).x(),
                    poseLandmarkerResult.landmarks().get(0).get(23).y(),
                    poseLandmarkerResult.landmarks().get(0).get(24).x(),
                    poseLandmarkerResult.landmarks().get(0).get(24).y()
                )


                val sudut = if (sudutLututKanan >= 0f && sudutLututKanan <= 90f) {
                    "Gerakan Sempurna"
                } else if (sudutLututKanan > 120f && sudutLututKanan <= 240f) {
                    "Gerakan Tidak Sempurna"
                } else {
                    "Gerakan Tidak Sempurna"
                }


                val textPaint = Paint()
                textPaint.textSize = 40f
                textPaint.textAlign = Paint.Align.CENTER
                val centerX = width / 2f
                val centerY = height / 3f

                // Berdasarkan sudut, tentukan warna teks
                textPaint.color = when (sudut) {
                    "Gerakan Sempurna" -> Color.GREEN
                    "Gerakan Tidak Sempurna" -> Color.YELLOW
                    "Tidak Bergerak" -> Color.RED
                    else -> Color.WHITE
                }

                canvas.drawText(sudut, centerX, centerY, textPaint)


//                // Tampilkan kategori gerakan
//                when (movementCategory) {
//                    "gerakansempurna" -> {
//                        val textPaint = Paint()
//                        textPaint.color = Color.WHITE
//                        textPaint.textSize = 80f
//                        textPaint.textAlign = Paint.Align.CENTER
//                        val centerX = width / 2f
//                        val centerY = height / 2f
//                        canvas.drawText("Gerakan Sempurna", centerX, centerY, textPaint)
//                    }
//                    "tidaksempurna" -> {
//                        val textPaint = Paint()
//                        textPaint.color = Color.WHITE
//                        textPaint.textSize = 80f
//                        textPaint.textAlign = Paint.Align.CENTER
//                        val centerX = width / 2f
//                        val centerY = height / 2f
//                        canvas.drawText("Gerakan Tidak Sempurna", centerX, centerY, textPaint)
//                    }
//                    "tidakbergerak" -> {
//                        val textPaint = Paint()
//                        textPaint.color = Color.WHITE
//                        textPaint.textSize = 80f
//                        textPaint.textAlign = Paint.Align.CENTER
//                        val centerX = width / 2f
//                        val centerY = height / 2f
//                        canvas.drawText("Tidak Bergerak", centerX, centerY, textPaint)
//                    }
//                    else -> {
//                        // Tidak ada kategori yang cocok, tidak ada teks ditampilkan
//                    }
//                }
            }
        }
    }

    private fun calculateAngle(x1: Float, y1: Float, x2: Float, y2: Float): Float {
        val angleRadians = atan2(y2 - y1, x2 - x1)
        var angleDegrees = Math.toDegrees(angleRadians.toDouble()).toFloat()
        if (angleDegrees < 0) {
            angleDegrees += 360
        }
        return angleDegrees
    }

    fun setResults(
        poseLandmarkerResults: PoseLandmarkerResult,
        imageHeight: Int,
        imageWidth: Int,
        runningMode: RunningMode = RunningMode.IMAGE
    ) {
        results = poseLandmarkerResults
        this.imageHeight = imageHeight
        this.imageWidth = imageWidth
        scaleFactor = when (runningMode) {
            RunningMode.IMAGE,
            RunningMode.VIDEO -> {
                kotlin.math.min(width * 1f / imageWidth, height * 1f / imageHeight)
            }
            RunningMode.LIVE_STREAM -> {
                kotlin.math.max(width * 1f / imageWidth, height * 1f / imageHeight)
            }
        }
        invalidate()
    }

    // Fungsi untuk mengatur kategori gerakan
    fun setMovementCategory(category: String) {
        movementCategory = category
        invalidate()
    }

    companion object {
        private const val LANDMARK_STROKE_WIDTH = 12F
    }
}
