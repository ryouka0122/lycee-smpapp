package com.example.samplecustomview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import kotlinx.android.synthetic.main.sample_contact_hist_info.view.*


class ContactHistInfo(context: Context, attrs: AttributeSet? = null) : CardView(context, attrs) {
    init {
        LayoutInflater.from(context)
            .inflate(R.layout.sample_contact_hist_info, this, true)
    }

    fun setInfo(date: String, user : String) {

        contactDate?.text = date
        contactUser?.text = user

        invalidate()
        requestLayout()
    }

}
