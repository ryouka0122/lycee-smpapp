package com.example.samplewire.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import com.example.samplewire.R
import com.example.samplewire.entity.ClientInfo
import com.example.samplewire.toDateString
import kotlinx.android.synthetic.main.client_info.view.*

class ClientInfoView(context: Context, attrs: AttributeSet? = null) : LinearLayout(context, attrs) {
    init {
        LayoutInflater.from(context)
            .inflate(R.layout.client_info, this, true)
    }


    fun setInfo(clientInfo: ClientInfo) {

        companyName.text = clientInfo.companyName
        department.text = clientInfo.department
        clientName.text = clientInfo.clientName
        emailAddress.text = clientInfo.mailAddress
        companyTel.text = clientInfo.companyTel
        cellTel.text = clientInfo.cellTel
        companyFax.text = clientInfo.companyFax
        companyAddress.text = clientInfo.companyAddress
        regDate.text = clientInfo.regDate.toDateString()

        memo.setText(clientInfo.memo, TextView.BufferType.NORMAL)

        label.text = clientInfo.label.reduce { a, b -> "$a, $b" }

        invalidate()
        requestLayout()
    }


}