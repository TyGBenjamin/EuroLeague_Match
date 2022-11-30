package com.example.soccermatch.model.mapper

import com.example.soccermatch.model.local.entity.HomeTeam
import com.example.soccermatch.model.remote.dto.HomeTeamDTO

/**
 * HomeTeam Mapper mapper for mapping DTO to data class objects.
 *
 * @constructor Create empty HomeTeam mapper
 */
class HomeMapper : Mapper<HomeTeamDTO, HomeTeam> {
    override fun invoke(dto: HomeTeamDTO): HomeTeam {
        return with(dto) {
            HomeTeam(
                id = id,
                alias = alias,
                name = name,
                abbr = abbr,
                shortName = shortName
            )
        }
    }
}
