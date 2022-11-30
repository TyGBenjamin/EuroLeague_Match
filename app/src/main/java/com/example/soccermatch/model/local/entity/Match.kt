package com.example.soccermatch.model.local.entity

@kotlinx.serialization.Serializable
data class Match(
    val awayTeam: AwayTeam,
    val competitionStage: CompetitionStage,
    val date: String,
    val homeTeam: HomeTeam,
    val id: Int,
    val state: String? = "",
    val type: String,
    val venue: Venue
)
