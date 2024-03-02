package com.example.detectdepression

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.detectdepression.databinding.PatientListItemBinding
import com.example.detectdepression.models.PatientListItemInfo

class PatientListRecyclerViewAdapter(var context: Context,var patientList : MutableList<PatientListItemInfo>) : RecyclerView.Adapter<PatientListRecyclerViewAdapter.MyViewHolder>() {

    class MyViewHolder(var binding : PatientListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data : PatientListItemInfo) {
            binding.patientListItemInfo = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(PatientListItemBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun getItemCount(): Int {
        return patientList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(patientList[position])
    }
}