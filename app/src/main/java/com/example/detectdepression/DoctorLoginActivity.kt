package com.example.detectdepression

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.detectdepression.databinding.ActivityDoctorLoginBinding

class DoctorLoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDoctorLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@DoctorLoginActivity,R.layout.activity_doctor_login)





    }
}