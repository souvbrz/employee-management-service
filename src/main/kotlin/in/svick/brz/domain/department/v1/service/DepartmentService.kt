package `in`.svick.brz.domain.department.v1.service

import `in`.svick.brz.domain.department.v1.application.DepartmentApplication
import `in`.svick.brz.domain.department.v1.repository.DepartmentRepository
import `in`.svick.brz.exception.domain.department.DepartmentNotFound
import `in`.svick.brz.model.v1.domain.department.Department
import `in`.svick.brz.model.v1.domain.department.toEntity
import `in`.svick.brz.model.v1.domain.department.toModel
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class DepartmentService(private val departmentRepository: DepartmentRepository) : DepartmentApplication {
    override suspend fun createDepartment(department: Department): Department =
        departmentRepository.save(department.toEntity()).toModel()

    override suspend fun getDepartmentById(id: Long): Department? =
        departmentRepository.findByIdOrNull(id)?.toModel()

    override suspend fun getDepartmentsByOrganization(organisationId: Long): List<Department>? =
        departmentRepository.findAllByOrganizationId(organisationId)?.map { it.toModel() } ?: emptyList()

    override suspend fun updateDepartment(id: Long, department: Department): Department? =
        departmentRepository.save(
            department.copy(
                departmentName = department.departmentName,
                organizationId = department.organizationId
            ).toEntity()
        ).toModel().takeIf {
            departmentRepository.existsById(id)
        } ?: throw DepartmentNotFound("Department not found for Id - $id")

    override suspend fun deleteDepartment(id: Long) =
        departmentRepository.deleteById(id)
}