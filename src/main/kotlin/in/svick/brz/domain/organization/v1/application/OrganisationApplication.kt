package `in`.svick.brz.domain.organization.v1.application

import `in`.svick.brz.model.v1.domain.organization.Organization
import org.springframework.stereotype.Service

@Service
interface OrganisationApplication {

    suspend fun createOrganization(organization: Organization): Organization

    suspend fun getOrganizationById(id: Long): Organization?

    suspend fun getOrganizations(): List<Organization>?

    suspend fun updateOrganization(id: Long, organization: Organization): Organization?

    suspend fun deleteOrganization(id: Long)
}