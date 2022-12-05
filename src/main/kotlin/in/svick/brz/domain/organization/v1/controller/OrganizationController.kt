package `in`.svick.brz.domain.organization.v1.controller

import `in`.svick.brz.domain.organization.v1.application.OrganisationApplication
import `in`.svick.brz.model.v1.domain.organization.OrganizationDTO
import `in`.svick.brz.model.v1.domain.organization.toDTO
import `in`.svick.brz.model.v1.domain.organization.toModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/organizations")
class OrganizationController(private val organizationApplication: OrganisationApplication) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    suspend fun createOrganization(@RequestBody organizationDTO: OrganizationDTO): OrganizationDTO = runBlocking {
            organizationApplication.createOrganization(organizationDTO.toModel()).toDTO()
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    suspend fun getOrganizationById(@PathVariable id: Long): OrganizationDTO? = runBlocking {
        organizationApplication.getOrganizationById(id)?.toDTO()
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    suspend fun getOrganizations(): List<OrganizationDTO>? = runBlocking {
        organizationApplication.getOrganizations()?.map { it.toDTO() }
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    suspend fun updateOrganization(@PathVariable id: Long, @RequestBody organizationDTO: OrganizationDTO): OrganizationDTO? = runBlocking {
        organizationApplication.updateOrganization(id, organizationDTO.toModel())?.toDTO()
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    suspend fun deleteOrganization(@PathVariable id: Long) = runBlocking {
        organizationApplication.deleteOrganization(id)
    }
}