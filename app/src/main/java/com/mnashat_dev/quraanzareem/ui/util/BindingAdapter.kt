package com.mnashat_dev.quraanzareem.ui.util

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.mnashat_dev.quraanzareem.ui.model.Juz
import com.mnashat_dev.quraanzareem.ui.model.Surh
import com.mnashat_dev.quraanzareem.ui.model.Page

@BindingAdapter("nameOfSurh")
fun TextView.setNameOfSurh(item:Surh){
    text = item.name
}

@BindingAdapter("numberOfSurh")
fun TextView.setNumberOfSurh(item:Surh){
    text = item.number
}

@BindingAdapter("nameOfjuz")
fun TextView.setNameOfjuz(item:Juz){
    text = item.name
}

@BindingAdapter("numberOfJuz")
fun TextView.setNumberOfJuz(item:Juz){
    text = item.number
}


@BindingAdapter("numberOfPage")
fun TextView.setNumberOfPage(item:Page){
    text = item.number
}