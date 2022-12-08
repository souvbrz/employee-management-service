package `in`.svick.brz.exception

import `in`.svick.brz.exception.domain.organization.OrganizationNotFound
import `in`.svick.brz.model.v1.exception.ErrorModel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler
    fun handleOrganizationNotFound(ex: OrganizationNotFound): ResponseEntity<ErrorModel> =
        ResponseEntity<ErrorModel>(ErrorModel(HttpStatus.NOT_FOUND.value(), ex.message), HttpStatus.NOT_FOUND)
}