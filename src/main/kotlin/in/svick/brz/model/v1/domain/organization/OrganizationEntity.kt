package `in`.svick.brz.model.v1.domain.organization

import jakarta.persistence.*
import java.time.ZonedDateTime
import java.util.Locale.IsoCountryCode

@Entity
@Table(name = "organizations")
data class OrganizationEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val name: String,
    val countryCode: String,
    @field:Column(nullable = false, updatable = false)
    val createdAt: ZonedDateTime? = ZonedDateTime.now(),
    val modifiedAt: ZonedDateTime?
)

fun OrganizationEntity.toModel() =
    Organization(
        name = name,
        countryCode = countryCode
    )