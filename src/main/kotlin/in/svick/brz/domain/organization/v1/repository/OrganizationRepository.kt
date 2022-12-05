package `in`.svick.brz.domain.organization.v1.repository

import `in`.svick.brz.model.v1.domain.organization.OrganizationEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrganizationRepository: JpaRepository<OrganizationEntity, Long> {
}