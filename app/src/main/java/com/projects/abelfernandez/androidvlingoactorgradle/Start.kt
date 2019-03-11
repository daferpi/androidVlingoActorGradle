package com.projects.abelfernandez.androidvlingoactorgradle

import io.vlingo.actors.Stoppable

interface Start {
    fun stop()
    fun starting(end: End)
}