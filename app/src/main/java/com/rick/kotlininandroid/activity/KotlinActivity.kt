package com.rick.kotlininandroid.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.fragment.app.Fragment
import com.rick.kotlininandroid.MainActivity
import com.rick.kotlininandroid.R
import com.rick.kotlininandroid.ext.setOnTextChangedListener
import com.rick.kotlininandroid.fragment.AFragment
import com.rick.kotlininandroid.fragment.BFragment
import com.rick.kotlininandroid.fragment.CFragment
import com.rick.kotlininandroid.spec.MyGestureListener
import com.rick.kotlininandroid.spec.Reportable
import kotlinx.android.synthetic.main.activity_kotlin.*

class KotlinActivity : AppCompatActivity() {

    private lateinit var mDetector: GestureDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        mDetector = GestureDetector(this, object : MyGestureListener() {
            override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
                if (e1 != null && e2 != null) {
                    var idx: Int = getCurrentFragmentIdx()
                    when {
                        e1.x - e2.x > FLIP_DISTANCE -> {
                            println("向左滑...")
                            transFragmentPage(++idx)
                            return true

                        }
                        e2.x - e1.x > FLIP_DISTANCE -> {
                            println("向右滑...")
                            transFragmentPage(--idx)
                            return true
                        }
                    }
                }
                return false
            }

            fun getCurrentFragmentIdx(): Int {
                return when (currentFragment) {
                    is AFragment -> 0
                    is BFragment -> 1
                    is CFragment -> 2
                    else -> -1
                }
            }
        })

        // EditText
        editText.setOnTextChangedListener {
            println("text Changed")
        }

        // 第一點：Kotlin 版本，可以直接呼叫
        textView.text = "Hello, Kotlin!"

        // 第二點：Kotlin 版本，藉由 Null Safety 的機制，讓程式碼變得非常簡潔
        val str: String? = intent.getBundleExtra(MainActivity.INTENT_KEY)?.getString(MainActivity.ARGS_LANG)
        println(str)

        val data = MyData(str ?: "unKnown")
        println(data)

        transFragmentPage()
    }

    // 第三點：Kotlin 版本，值物件
    data class MyData(val str: String)

    // 第四點：Kotlin 版本，多載
    fun doThings(
        content: String,
        time: Long = System.currentTimeMillis(),
        tag: String = KotlinActivity::class.java.simpleName
    ) {
        // code...
    }

    lateinit var currentFragment: Fragment

    private fun transFragmentPage(idx: Int = 0) {
        currentFragment = when (idx) {
            0 -> AFragment()
            1 -> BFragment()
            2 -> CFragment()
            else -> return
        }
        supportFragmentManager.beginTransaction().replace(R.id.container, currentFragment).commit()
    }

    override fun onDestroy() {
        // Safety Cast
        (currentFragment as? Reportable)?.report(currentFragment::class.simpleName) // 需要 kotlin-reflect

        // Type Check and Smart Cast
//        currentFragment?.let {
//            if (it is Reportable) it.report(currentFragment::class.simpleName)
//        }
        super.onDestroy()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return mDetector.onTouchEvent(event)
    }
}
