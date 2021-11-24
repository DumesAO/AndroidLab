package com.example.Lab1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ResultFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val questionText = arguments?.getString("questionText")
        val ybChecked = arguments?.getBoolean("ybChecked")
        val nbChecked = arguments?.getBoolean("nbChecked")

        val textView: TextView = view?.findViewById(R.id.result) as TextView

                val answer:String = if(ybChecked == true){
                    "Да"
                } else{
                    "Нет"
                }
                "Вопрос: $questionText\nОтвет: $answer".also { textView.text = it }
            }
        }