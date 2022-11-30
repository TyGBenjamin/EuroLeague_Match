package com.example.soccermatch.model.mapper

import com.example.soccermatch.model.local.entity.Match
import com.example.soccermatch.model.remote.dto.MatchDTO

/**
 * Match Mapper mapper for mapping DTO to data class objects.
 *
 * @constructor Create empty Episode mapper
 */
class MatchMapper(
    private val homeMapper: HomeMapper,
    private val venueMapper: VenueMapper,
    private val compMapper:CompetitionStageMapper,
    private val awayMapper: AwayMapper
) : Mapper<MatchDTO, Match> {
    override fun invoke(dto: MatchDTO): Match {
        return with(dto) {
            Match(
                date = date,
                id = id,
                homeTeam = homeMapper(homeTeam),
                state = state,
                type = type,
                venue = venueMapper(venue),
                competitionStage = compMapper(competitionStage),
                awayTeam = awayMapper(awayTeam)
            )
        }
    }
}
