package com.example.samplewire.entity

import java.util.*

data class ClientInfo(
    val clientName: String,
    val mailAddress : String,
    val cellTel : String,

    val companyName : String,
    val department : String,
    val companyTel : String,
    val companyFax : String,
    val companyAddress : String,
    val companyUrl : String,

    val regDate: Date,
    val memo : String,
    val label : List<String>
)

