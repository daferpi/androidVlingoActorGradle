package com.projects.abelfernandez.androidvlingoactorgradle

import io.vlingo.actors.Actor
import io.vlingo.actors.testkit.TestUntil

class StartActor(var until: TestUntil = TestUntil.happenings(1)): Actor(), Start {

    private var count = 0
    private val starter: Start = selfAs(Start::class.java)

    override fun starting(end: End) {
        logger().log("starting " + count);
        if (++count >= 10) {
            this.stop()
            end.stop()
        } else {
            end.finishing(starter)
        }
    }

    override fun afterStop() {
        logger().log("starting " + address() + " just stopped!")
        until.happened()
        super.afterStop()
    }


}