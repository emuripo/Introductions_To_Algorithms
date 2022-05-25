package com.example.apibackend.business

import com.example.apibackend.dao.PersonaRepository
import com.example.apibackend.exception.BusinessException
import com.example.apibackend.exception.NotFoundException
import com.example.apibackend.model.Persona
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Optional

/** Esta clase es la encargada de crear los meetodos de la interface de IPersonasBusiness
 *  y va ser la encargada junto a la interfaz de IPersonasBusiness de generar todas las peticiones a la DB
 * */

@Service
class PersonaBusiness : IPersonaBusiness {

    /** Autowired
     * Injeccion de depencias dentro de PersonasBusiness
     *  Insejactame dentro de PersonaBusiness el repository encargado de tener todos los metodos para poder trabajar con mi DB */
    @Autowired
    val personaRepository: PersonaRepository? = null

    @Throws(BusinessException::class, NotFoundException::class)
    /** tecla CRTL + i para implementar los miembros */
    override fun list(): List<Persona> {
        /** Metodo para retornar una lista de personas */
        try {
            return personaRepository!!.findAll()
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun load(idPersona: Long): Persona {
        /** Metodo para cargar una persona mediante su id */
        val op: Optional<Persona>
        try {
            op = personaRepository!!.findById(idPersona)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }
        if (!op.isPresent) {
            throw NotFoundException("No se encontró a la persona con el id $idPersona")
        }
        return op.get()
        /** si el valor es igual a nulo, devuelve un mensaje error, de lo contrario devuelve el valor*/
    }

    @Throws(BusinessException::class)
    override fun save(persona: Persona): Persona {
        /** Metodo para guardar personas en la DB */
        try {
            return personaRepository!!.save(persona)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun remove(idPersona: Long) {
        val op: Optional<Persona>
        /** Metodo para remover una persona de la DB */
        try {
            op = personaRepository!!.findById(idPersona)
        } catch (e: Exception) {
            throw BusinessException(e.message)
        }
        if (!op.isPresent) {
            throw NotFoundException("No se encontró a la persona con el id $idPersona")
        }else{
            try {
                personaRepository!!.deleteById(idPersona)
            }catch (e:Exception){
                throw BusinessException(e.message)
            }
        }
    }
}