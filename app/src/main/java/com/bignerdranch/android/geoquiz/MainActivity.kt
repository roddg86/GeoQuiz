package com.bignerdranch.android.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

/* AppCompatActivity Это подкласс, наследующий от класса Android Activity и
обеспечивающий поддержку старых версий Android. */
class MainActivity : AppCompatActivity() {
    /* указать компилятору, что мы введём ненулевое значение
    View перед попыткой использовать содержимое свойства. */
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        /* объекты не появляются в памяти до тех пор, пока в onCreate(...) не будет вызвана
        функция setContentView(...) */
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* Ищем и назначаем обьектам представления соответствующие свойства */
        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
    }
}