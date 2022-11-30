package com.example.soccermatch.model.local.entity

@kotlinx.serialization.Serializable
data class DataResponse(
    val data: List<Match>
    )
