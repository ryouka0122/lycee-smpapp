package com.example.sampleintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lvMenu.onItemClickListener = ListItemClickListnener()
    }

    private inner class ListItemClickListnener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
            val item = parent.getItemAtPosition(position) as String

            val msg = "あなたが選んだ定食: $item"

            Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG).show()

        }

    }


}
