package com.example.detectdepression

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.detectdepression.databinding.ActivitySubjectiveQuestionsBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SubjectiveQuestionsActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySubjectiveQuestionsBinding

    private var QUESTION_NUMBER = 1

    private var SUBJECTIVE_QUESTIONS = "SubjectiveQuestions"

    private var questions = ArrayList<String>()

    private var TOTAL_QUESTIONS = 0

    private var score = 0

    private lateinit var reference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@SubjectiveQuestionsActivity,R.layout.activity_subjective_questions)
        reference = FirebaseDatabase.getInstance().getReference(SUBJECTIVE_QUESTIONS)

        if (questions.size == 0) {
            loadQuestions()
        } else {
            setQuestion()
        }

        binding.btnPrevious.setOnClickListener {
            btnPrevious()
        }

        binding.btnNext.setOnClickListener {
            btnNext()
        }

    }

    private fun loadQuestions() {
        binding.apply {
            progressBar2.visibility = View.VISIBLE
            constraintLayout.visibility = View.INVISIBLE
            reference.get().addOnSuccessListener {
                for (question in it.children) {
                    questions.add(question.value.toString())
                    TOTAL_QUESTIONS++
                }
                progressBar2.visibility = View.INVISIBLE
                constraintLayout.visibility = View.VISIBLE
                setQuestion()
            }.addOnFailureListener {
                Toast.makeText(this@SubjectiveQuestionsActivity,"Oops! Something went wrong",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setQuestion() {

        binding.apply {

            txtQuestion.text = questions[QUESTION_NUMBER-1]

            if (QUESTION_NUMBER == 1) {
                btnPrevious.visibility = View.INVISIBLE
                btnPrevious.isClickable = false
            } else {
                btnPrevious.visibility = View.VISIBLE
                btnPrevious.isClickable = true
                btnPrevious.text = "Previous"
            }
            if (QUESTION_NUMBER == TOTAL_QUESTIONS) {
                btnNext.text = "Submit"
            } else {
                btnNext.text = "Next"
            }

        }
    }


    private fun btnPrevious() {
        if (QUESTION_NUMBER > 1) {
            QUESTION_NUMBER--
            setQuestion()
        }
    }

    fun btnNext() {

        if (QUESTION_NUMBER == TOTAL_QUESTIONS) {
            startActivity(Intent(this@SubjectiveQuestionsActivity,TestResultActivity::class.java))
        } else {
            QUESTION_NUMBER++
            setQuestion()
            binding.edtAns.setText("")
        }

    }

}