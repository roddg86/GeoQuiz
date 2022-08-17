package com.bignerdranch.android.geoquiz

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

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

        /* Слушатель щелчок кнопки */
        trueButton.setOnClickListener { view: View ->
            /* Создание уведомления по нажатию кнопки */
            val toast = Toast.makeText(this,R.string.correct_toast,Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.TOP,0,160)
            toast.show()
        }

        /* Слушатель для кнопки FALSE */
        falseButton.setOnClickListener { view: View ->
            /* Создание уведолния по нажатию кнопки */
            val toast = Toast.makeText(this,R.string.incorrect_toast,Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.TOP or Gravity.LEFT, 0, 160)
            toast.show()
        }
    }
}