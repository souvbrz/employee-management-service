package `in`.svick.brz.model.v1.domain.organization

import java.time.ZonedDateTime

data class Organization(
    val name: String,
    val countryCode: String
)

fun Organization.toDTO() =
    OrganizationDTO(
        name = name,
        countryCode = countryCode
    )

fun Organization.toEntity() =
    OrganizationEntity(
        id = null,
        name = name,
        countryCode = countryCode,
        modifiedAt = null
    )

fun Organization.toEntity(id: Long) =
    OrganizationEntity(
        id = id,
        name = name,
        countryCode = countryCode,
        modifiedAt = ZonedDateTime.now()
    )