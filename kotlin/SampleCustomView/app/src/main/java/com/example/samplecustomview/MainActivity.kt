package com.example.samplecustomview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        contactHistInfo.setInfo("2020/02/01", "ユーザー1")
        contactHistInfo2.setInfo("2020/02/02", "ユーザー2")
        contactHistInfo3.setInfo("2020/02/03", "ユーザー3")

        for (i in 4..10) {
            val contactHist = ContactHistInfo(this)
            contactHist.setInfo("2020年2月${i}日", "ユーザー${i}")
            mainLinearLayout.addView(contactHist)
        }


    }
}
