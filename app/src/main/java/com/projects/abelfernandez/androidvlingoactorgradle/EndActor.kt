package com.projects.abelfernandez.androidvlingoactorgradle

import io.vlingo.actors.Actor

class EndActor: Actor(), End {

    private val ender: End = selfAs(End::class.java)

    override fun finishing(start: Start) {
        logger().log("finishing")
        start.starting(ender)
    }

}