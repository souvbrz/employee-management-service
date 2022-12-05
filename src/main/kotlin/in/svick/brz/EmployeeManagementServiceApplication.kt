package `in`.svick.brz

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EmployeeManagementServiceApplication

fun main(args: Array<String>){
    runApplication<EmployeeManagementServiceApplication>(*args)
}