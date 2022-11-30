package com.example.soccermatch.model.remote.dto

@kotlinx.serialization.Serializable
data class AwayTeamDTO(
    val abbr: String,
    val alias: String,
    val id: Int,
    val name: String,
    val shortName: String
)
