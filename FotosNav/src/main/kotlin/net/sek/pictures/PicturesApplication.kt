package net.sek.pictures
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication

open class PicturesApplication

fun main (args:Array<String>){
    runApplication<PicturesApplication>(*args)
}


