package `in`.svick.brz.domain.department.v1.application

import `in`.svick.brz.model.v1.domain.department.Department
import org.springframework.stereotype.Service

@Service
interface DepartmentApplication {
    suspend fun createDepartment(department: Department): Department

    suspend fun getDepartmentById(id: Long): Department?

    suspend fun getDepartmentsByOrganization(organisationId: Long): List<Department>?

    suspend fun updateDepartment(id: Long, department: Department): Department?

    suspend fun deleteDepartment(id: Long)
}