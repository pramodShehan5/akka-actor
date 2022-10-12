package com.pramod.actor.deadletter

import akka.actor.{ActorSystem, DeadLetter}

object MainDeadLetter extends App {
  val system = ActorSystem.create("deadletter")
  val basicActor = system.actorOf(BasicActor.props())
  val deadLetterActor = system.actorOf(DeadLetterActor.props())
  system.eventStream.subscribe(deadLetterActor, classOf[DeadLetter])

  basicActor ! "Hi"
  basicActor ! "How"
}
