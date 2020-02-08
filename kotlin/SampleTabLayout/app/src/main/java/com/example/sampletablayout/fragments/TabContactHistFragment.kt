package com.example.sampletablayout.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sampletablayout.R
import com.example.sampletablayout.entity.ContactHist
import com.example.sampletablayout.views.ContactHistInfo
import kotlinx.android.synthetic.main.tab_contact_hist.*

val CONTACT_HIST_KEY = "contactHistList"


class TabContactHistFragment(context: Context) : TabFragment(context, "商談履歴") {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        savedInstanceState?.let {
            // FIXME: change to type cast safety
            mContactHistList = it.get(CONTACT_HIST_KEY) as Array<ContactHist>?
        }
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
        Log.d("SampleTabLayout","TabContactHistFragment#onStart()")

        mContactHistList?: return

        contactHistLayout.removeAllViews()
        mContactHistList!!.forEach {
            val view = ContactHistInfo(parent)
            view.setInfo(it)
            contactHistLayout.addView(view)
        }
    }
/*

        for (i in 1..10) {
            val hist = ContactHistInfo(requireContext())
            hist.setInfo("2020年1月${i}日", "ユーザー${i}")
            contactHistView.addView(hist)
        }
 */
}