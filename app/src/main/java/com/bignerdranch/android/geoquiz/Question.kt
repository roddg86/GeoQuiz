package com.bignerdranch.android.geoquiz

import androidx.annotation.StringRes

/* Класс модели, для хранения данных */
data class Question(@StringRes val textResId: Int, val answer: Boolean)