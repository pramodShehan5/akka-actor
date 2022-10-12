package com.pramod.actor.stop

import akka.actor.{ActorSystem, DeadLetter}
import com.pramod.actor.deadletter.DeadLetterActor

object Main extends App {
  val actorSystem = ActorSystem.create("stoppingactors")
  val actor = actorSystem.actorOf(FirstActor.props())
  val deadLetterActor = actorSystem.actorOf(DeadLetterActor.props())
  actorSystem.eventStream.subscribe(deadLetterActor, classOf[DeadLetter])
  actor ! "Hello1"
  actor ! "Hello2"
  actor ! "Hello3"
  actor ! ContextStop
  actor ! "Hello4"
  actor ! "Hello5"
  actorSystem.terminate()
}
