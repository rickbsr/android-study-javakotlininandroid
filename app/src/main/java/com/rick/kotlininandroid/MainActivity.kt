package com.rick.kotlininandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val INTENT_KEY = "intent_key"
        const val ARGS_LANG = "args_lang"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_java.setOnClickListener {
            transActivity(Intent(this, JavaActivity::class.java))
        }

        btn_kotlin.setOnClickListener {
            transActivity(Intent(this, KotlinActivity::class.java))
        }
    }

    fun transActivity(intent: Intent) {
        var args = Bundle()
        args.putString(ARGS_LANG, "Test")
        intent.putExtra(INTENT_KEY, args)
        startActivity(intent)
    }
}
