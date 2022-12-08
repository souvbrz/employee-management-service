package `in`.svick.brz.model.v1.domain.organization

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.ZonedDateTime

@Entity(name = "organizations")
data class OrganizationEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val name: String,
    val countryCode: String,
    @CreationTimestamp
    @field:Column(nullable = false, updatable = false)
    val createdAt: ZonedDateTime? = null,
    @UpdateTimestamp
    val modifiedAt: ZonedDateTime? = null
)

fun OrganizationEntity.toModel() =
    Organization(
        name = name,
        countryCode = countryCode
    )