package com.rick.kotlininandroid.other.serializable

import java.io.Serializable

// 第三點：Kotlin 版本，值物件，實作 Serializable
data class KotlinInfo(
    val title: String,
    val content: String
) : Serializable