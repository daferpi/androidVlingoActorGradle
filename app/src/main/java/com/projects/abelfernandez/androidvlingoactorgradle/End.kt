package com.projects.abelfernandez.androidvlingoactorgradle

import io.vlingo.actors.Stoppable

interface End {
    fun stop()
    fun finishing(start: Start)
}