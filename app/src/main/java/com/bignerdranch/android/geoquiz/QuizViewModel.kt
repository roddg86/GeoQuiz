package com.bignerdranch.android.geoquiz

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"

/* свой подкласс ViewModel */
/* QuizViewModel не уничтожается при повороте, и MainActivity сохраняет данные о состоянии
интерфейса своей activity в экземпляре QuizViewModel, который после поворота тоже сохраняется */
class QuizViewModel:ViewModel() {
    init {
        Log.d(TAG,"ViewModel instance created")
    }

    /* Функция onCleared() вызывается непосредственно перед
    уничтожением View Model */
    override fun onCleared() {
        super.onCleared()
        Log.d(TAG,"ViewModel instance about to be destroyed")
    }
}