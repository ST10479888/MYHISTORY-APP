package com.example.imad2final

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ScoreScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score_screen)
// Array of my questions
        val questions = arrayOf(
            "California and texas were once part of Mexico.",
            "Humans were partly responsible for the extinction of the dinosaurs.",
            "The Hundred Years war lasted less than 100 years.",
            "The first World War began on September 1, 1914.",
            "English was the first language spoken in America."
        )
// Answers to my question
        val answers = booleanArrayOf(true, false, false, false, false)

        val score = intent.getIntExtra("score", 0)

        val scoreTextView = findViewById<TextView>(R.id.textViewScore)
        val feedbackTextView = findViewById<TextView>(R.id.textViewFeedback)
        val reviewTextView = findViewById<TextView>(R.id.textViewReview)
        val reviewButton = findViewById<Button>(R.id.reviewButton)
        val exitButton = findViewById<Button>(R.id.exitButton)

        scoreTextView.text = "Score is : $score / 5"
// user scores out of 5
        feedbackTextView.text  = when (score) {
            in 3..5 -> "Weldone"
            in 1..2 -> "Try Again"
            else -> "Falied"
        }

        reviewButton.setOnClickListener {
            val builder = StringBuilder()
            for (i in questions.indices) {
                builder.append("Q${i + 1}: ${questions[i]}\n\n")
            }
            reviewTextView.text = builder.toString()

        }

        exitButton.setOnClickListener {
            finishAffinity()
        }

        }
    }
