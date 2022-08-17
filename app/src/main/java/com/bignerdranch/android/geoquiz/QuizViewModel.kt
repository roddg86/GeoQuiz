package com.bignerdranch.android.geoquiz

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"

/* свой подкласс ViewModel */
/* QuizViewModel не уничтожается при повороте, и MainActivity сохраняет данные о состоянии
интерфейса своей activity в экземпляре QuizViewModel, который после поворота тоже сохраняется */
/* ViewModel хранит все данные, связанные с потребностями экрана */
class QuizViewModel : ViewModel() {
    var currentIndex = 0

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )

    /* Добавление бизнес-логики */
    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer

    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }
}