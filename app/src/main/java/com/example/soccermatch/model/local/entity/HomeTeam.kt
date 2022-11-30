package com.example.soccermatch.model.local.entity

@kotlinx.serialization.Serializable
data class HomeTeam(
    val abbr: String,
    val alias: String,
    val id: Int,
    val name: String,
    val shortName: String
)
