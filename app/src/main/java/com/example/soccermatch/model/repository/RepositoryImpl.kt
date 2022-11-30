package com.example.soccermatch.model.repository

import com.example.soccermatch.model.local.entity.Match
import com.example.soccermatch.model.mapper.AwayMapper
import com.example.soccermatch.model.mapper.CompetitionMapper
import com.example.soccermatch.model.mapper.CompetitionStageMapper
import com.example.soccermatch.model.mapper.HomeMapper
import com.example.soccermatch.model.mapper.MatchMapper
import com.example.soccermatch.model.mapper.VenueMapper
import com.example.soccermatch.model.remote.ApiService
import com.example.soccermatch.repo.Repository
import com.example.soccermatch.util.Resource
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Repository impl for handling actions and retrieving data for viewmodel and view.
 *
 * @property api
 * @constructor Create empty Repository impl
 */
class RepositoryImpl @Inject constructor(private val api: ApiService) : Repository {
    private val awayMapper = AwayMapper()
    private val homeMapper = HomeMapper()
    private val venueMapper = VenueMapper()
    private val compMapper = CompetitionMapper()
    private val compStageMapper = CompetitionStageMapper(compMapper = compMapper)
    private val mapper = MatchMapper(
        awayMapper = awayMapper,
        homeMapper = homeMapper,
        venueMapper = venueMapper,
        compMapper = compStageMapper
    )

    override suspend fun getList(): Resource<List<Match>> = withContext(Dispatchers.IO) {
        return@withContext try {
            val res = api.getList()
            if (res.isSuccessful && res.body() != null) {
                println("RESPONSE IS HERE ${res.body()}")
                Resource.Success(res.body()!!.map { mapper(it) })
            } else {
                Resource.Error(res.message())
            }
        } catch (e: IllegalAccessError) {
            Resource.Error(e.message.toString())
        }
    }
}
