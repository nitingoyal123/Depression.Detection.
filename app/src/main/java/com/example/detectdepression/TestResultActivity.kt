package com.example.detectdepression

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.detectdepression.databinding.ActivityTestResultBinding

class TestResultActivity : AppCompatActivity() {
    private lateinit var binding : ActivityTestResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@TestResultActivity,R.layout.activity_test_result)



    }
}