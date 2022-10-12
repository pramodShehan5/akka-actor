package com.pramod.actor.stop

import akka.actor.{ActorSystem, DeadLetter, PoisonPill}
import com.pramod.actor.deadletter.DeadLetterActor
import com.pramod.actor.stop.SystemStopMain.{actor, actorSystem}

object PoisonPillMain extends App {
  val system = ActorSystem.create("poision")
  val actor = system.actorOf(FirstActor.props())
  val deadLetterActor = system.actorOf(DeadLetterActor.props())
  system.eventStream.subscribe(deadLetterActor, classOf[DeadLetter])
  actor ! "Hello1"
  actor ! "Hello2"
  actor ! PoisonPill
  actor ! "Hello3"
  actor ! "Hello4"
  actor ! "Hello5"
}