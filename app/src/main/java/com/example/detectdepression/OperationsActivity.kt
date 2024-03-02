package com.example.detectdepression

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.detectdepression.databinding.ActivityOperationsBinding
import com.example.detectdepression.models.PatientListItemInfo
import com.example.detectdepression.operationFragments.AddPatientFragment
import com.example.detectdepression.operationFragments.HomeFragment
import com.example.detectdepression.operationFragments.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class OperationsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityOperationsBinding

    var patientListItemInfo = ArrayList<PatientListItemInfo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@OperationsActivity,R.layout.activity_operations)

        binding.apply {
            bottomNavigationOperation.selectedItemId = R.id.homeNavigation
            bottomNavigationOperation.setOnItemSelectedListener(navListener)
        }

        supportFragmentManager.beginTransaction().replace(
            binding.frameLayout.id,
            HomeFragment()
        ).commit()

    }

    private val navListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            var selectedFragment: Fragment? = null
            when (item.itemId) {
                R.id.addPatientNavigation -> selectedFragment = AddPatientFragment()
                R.id.homeNavigation -> selectedFragment = HomeFragment()
                R.id.settingsNavigation -> selectedFragment = SettingsFragment()
            }
            supportFragmentManager.beginTransaction().replace(
                binding.frameLayout.id,
                selectedFragment!!
            ).commit()
            true
        }

}