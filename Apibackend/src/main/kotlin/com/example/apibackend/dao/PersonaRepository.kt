package com.example.apibackend.dao

import com.example.apibackend.model.Persona
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/** aqui se accede a poder guardar los datos, solicitarlos dentro de nuestra DB */
@Repository
interface PersonaRepository : JpaRepository<Persona, Long> {

}