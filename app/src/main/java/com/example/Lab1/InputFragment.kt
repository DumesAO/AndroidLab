package com.example.Lab1

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.android.material.textfield.TextInputEditText
import java.lang.ClassCastException

class InputFragment : Fragment() {

    private lateinit var onTextSentListener: OnTextSent

    interface OnTextSent {
        fun sendData(questionText: String, ybChecked: Boolean, nbChecked: Boolean)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            onTextSentListener = context as OnTextSent
        } catch (e: ClassCastException) {
            throw ClassCastException(
                activity.toString()
                        + " must implement onTextSent"
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val confirm=view?.findViewById(R.id.Confirm) as Button
        val question: TextInputEditText =view?.findViewById(R.id.Question) as  TextInputEditText
        val yb: RadioButton = view?.findViewById(R.id.Yes) as RadioButton
        val nb: RadioButton =view?.findViewById(R.id.No) as RadioButton
        var ybChecked = false
        var nbChecked = false
        confirm.setOnClickListener {
            val questionText= question.text.toString();
            if(yb.isChecked) { ybChecked = true }
            if(nb.isChecked){ nbChecked = true }
            passData(questionText, ybChecked, nbChecked)
        }
    }

    private fun passData(questionText: String, ybChecked: Boolean, nbChecked: Boolean) {
        onTextSentListener.sendData(questionText, ybChecked, nbChecked)
    }

}