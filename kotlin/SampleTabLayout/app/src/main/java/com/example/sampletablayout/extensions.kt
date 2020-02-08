package com.example.sampletablayout

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