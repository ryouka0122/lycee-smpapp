package com.example.sampletablayout.views

import android.content.Context
import android.text.format.DateFormat
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import com.example.sampletablayout.R
import com.example.sampletablayout.entity.ContactHist
import kotlinx.android.synthetic.main.contact_hist_info.view.*
import java.util.*


class ContactHistInfo(context: Context, attrs: AttributeSet? = null) : CardView(context, attrs) {
    init {
        LayoutInflater.from(context)
            .inflate(R.layout.contact_hist_info, this, true)
    }


    fun setInfo(hist: ContactHist) {

        contactDate?.text = hist.username
        contactUser?.text = toDateString(hist.date)

        invalidate()
        requestLayout()
    }


    private fun toDateString(date : Date) : String {
        return DateFormat.format("yyyy/MM/dd", date).toString()
    }

}
