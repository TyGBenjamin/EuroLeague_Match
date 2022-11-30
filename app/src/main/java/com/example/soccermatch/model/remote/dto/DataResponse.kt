package com.example.soccermatch.model.remote.dto

@kotlinx.serialization.Serializable
data class DataResponse(
    val data: List<MatchDTO>
    )
