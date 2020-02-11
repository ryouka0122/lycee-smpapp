package com.example.sampleintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_menu_thanks.*

class MenuThanksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_thanks)

        val name = intent.getStringExtra("menuName")
        val price = intent.getStringExtra("menuPrice")

        tvMenuName.text = name
        tvMenuPrice.text = price
    }

    fun onBackButtonClick(view: View) {
        finish()
    }
}
