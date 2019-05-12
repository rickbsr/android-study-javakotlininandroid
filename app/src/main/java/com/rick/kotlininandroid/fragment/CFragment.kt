package com.rick.kotlininandroid.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.rick.kotlininandroid.R
import com.rick.kotlininandroid.spec.ReportFragment

class CFragment : ReportFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment, container, false)
        (view.findViewById<View>(R.id.textView) as TextView).text = CFragment::class.java.simpleName
        return view
    }

// 第六點：Kotlin 版本，Singleton by Kotlin
companion object {
    val instance = CFragment()
}
}