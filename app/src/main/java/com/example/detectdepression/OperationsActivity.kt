package com.example.detectdepression

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.detectdepression.databinding.ActivityOperationsBinding

class OperationsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityOperationsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@OperationsActivity,R.layout.activity_operations)

        val adapter = ViewPagerAdapter(supportFragmentManager)
        binding.viewPager.adapter = adapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)

    }
}