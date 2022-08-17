package com.bignerdranch.android.geoquiz

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: ImageButton
    private lateinit var prevButton: ImageButton
    private lateinit var questionTextView: TextView

    /* Создадим список обьектов вопросов */
    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )

    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate(Bundle?) called")
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)
        prevButton = findViewById(R.id.prev_button)
        questionTextView = findViewById(R.id.question_text_view)

        trueButton.setOnClickListener { view: View ->
            checkAnswer(true)
        }

        falseButton.setOnClickListener { view: View ->
            checkAnswer(false)
        }

        /* Слушатель для кнопки Next */
        nextButton.setOnClickListener { view: View ->
            nextQuestion()
            updateQuestion()
        }

        /* Добавление кнопки возврата */
        prevButton.setOnClickListener { viev: View ->
            prevQuestion()
            updateQuestion()
        }

        /* слушатель для TextView */
        questionTextView.setOnClickListener { view: View ->
            nextQuestion()
            updateQuestion()
        }

        updateQuestion()
    }

    /* Переопределим функции жизненного цикла MainActivity */
    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"onDestroy() called")
    }

    /* Инкапсуляция с помощью функции */
    private fun updateQuestion() {
        /* Отобразим вопрос из списка */
        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
    }

    /* Функция получает логическую переменную, которая
    указывает, какую кнопку нажал пользователь: TRUE или FALSE.
    Ответ пользователя проверяется по ответу текущего объекта
    Question. Наконец, после определения правильности ответа
    функция создает Toast для вывода соответствующего
    сообщения. */
    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionBank[currentIndex].answer

        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
    }

    /* функция следующего вопроса */
    private fun nextQuestion() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }

    /* функция возвращение к предыдущему вопросу */
    private fun prevQuestion() {
        currentIndex = (currentIndex - 1) % questionBank.size
    }
}