package com.example.soccermatch.model.mapper

import com.example.soccermatch.model.local.entity.Competition
import com.example.soccermatch.model.local.entity.HomeTeam
import com.example.soccermatch.model.remote.dto.CompetitionDTO
import com.example.soccermatch.model.remote.dto.HomeTeamDTO

/**
 * Competition Mapper mapper for mapping DTO to data class objects.
 *
 * @constructor Create empty Competition mapper
 */
class CompetitionMapper : Mapper<CompetitionDTO, Competition> {
    override fun invoke(dto: CompetitionDTO): Competition {
        return with(dto) {
            Competition(
                id = id,
                name = name,
            )
        }
    }
}
