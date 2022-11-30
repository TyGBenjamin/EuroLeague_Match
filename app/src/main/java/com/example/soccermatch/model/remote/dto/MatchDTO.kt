package com.example.soccermatch.model.remote.dto

@kotlinx.serialization.Serializable
data class MatchDTO(
    val awayTeam: AwayTeamDTO,
    val competitionStage: CompetitionStageDTO,
    val date: String,
    val homeTeam: HomeTeamDTO,
    val id: Int,
    val state: String? = "",
    val type: String,
    val venue: VenueDTO
)
