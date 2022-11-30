package com.example.soccermatch.model.mapper

import com.example.soccermatch.model.local.entity.Venue
import com.example.soccermatch.model.remote.dto.VenueDTO

/**
 * Venue Mapper mapper for mapping DTO to data class objects.
 *
 * @constructor Create empty Venue mapper
 */
class VenueMapper : Mapper<VenueDTO, Venue> {
    override fun invoke(dto: VenueDTO): Venue {
        return with(dto) {
            Venue(
                id = id,
                name = name

            )
        }
    }
}
