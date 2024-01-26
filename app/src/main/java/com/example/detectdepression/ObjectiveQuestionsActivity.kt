package com.example.detectdepression

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.detectdepression.databinding.ActivityObjectiveQuestionsBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ObjectiveQuestionsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityObjectiveQuestionsBinding

    private lateinit var database: FirebaseDatabase

    private lateinit var reference : DatabaseReference

    private var QUESTION_NUMBER = 1

    private var SCORE = "score"

    private var score = 0

    private var scoreArray = ArrayList<Int>()

    private var TOTAL_QUESTIONS = 9

    private var questions = ArrayList<String>()

    private var OBJECTIVE_QUESTIONS = "ObjectiveQuestions"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_objective_questions)
        database = Firebase.database
        reference = database.getReference(OBJECTIVE_QUESTIONS)

        loadQuestions()

        binding.btnNext.setOnClickListener {
            btnNext()
        }
    }

    private fun loadQuestions() {

        reference.get().addOnSuccessListener {
            for (question in it.children) {
                questions.add(question.value.toString())
                scoreArray.add(0)
                Log.d("TGAY",question.value.toString())
            }
            binding.progressBar2.visibility = View.INVISIBLE
            binding.constraintLayout.visibility = View.VISIBLE
            setQuestions()

        }.addOnFailureListener {
            Toast.makeText(this@ObjectiveQuestionsActivity,"Oops!! Something went wrong...", Toast.LENGTH_SHORT).show()
        }
    }

    private fun btnNext() {

        binding.apply {

            if (options.checkedRadioButtonId == -1) {
                Toast.makeText(this@ObjectiveQuestionsActivity,"Select one of the above options !!",Toast.LENGTH_SHORT).show()
            } else {
                when (options.checkedRadioButtonId) {
                    opt1.id -> {
                        scoreArray[QUESTION_NUMBER-1] = 0
                    }opt2.id -> {
                        scoreArray[QUESTION_NUMBER-1] = 1
                    }opt3.id -> {
                        scoreArray[QUESTION_NUMBER-1] = 2
                    } else -> {
                        scoreArray[QUESTION_NUMBER-1] = 3
                    }
                }
                options.clearCheck()
                if (QUESTION_NUMBER == TOTAL_QUESTIONS || btnNext.text.toString() == "Submit") {

                    //calculate total score
                    for (i in scoreArray) {
                        score += i
                    }
                    Toast.makeText(this@ObjectiveQuestionsActivity, "SCORE : $score", Toast.LENGTH_SHORT).show()

                    //next activity
                    startActivity(Intent(this@ObjectiveQuestionsActivity,SubjectiveQuestionsActivity::class.java))
                    finish()


                } else {
                    QUESTION_NUMBER++
                    setQuestions()
                }
            }
        }
    }

    private fun setQuestions() {

        binding.apply {

            txtQuestion.text = questions[QUESTION_NUMBER-1]

            if (QUESTION_NUMBER == 1) {
                btnPrevious.text = "Back"
            } else {
                btnPrevious.text = "Previous"
            }
            if (QUESTION_NUMBER == TOTAL_QUESTIONS) {
                btnNext.text = "Submit"
            } else {
                btnNext.text = "Next"
            }

        }
    }
}