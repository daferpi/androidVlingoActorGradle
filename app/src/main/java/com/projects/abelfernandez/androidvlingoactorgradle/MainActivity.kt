package com.projects.abelfernandez.androidvlingoactorgradle

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.vlingo.actors.Configuration
import io.vlingo.actors.Definition
import io.vlingo.actors.World
import io.vlingo.actors.plugin.supervision.CommonSupervisorsPlugin
import io.vlingo.actors.plugin.supervision.DefaultSupervisorOverride
import io.vlingo.actors.plugin.supervision.DefaultSupervisorOverridePlugin
import io.vlingo.actors.testkit.TestUntil

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {

            val world: World = World.start("androidvlingoactorgradle")

            val until: TestUntil = TestUntil.happenings(1)
            val start: Start = world.actorFor(Start::class.java, Definition(StartActor::class.java, Definition.parameters(until)))
            val end: End = world.actorFor(End::class.java, Definition(EndActor::class.java, Definition.NoParameters))

            start.starting(end)

//            until.completes()

        } catch (e: Exception) {
            Log.e("actors", e.localizedMessage)
            e.printStackTrace()
        }




    }
}
