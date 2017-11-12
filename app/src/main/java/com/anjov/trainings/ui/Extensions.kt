package com.anjov.trainings.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

/**
 * Created by anjov on 12/11/2017.
 */
fun Context.toast(text:CharSequence, length:Int = Toast.LENGTH_SHORT){
    Toast.makeText(this, text, length).show()
}

fun ViewGroup.inflate(layoutRes:Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}
