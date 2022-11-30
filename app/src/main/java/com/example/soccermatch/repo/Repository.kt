package com.example.soccermatch.repo

import com.example.soccermatch.model.local.entity.Match
import com.example.soccermatch.util.Resource

/**
 * Repository Abstract.
 *
 * @constructor Create empty Repository
 */
interface Repository {
    /**
     * Get list from API request.
     *
     * @return
     */
    suspend fun getList(): Resource<List<Match>>
}
