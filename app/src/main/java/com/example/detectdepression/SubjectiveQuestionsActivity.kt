package com.example.detectdepression

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.detectdepression.databinding.ActivitySubjectiveQuestionsBinding

class SubjectiveQuestionsActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySubjectiveQuestionsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@SubjectiveQuestionsActivity,R.layout.activity_subjective_questions)
    }
}