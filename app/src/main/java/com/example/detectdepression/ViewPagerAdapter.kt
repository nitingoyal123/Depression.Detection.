package com.example.detectdepression

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm) {

    private val fragments = listOf(
        HomeFragment(),
        PersonalInfoFragment(),
        PatientListFragment()
    )
    override fun getCount(): Int {
        return fragments.size
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "Home"
            1 -> "Personal Info"
            2 -> "Patient Details"
            else -> ""
        }
    }
}