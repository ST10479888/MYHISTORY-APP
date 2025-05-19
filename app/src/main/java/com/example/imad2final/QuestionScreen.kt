package com.example.imad2final

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QuestionScreen : AppCompatActivity() {
// Array of my questions
    private val questions = arrayOf(
        "California and texas were once part of Mexico.",
        "Humans were partly responsible for the extinction of the dinosaurs.",
        "The Hundred Years war lasted less than 100 years.",
        "The first World War began on September 1, 1914.",
        "English was the first language spoken in America."
    )
// Answers to my questions
    val answers = booleanArrayOf(true, false, false, false, false)

    var score = 0
    var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_question_screen)

        val questionText = findViewById<TextView>(R.id.textViewDisplayQuestion)
        val feedbackText = findViewById<TextView>(R.id.textViewInstantFeedback)
        val truebtn = findViewById<Button>(R.id.trueButton)
        val falseBtn = findViewById<Button>(R.id.falseButton)
        val nextBtn = findViewById<Button>(R.id.nextButton)

        fun updateQuestion(){
            questionText.text = questions[currentIndex]
            feedbackText.text = ""
            truebtn.isEnabled =  true
            falseBtn.isEnabled =  true
        }

        updateQuestion()

        truebtn.setOnClickListener {
            checkAnswer(true)
        }

        falseBtn.setOnClickListener {
            checkAnswer(false)
        }
        // If Else statements

        nextBtn.setOnClickListener {
            currentIndex++
            if (currentIndex < questions.size) {
                updateQuestion()
            } else {
                val intent = Intent(this, ScoreScreen::class.java)
                intent.putExtra("score", score)
                startActivity(intent)
                finish()
                //Title: Kotlin If ... Else
                //Author: w3schools
                //Date: 19 May 2025
                //Available: ttps://www.w3schools.com/kotlin/index.php
            }
        }
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = answers[currentIndex]
        if (userAnswer == correctAnswer){
            score++
        }
// Feedback of the answers
        val feedbackText = findViewById<TextView>(R.id.textViewInstantFeedback)
        if (userAnswer == correctAnswer) {
            feedbackText.text = "Correct"
        }else {
            feedbackText.text = "Incorrect"
        }

        findViewById<Button>(R.id.trueButton).isEnabled = false
        findViewById<Button>(R.id.falseButton).isEnabled =  false
    }



    }
