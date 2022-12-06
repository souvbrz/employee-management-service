package `in`.svick.brz.domain.organization.v1.service

import `in`.svick.brz.domain.organization.v1.application.OrganisationApplication
import `in`.svick.brz.domain.organization.v1.repository.OrganizationRepository
import `in`.svick.brz.model.v1.domain.organization.Organization
import `in`.svick.brz.model.v1.domain.organization.toEntity
import `in`.svick.brz.model.v1.domain.organization.toModel
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class OrganizationService(private val organizationRepository: OrganizationRepository): OrganisationApplication {

    override suspend fun createOrganization(organization: Organization): Organization =
        organizationRepository.save(organization.toEntity()).toModel()

    override suspend fun getOrganizationById(id: Long): Organization? =
        organizationRepository.findByIdOrNull(id)?.toModel()

    override suspend fun getOrganizations(): List<Organization>? =
        organizationRepository.findAll().map { it.toModel() }

    override suspend fun updateOrganization(id: Long, organization: Organization): Organization? =
        organizationRepository.save(organization.toEntity(id)).takeIf {
            organizationRepository.existsById(id)
        }?.toModel()

    override suspend fun deleteOrganization(id: Long) =
        organizationRepository.deleteById(id)

}