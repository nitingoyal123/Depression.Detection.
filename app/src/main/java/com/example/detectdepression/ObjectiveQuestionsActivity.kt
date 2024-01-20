package com.example.detectdepression

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.detectdepression.databinding.ActivityObjectiveQuestionsBinding

class ObjectiveQuestionsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityObjectiveQuestionsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_objective_questions)
    }
}