package com.pramod.actor.stop

import akka.actor.{ActorContext, ActorSystem, DeadLetter, Kill}
import com.pramod.actor.deadletter.DeadLetterActor

object KillMain extends App {
  val system = ActorSystem.create("kill")
  val actor = system.actorOf(FirstActor.props())
  val deadLetterActor = system.actorOf(DeadLetterActor.props())
  system.eventStream.subscribe(deadLetterActor, classOf[DeadLetter])
  actor ! "Hello1"
  actor ! "Hello2"
  actor ! Kill
  actor ! "Hello3"
  actor ! "Hello4"
  actor ! "Hello5"
}