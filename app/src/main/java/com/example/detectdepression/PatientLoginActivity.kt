package com.example.detectdepression

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.ui.text.toLowerCase
import androidx.databinding.DataBindingUtil
import com.example.detectdepression.databinding.ActivityPatientLoginBinding
import com.example.detectdepression.models.PatientLoginInfo
import com.google.firebase.Firebase
import com.google.firebase.database.database

class PatientLoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityPatientLoginBinding

    private val PATIENT_ID = "PatientId"

    private var DOC_NAME = "DoctorName"

    private val ASSIGNED_PATIENT_LIST = "Assigned Patient List"

    private var assignedPatientList = ArrayList<PatientLoginInfo>()

    private var PATIENT_LIST = "Patient Login List"

    private val databaseReference = Firebase.database
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_patient_login)
    }

    fun btnNext(view : View) {

        binding.apply {

            var temp = 0

            var patientId = edtPatientIdLogin.text.toString().trim()
            var docName = edtDocNameLogin.text.toString().trim()



            if (!TextUtils.isEmpty(patientId) && !TextUtils.isEmpty(docName)) {
                for (patient in assignedPatientList) {
                    if (patient.patientId == patientId.trim() && patient.docName.toLowerCase() == docName.trim().toLowerCase()) {
                        temp = 1
                        break;
                    }
                }
                if (temp == 1) {
                    var intent = Intent(this@PatientLoginActivity,InfoActivty::class.java)
                    intent.putExtra(PATIENT_ID,patientId)
                    intent.putExtra(DOC_NAME,docName)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this@PatientLoginActivity,"Authentication Failed!!",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        databaseReference.getReference(ASSIGNED_PATIENT_LIST).get().addOnSuccessListener {
            for (patient in it.children) {
                Log.d("TAGY",patient.key.toString() + " " + patient.value.toString())
                assignedPatientList.add(PatientLoginInfo(patient.key.toString(),patient.value.toString()))
            }
        }.addOnFailureListener {
            Toast.makeText(this@PatientLoginActivity,"Authentication Failed !!",Toast.LENGTH_SHORT).show()
        }
    }

    fun loginAsDoctor(view: View) {
        startActivity(Intent(this@PatientLoginActivity,DoctorLoginActivity::class.java))
    }
}