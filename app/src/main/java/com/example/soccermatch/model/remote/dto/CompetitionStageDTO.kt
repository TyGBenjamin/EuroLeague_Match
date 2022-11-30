package com.example.soccermatch.model.remote.dto

@kotlinx.serialization.Serializable
data class CompetitionStageDTO(
    val competition: CompetitionDTO,
    val leg: String? = "",
    val stage: String? = ""
)
