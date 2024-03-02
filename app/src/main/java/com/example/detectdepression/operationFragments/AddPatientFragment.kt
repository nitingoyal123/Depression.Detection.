package com.example.detectdepression.operationFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.detectdepression.R
import com.example.detectdepression.databinding.FragmentAddPatientBinding

class AddPatientFragment : Fragment() {
    private lateinit var binding : FragmentAddPatientBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAddPatientBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            binding.btnGenerateID.setOnClickListener {
        }
    }
}