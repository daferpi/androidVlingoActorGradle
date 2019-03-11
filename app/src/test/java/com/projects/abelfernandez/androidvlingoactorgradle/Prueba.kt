package com.projects.abelfernandez.androidvlingoactorgradle

import io.vlingo.actors.Actor

class Prueba: Actor(), IPrueba {
    override fun pruebaMe() {
        print("prueba")
        this.stop()
    }

}