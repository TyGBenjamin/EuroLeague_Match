package com.example.soccermatch.model.mapper

import com.example.soccermatch.model.local.entity.CompetitionStage
import com.example.soccermatch.model.remote.dto.CompetitionStageDTO

/**
 * CompetitionStage Mapper mapper for mapping DTO to data class objects.
 *
 * @constructor Create empty CompetitionStage mapper
 */
class CompetitionStageMapper(private val compMapper:CompetitionMapper) : Mapper<CompetitionStageDTO, CompetitionStage> {
    override fun invoke(dto: CompetitionStageDTO): CompetitionStage {
        return with(dto) {
            CompetitionStage(
               competition = compMapper(competition),
                leg,
                stage
            )
        }
    }
}
