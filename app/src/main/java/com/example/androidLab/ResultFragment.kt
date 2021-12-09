package com.example.androidLab

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import java.io.BufferedWriter
import java.io.FileOutputStream
import java.lang.Exception

class ResultFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onStart() {
        super.onStart()
        val questionText = arguments?.getString("questionText") as String
        val answer = arguments?.getString("answer") as String
        val result = "Вопрос: $questionText  Ответ: $answer"
        val textView: TextView = view?.findViewById(R.id.result) as TextView
        textView.text = result
        val fileOutputStream: FileOutputStream
        try {
            fileOutputStream =
                requireContext().openFileOutput("AndroidLabData", Context.MODE_APPEND)
            fileOutputStream.write(("$result ; ").toByteArray())
            Toast.makeText(requireContext(), "Результат сохранен", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}