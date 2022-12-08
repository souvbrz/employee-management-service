package `in`.svick.brz.model.v1.domain.department

data class Department(
    val departmentName: String,
    val organizationId: Long,
)

fun Department.toEntity() =
    DepartmentEntity(
        id = null,
        departmentName = departmentName,
        organizationId = organizationId,
        createdAt = null,
        modifiedAt = null
    )

fun Department.toDTO() =
    DepartmentDTO(
        departmentName = departmentName,
        organizationId = organizationId
    )