package com.gameleira.projetomarvel.home.hq.model

data class HQ (
    val id: Int,
    val thumbnail: Image,
    val title: String,
    val issueNumber: String,
    val dates: List<Dates>,
    val prices: List<Price>,
    val pageCount: Int,
    val description: String
)