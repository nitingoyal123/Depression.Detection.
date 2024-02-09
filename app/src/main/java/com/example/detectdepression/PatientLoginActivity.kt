package com.example.detectdepression

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.detectdepression.databinding.ActivityPatientLoginBinding

class PatientLoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityPatientLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_patient_login)



    }

    fun loginAsDoctor(view: View) {
        startActivity(Intent(this@PatientLoginActivity,DoctorLoginActivity::class.java))
    }

}