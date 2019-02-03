package com.projects.abelfernandez.androidvlingoactorgradle

import io.vlingo.actors.Stoppable

interface End: Stoppable {

    fun finishing(start: Start)
}