package `in`.svick.brz.exception.domain.department

class DepartmentNotFound(override val message: String) : RuntimeException(message) {
}