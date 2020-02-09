package com.example.samplewire.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.samplewire.R
import com.example.samplewire.entity.ClientInfo
import kotlinx.android.synthetic.main.tab_client_info.*

class TabClientInfoFragment(context : Context) : TabFragment(context, "情報") {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.tab_client_info, container, false)
    }

    private var mClientInfo : ClientInfo? = null

    var clientInfo : ClientInfo?
        get() = mClientInfo
        set(value) {
            mClientInfo = value
        }

    override fun onStart() {
        super.onStart()

        mClientInfo ?: return

        clientInfoView.setInfo(mClientInfo!!)


    }

}