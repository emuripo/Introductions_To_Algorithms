package com.example.apibackend

import com.example.apibackend.dao.PersonaRepository
import com.example.apibackend.model.Persona
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@SpringBootApplication
class ApibackendApplication : CommandLineRunner {
    @Autowired
    val personaRepository: PersonaRepository? = null
    override fun run(vararg args: String?) {
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        val persona1 =
            Persona(dni = 118210883, nombre = "Esteban", apellido = "Muri", LocalDate.parse("10-03-2022", formatter))
        personaRepository!!.save(persona1)
    }
}

fun main(args: Array<String>) {
    runApplication<ApibackendApplication>(*args)
}
