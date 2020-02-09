package com.example.samplewire

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.samplewire.entity.ClientInfo
import com.example.samplewire.entity.ContactHist
import com.example.samplewire.fragment.TabClientInfoFragment
import com.example.samplewire.fragment.TabContactHistFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val contactHistList = arrayOf(
        ContactHist("ユーザ1", "2020/01/11".toDate(), "内容1"),
        ContactHist("ユーザ2", "2020/01/12".toDate(), "内容2"),
        ContactHist("ユーザ3", "2020/01/13".toDate(), "内容3"),
        ContactHist("ユーザ4", "2020/01/14".toDate(), "内容4"),
        ContactHist("ユーザ5", "2020/01/15".toDate(), "内容5"),
        ContactHist("ユーザ6", "2020/01/16".toDate(), "内容6"),
        ContactHist("ユーザ7", "2020/01/17".toDate(), "内容7"),
        ContactHist("ユーザ8", "2020/01/18".toDate(), "内容8")
    )

    private val clientInfo = ClientInfo(
        "鈴木　太郎",
        "taro_suzuki@example.com",
        "090-1234-5678",

        "(株) サンプル",
        "営業部",
        "03-1234-5678",
        "03-1234-5679",
        "東京都",
        "https://example.com/",

        "2020/02/01".toDate(),
        "めも",
        listOf("お得意先")
        )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabList = arrayOf(
            TabClientInfoFragment(this).also {
                it.clientInfo = clientInfo
            },
            TabContactHistFragment(this).also {
                it.contactHistList = contactHistList
            }
        )

        val adapter = object : FragmentStatePagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

            override fun getItem(position: Int): Fragment {
                return tabList[position]
            }

            override fun getPageTitle(position: Int): CharSequence? {
                return tabList[position].title()
            }

            override fun getCount(): Int = tabList.size

        }

        viewPager.offscreenPageLimit = tabList.size
        viewPager.adapter = adapter

        tabLayout.setupWithViewPager(viewPager)

    }
}
