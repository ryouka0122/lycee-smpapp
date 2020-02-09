package com.example.samplewire.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.samplewire.R
import com.example.samplewire.entity.ContactHist
import com.example.samplewire.view.ContactHistInfoView
import kotlinx.android.synthetic.main.tab_contact_hist.*


class TabContactHistFragment(context: Context) : TabFragment(context, "商談履歴") {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tab_contact_hist, container, false)
    }

    private var mContactHistList : Array<ContactHist>? = null

    var contactHistList : Array<ContactHist>?
        get() = mContactHistList
        set(value) {
            mContactHistList = value
        }

    override fun onStart() {
        super.onStart()

        mContactHistList?: return

        contactHistLayout.removeAllViews()
        mContactHistList!!.forEach {
            val view = ContactHistInfoView(parent)
            view.setInfo(it)
            contactHistLayout.addView(view)
        }
    }
}