package com.example.soccermatch.model.mapper

import com.example.soccermatch.model.local.entity.AwayTeam
import com.example.soccermatch.model.remote.dto.AwayTeamDTO

/**
 * AwayTeam Mapper mapper for mapping DTO to data class objects.
 *
 * @constructor Create empty AwayTeam mapper
 */
class AwayMapper : Mapper<AwayTeamDTO, AwayTeam> {
    override fun invoke(dto: AwayTeamDTO): AwayTeam {
        return with(dto) {
            AwayTeam(
                id = id,
                alias = alias,
                name = name,
                abbr = abbr,
                shortName = shortName
            )
        }
    }
}
