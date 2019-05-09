package com.rick.kotlininandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class KotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        // Null Safety
        val str: String? = intent.getBundleExtra(MainActivity.INTENT_KEY)?.getString(MainActivity.ARGS_LANG)
        println(str)

        val data = MyData(str ?: "unKnown")
        println(data)
    }

    data class MyData(val str: String)

fun doThings(
    content: String,
    time: Long = System.currentTimeMillis(),
    tag: String = KotlinActivity::class.java.simpleName
) {
    // code...
}
}
