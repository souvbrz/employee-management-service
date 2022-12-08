package `in`.svick.brz.model.v1.domain.department

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.ZonedDateTime

@Entity(name = "departments")
data class DepartmentEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @NotBlank
    val departmentName: String,
    @NotNull
    val organizationId: Long,
    @CreationTimestamp
    @field:Column(nullable = false, updatable = false)
    val createdAt: ZonedDateTime?,
    @UpdateTimestamp
    val modifiedAt: ZonedDateTime?
)

fun DepartmentEntity.toModel() =
    Department(
        departmentName = departmentName,
        organizationId = organizationId
    )