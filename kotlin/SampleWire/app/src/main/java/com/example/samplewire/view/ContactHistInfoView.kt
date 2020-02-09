package com.example.samplewire.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import com.example.samplewire.R
import com.example.samplewire.entity.ContactHist
import com.example.samplewire.toDateString
import kotlinx.android.synthetic.main.contact_hist_info.view.*


class ContactHistInfoView(context: Context, attrs: AttributeSet? = null) : CardView(context, attrs) {
    init {
        LayoutInflater.from(context)
            .inflate(R.layout.contact_hist_info, this, true)
    }

    fun setInfo(hist: ContactHist) {

        contactDate?.text = hist.username
        contactUser?.text = hist.date.toDateString()

        invalidate()
        requestLayout()
    }

}
