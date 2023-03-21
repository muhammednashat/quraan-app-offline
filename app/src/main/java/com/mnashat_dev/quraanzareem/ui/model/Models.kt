package com.mnashat_dev.quraanzareem.ui.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Surh(
    val name: String,
    val number: String,
    val page: Int

) : Parcelable

@Parcelize
data class Juz(
    val name: String,
    val number: String,
    val page: Int
):Parcelable

@Parcelize
data class Page(
    val number: String,
//    val page: Int
) : Parcelable

