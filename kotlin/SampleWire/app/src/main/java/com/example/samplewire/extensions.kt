package com.example.samplewire

import android.text.format.DateFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * referred site:
 * https://qiita.com/emboss369/items/5a3ddea301cbf79d971a
 */
fun String.toDate(pattern: String = "yyyy/MM/dd") : Date {
    val sdf = SimpleDateFormat(pattern, Locale.JAPAN)
    return sdf.parse(this)
}

fun Date.toDateString(format: String = "yyyy/MM/dd") : String {
    return DateFormat.format(format, this).toString()
}