package com.example.samplewire.fragment

import android.content.Context
import androidx.fragment.app.Fragment

abstract class TabFragment(protected val parent: Context, private val mTitle : String) : Fragment() {

    fun title(): String = mTitle

}