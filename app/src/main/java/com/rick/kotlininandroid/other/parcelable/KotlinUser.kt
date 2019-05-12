package com.rick.kotlininandroid.other.parcelable

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// 第三點：Kotlin 版本，值物件，實作 Parcelable，需要 Android Extension，在 Gradle 中要加入 experimental = true
@Parcelize
data class KotlinUser(
    val id: Long,
    val name: String,
    val address: String,
    val description: String,
    val profileImageUrl: String
) : Parcelable