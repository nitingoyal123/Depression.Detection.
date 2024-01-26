package com.example.detectdepression

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.detectdepression.databinding.ActivityInfoActivtyBinding

class InfoActivty : AppCompatActivity() {
    private lateinit var binding : ActivityInfoActivtyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@InfoActivty,R.layout.activity_info_activty)

    }

    fun btnNext(view : View) {
        startActivity(Intent(this@InfoActivty,ObjectiveQuestionsActivity::class.java))
    }

}