package `in`.svick.brz.domain.department.v1.controller

import `in`.svick.brz.domain.department.v1.application.DepartmentApplication
import `in`.svick.brz.model.v1.domain.department.DepartmentDTO
import `in`.svick.brz.model.v1.domain.department.toDTO
import `in`.svick.brz.model.v1.domain.department.toModel
import kotlinx.coroutines.*
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/departments")
class DepartmentController(private val departmentApplication: DepartmentApplication) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    suspend fun createDepartment(@RequestBody departmentDTO: DepartmentDTO): ResponseEntity<DepartmentDTO> =
        coroutineScope {
            ResponseEntity
                .status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(departmentApplication.createDepartment(departmentDTO.toModel()).toDTO())


        }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    suspend fun getDepartmentById(@PathVariable id: Long): DepartmentDTO? = coroutineScope {
        departmentApplication.getDepartmentById(id)?.toDTO()
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/organisation/{id}")
    suspend fun getDepartmentsByOrganization(@PathVariable id: Long): List<DepartmentDTO>? = coroutineScope {
        departmentApplication.getDepartmentsByOrganization(id)?.map { it.toDTO() }
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    suspend fun updateDepartment(@PathVariable id: Long, @RequestBody departmentDTO: DepartmentDTO): DepartmentDTO? =
        coroutineScope {
            departmentApplication.updateDepartment(id, departmentDTO.toModel())?.toDTO()
        }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    suspend fun deleteDepartment(@PathVariable id: Long) = coroutineScope {
        departmentApplication.deleteDepartment(id)
    }
}