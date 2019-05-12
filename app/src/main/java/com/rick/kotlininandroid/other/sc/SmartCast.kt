package com.rick.kotlininandroid.other.sc

// // 第六點：Kotlin 版本，Type Check and Smart Cast
fun test(obj: Any) {
    if (obj is String) obj.split("")
}