package com.example.androidLab


import androidx.fragment.app.Fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class StorageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_storage, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val storageData = arguments?.getString("storage")
        val textView: TextView = view.findViewById(R.id.storage_data) as TextView
        if (storageData == "" || storageData == null) {
            textView.text = "Результаты отсутвуют"
        } else{
            textView.text = storageData
        }
    }

}