package `in`.svick.brz.domain.department.v1.repository

import `in`.svick.brz.model.v1.domain.department.DepartmentEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DepartmentRepository : JpaRepository<DepartmentEntity, Long> {
    fun findAllByOrganizationId(organizationId: Long): List<DepartmentEntity>?
}