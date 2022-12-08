package `in`.svick.brz.model.v1.domain.department

data class DepartmentDTO(
    val departmentName: String,
    val organizationId: Long
)

fun DepartmentDTO.toModel() =
    Department(
        departmentName = departmentName,
        organizationId = organizationId
    )