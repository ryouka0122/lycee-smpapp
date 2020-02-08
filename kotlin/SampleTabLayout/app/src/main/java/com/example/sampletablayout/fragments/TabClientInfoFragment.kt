package com.example.sampletablayout.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sampletablayout.R

class TabClientInfoFragment(context : Context) : TabFragment(context, "情報") {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.tab_client_info, container, false)
    }

}