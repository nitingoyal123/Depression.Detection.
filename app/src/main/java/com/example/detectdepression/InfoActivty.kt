package com.example.detectdepression

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.detectdepression.databinding.ActivityInfoActivtyBinding

class InfoActivty : AppCompatActivity() {
    private lateinit var binding : ActivityInfoActivtyBinding


    private val PATIENT_ID = "PatientId"
    private var DOC_NAME = "DoctorName"
    lateinit var docName : String
    lateinit var patientId : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@InfoActivty,R.layout.activity_info_activty)
        docName = intent.getStringExtra(DOC_NAME)!!
        patientId = intent.getStringExtra(PATIENT_ID)!!

    }

    fun btnNext(view : View) {
        var intent = Intent(this@InfoActivty,ObjectiveQuestionsActivity::class.java)
        intent.putExtra(PATIENT_ID,patientId)
        intent.putExtra(DOC_NAME,docName)
        startActivity(intent)
    }

}