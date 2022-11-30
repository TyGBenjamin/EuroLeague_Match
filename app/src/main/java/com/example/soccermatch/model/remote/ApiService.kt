package com.example.soccermatch.model.remote

import com.example.soccermatch.model.remote.dto.MatchDTO
import retrofit2.Response
import retrofit2.http.GET

/**
 * Api service for retrieving request from API.
 *
 * @constructor Create empty Api service
 */
interface ApiService {

    @GET(FEED_ENDPOINT)
    suspend fun getList(): Response<List<MatchDTO>>

    companion object {
        private const val FEED_ENDPOINT = "fixtures.json"
    }
}
