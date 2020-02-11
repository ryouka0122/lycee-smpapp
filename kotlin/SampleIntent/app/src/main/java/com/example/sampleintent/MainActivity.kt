package com.example.sampleintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val menuList1 = mutableListOf(
            "唐揚げ定食",
            "ハンバーグ定食",
            "生姜焼き定食",
            "ステーキ定食",
            "野菜炒め定食",
            "とんかつ定食",
            "ミンチかつ定食",
            "チキンカツ定食",
            "コロッケ定食",
            "焼き魚定食",
            "焼肉定食")

        val menuList: MutableList<MutableMap<String, String>> = mutableListOf()
        menuList.add(mutableMapOf("name" to "唐揚げ定食", "price" to "800円"))
        menuList.add(mutableMapOf("name" to "ハンバーグ定食", "price" to "850円"))
        menuList.add(mutableMapOf("name" to "生姜焼き定食", "price" to "850円"))
        menuList.add(mutableMapOf("name" to "ステーキ定食", "price" to "1000円"))
        menuList.add(mutableMapOf("name" to "野菜炒め定食", "price" to "750円"))
        menuList.add(mutableMapOf("name" to "とんかつ定食", "price" to "900円"))
        menuList.add(mutableMapOf("name" to "ミンチかつ定食", "price" to "850円"))
        menuList.add(mutableMapOf("name" to "チキンカツ定食", "price" to "900円"))
        menuList.add(mutableMapOf("name" to "コロッケ定食", "price" to "850円"))
        menuList.add(mutableMapOf("name" to "焼き魚定食", "price" to "700円"))
        menuList.add(mutableMapOf("name" to "焼肉定食", "price" to "850円"))

        val from = arrayOf("name", "price")
        val to = intArrayOf(android.R.id.text1, android.R.id.text2)

        val adapter = SimpleAdapter(applicationContext, menuList, android.R.layout.simple_list_item_2, from, to)

        lvMenu.adapter = adapter
        lvMenu.onItemClickListener = ListItemClickListener()

    }

    private inner class ListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
            val item = parent.getItemAtPosition(position) as MutableMap<String, String>

            val name = item["name"]
            val price = item["price"]

            val intent = Intent(applicationContext, MenuThanksActivity::class.java)

            intent.putExtra("menuName", name)
            intent.putExtra("menuPrice", price)
            startActivity(intent)
        }
    }

}
