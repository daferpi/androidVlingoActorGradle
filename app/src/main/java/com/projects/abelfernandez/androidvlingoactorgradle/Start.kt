package com.projects.abelfernandez.androidvlingoactorgradle

import io.vlingo.actors.Stoppable

interface Start: Stoppable {

    fun starting(end: End)
}