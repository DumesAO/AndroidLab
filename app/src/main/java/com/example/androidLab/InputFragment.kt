package com.example.androidLab

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.android.material.textfield.TextInputEditText
import com.tapadoo.alerter.Alerter
import java.lang.ClassCastException

class InputFragment : Fragment() {

    private lateinit var onTextSentListener: OnTextSent
    private lateinit var onShowStorage: ShowStorage

    interface OnTextSent {
        fun sendData(questionText: String, answer: String)
    }

    interface ShowStorage {
        fun show()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            onTextSentListener = context as OnTextSent
            onShowStorage = context as ShowStorage
        } catch (e: ClassCastException) {
            throw ClassCastException(
                activity.toString()
                        + "  onTextSent и ShowStorage должны быть имплементироваными"
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_input, container, false)
    }

    override fun onStart() {
        super.onStart()
        val confirm = view?.findViewById(R.id.Confirm) as Button
        val storage: Button = view?.findViewById(R.id.Storage) as Button
        val question: TextInputEditText = view?.findViewById(R.id.Question) as TextInputEditText
        val yb: RadioButton = view?.findViewById(R.id.Yes) as RadioButton
        val nb: RadioButton = view?.findViewById(R.id.No) as RadioButton
        var answer = ""
        val alerter=Alerter.create(this.requireActivity())
            .setTitle("Ошибка")
            .setDuration(3000)
            .setBackgroundColorInt(Color.BLACK)
        confirm.setOnClickListener {
            val questionText = question.text.toString();
            if (yb.isChecked) {
                answer = "Да"
            } else if (nb.isChecked) {
                answer = "Нет"
            }
            if(questionText==""){
                alerter.setText("Ввведите вопрос").show()
            } else{
            if (answer==""){
                alerter.setText("Выберите ответ").show()
            } else{
                passData(questionText, answer)
            }}

        }
        storage.setOnClickListener {
            showStorage()
        }
    }

    private fun passData(questionText: String, answer: String) {
        onTextSentListener.sendData(questionText, answer)
    }

    private fun showStorage() {
        onShowStorage.show()
    }

}