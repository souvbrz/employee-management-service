package `in`.svick.brz.model.v1.domain.organization

import java.util.Locale.IsoCountryCode

data class OrganizationDTO(
    val name: String,
    val countryCode: String
)

fun OrganizationDTO.toModel() =
    Organization(
        name = name,
        countryCode = countryCode
    )