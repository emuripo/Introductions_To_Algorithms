package com.example.apibackend.business

import com.example.apibackend.model.Persona

/* aqui se va a declarar los metodos que se van a utlizar */

interface IPersonaBusiness {
    /** Se llama a la lista persona */
    fun list(): List<Persona>

    /** vamos a cargar una persona */
    fun load(idPersona: Long): Persona

    /** Guardamos una persona en concreto */
    fun save(persona: Persona): Persona

    /** Para remover una persona de la lista */
    fun remove(idPersona: Long)

}