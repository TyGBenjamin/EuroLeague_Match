package com.example.soccermatch.model.local.entity

@kotlinx.serialization.Serializable
data class CompetitionStage(
    val competition: Competition,
    val leg: String? = "",
    val stage: String? =""
)
