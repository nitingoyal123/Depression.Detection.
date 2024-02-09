package com.example.detectdepression

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import com.example.detectdepression.databinding.ActivityMainBinding
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date

class MainActivity : AppCompatActivity() {

    //binding
    private lateinit var binding : ActivityMainBinding

    //firestore
    private lateinit var db : FirebaseFirestore

    //collection name
    private var PATIENT_DETAIL_COLLECTION = "PatientDetails"

    //arraylist of questions
    var questions = ArrayList<String>()

    //details
    lateinit var patientName : String
    lateinit var patientAge : String
    lateinit var patientPhoneNumber : String
    lateinit var patientEmail : String
    lateinit var date : String
    var score : String = "none"
    var objectiveDepressionLevel = "none"
    var subjectiveDepressionLevel = "none"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        db = FirebaseFirestore.getInstance()
        binding.progressBar.visibility = View.INVISIBLE
//        applyEditTextChnages()
    }

    private fun loadData() {
        GlobalScope.launch(Dispatchers.IO) {

        }
    }

//    private fun applyEditTextChnages() {
//        binding.apply {
//            edtName.addTextChangedListener(changeBackground(binding.edtName))
//            edtAge.addTextChangedListener(changeBackground(binding.edtAge))
//            edtPhoneNumber.addTextChangedListener(changeBackground(binding.edtPhoneNumber))
//            edtEmail.addTextChangedListener(changeBackground(binding.edtEmail))
//        }
//    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun btnNextClicked(view : View) {
        binding.apply {
            progressBar.visibility = View.VISIBLE
            patientName = edtName.text.toString().trim()
            patientAge = edtAge.text.toString().trim()
            patientPhoneNumber = edtPhoneNumber.text.toString().trim()
            patientEmail = edtEmail.text.toString().trim()
            //current date
            val currentDate = LocalDate.now()
            val dateFormatter = DateTimeFormatter.ofPattern("d MMMM yyyy")
            date = currentDate.format(dateFormatter)



            if (TextUtils.isEmpty(patientName)) {
                edtName.setBackgroundColor(resources.getColor(R.color.purple_200))
            } else {
                edtName.background = null
            }
            if (TextUtils.isEmpty(patientAge)) {
                edtAge.setBackgroundColor(resources.getColor(R.color.purple_200))
            } else {
                edtAge.background = null
            }
            if (TextUtils.isEmpty(patientPhoneNumber)) {
                edtPhoneNumber.setBackgroundColor(resources.getColor(R.color.purple_200))
            } else {
                edtPhoneNumber.background = null
            }
            if (TextUtils.isEmpty(patientEmail)) {
                edtEmail.setBackgroundColor(resources.getColor(R.color.purple_200))
            } else {
                edtEmail.background = null
            }

            if (!(TextUtils.isEmpty(patientName) || TextUtils.isEmpty(patientAge) ||  TextUtils.isEmpty(patientPhoneNumber) || TextUtils.isEmpty(patientEmail))) {

                var details = hashMapOf<String,String>(
                    "Name" to patientName,
                    "Age" to patientAge,
                    "Phone Number" to patientPhoneNumber,
                    "Email" to patientEmail,
                    "Date" to date,
                    "Score" to "0"
                )

                db.collection(PATIENT_DETAIL_COLLECTION).document(patientEmail).set(details).addOnSuccessListener {
                    val intent = Intent(this@MainActivity,InfoActivty::class.java)
                    intent.putExtra("Email",patientEmail)
                    startActivity(intent)
                    finish()

                }.addOnFailureListener {
                    Toast.makeText(this@MainActivity,"Ooops!! Something went wrong...",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

//    fun changeBackground(editText : EditText) : TextWatcher{
//
//        val textWatcher = object : TextWatcher {
//            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//
//            }
//
//            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//
//            }
//
//            @SuppressLint("UseCompatLoadingForDrawables")
//            override fun afterTextChanged(s: Editable?) {
//                if (s.isNullOrBlank()) {
//                    editText.setBackgroundDrawable(getDrawable(R.drawable.empty_editext_background))
//                } else {
//                    editText.background = null
//                }
//            }
//
//        }
//        return textWatcher
//
//    }


}