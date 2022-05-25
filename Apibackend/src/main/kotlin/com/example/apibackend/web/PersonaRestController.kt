package com.example.apibackend.web

import com.example.apibackend.business.IPersonaBusiness
import com.example.apibackend.exception.BusinessException
import com.example.apibackend.exception.NotFoundException
import com.example.apibackend.model.Persona
import com.example.apibackend.utils.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(Constants.URL_BASE_PERSONAS)
/** get mapping etc, para mapear los datos de la db, con nuestro server y mandarlos por la respuesta por la pagina web y esto nos devulve el JSON*/
class PersonaRestController {
    @Autowired
    val personaBusiness: IPersonaBusiness?= null

    @GetMapping("")
    fun list(): ResponseEntity<List<Persona>>{
        return  try {
            ResponseEntity(personaBusiness!!.list(), HttpStatus.OK)
        }catch (e: Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/{id}")
    fun load(@PathVariable("id") idPersona:Long): ResponseEntity<Any>{
        return try{
            ResponseEntity(personaBusiness!!.load(idPersona), HttpStatus.OK)
        }catch (e: BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch (e: NotFoundException){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
    @PostMapping("")
    fun insert(@RequestBody persona: Persona):ResponseEntity<Any>{
        return try{
            personaBusiness!!.save(persona)
            val responseHeader = HttpHeaders()
            responseHeader.set("location", Constants.URL_BASE_PERSONAS +"/"+ persona.id)
            ResponseEntity(responseHeader, HttpStatus.CREATED)
        }catch (e: BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
    @PutMapping("")
    fun update(@RequestBody persona: Persona):ResponseEntity<Any>{
        return try{
            personaBusiness!!.save(persona)
            ResponseEntity(HttpStatus.OK)
        }catch (e: BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }
    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") idPersona: Long): ResponseEntity<Any>{
        return try{
            personaBusiness!!.remove(idPersona)
            ResponseEntity(HttpStatus.OK)
        }catch (e: BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch (e: NotFoundException){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}