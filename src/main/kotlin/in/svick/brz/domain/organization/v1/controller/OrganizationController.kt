package `in`.svick.brz.domain.organization.v1.controller

import `in`.svick.brz.domain.organization.v1.application.OrganisationApplication
import `in`.svick.brz.model.v1.domain.organization.OrganizationDTO
import `in`.svick.brz.model.v1.domain.organization.toDTO
import `in`.svick.brz.model.v1.domain.organization.toModel
import kotlinx.coroutines.coroutineScope
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/organizations")
class OrganizationController(private val organizationApplication: OrganisationApplication) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    suspend fun createOrganization(@RequestBody organizationDTO: OrganizationDTO): OrganizationDTO = coroutineScope {
        organizationApplication.createOrganization(organizationDTO.toModel()).toDTO()
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    suspend fun getOrganizationById(@PathVariable id: Long): OrganizationDTO? = coroutineScope {
        organizationApplication.getOrganizationById(id)?.toDTO()
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    suspend fun getOrganizations(): List<OrganizationDTO>? = coroutineScope {
        organizationApplication.getOrganizations()?.map { it.toDTO() }
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    suspend fun updateOrganization(
        @PathVariable id: Long,
        @RequestBody organizationDTO: OrganizationDTO
    ): OrganizationDTO? = coroutineScope {
        organizationApplication.updateOrganization(id, organizationDTO.toModel())?.toDTO()
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    suspend fun deleteOrganization(@PathVariable id: Long) = coroutineScope {
        organizationApplication.deleteOrganization(id)
    }
}