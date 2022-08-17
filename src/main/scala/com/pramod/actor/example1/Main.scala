package com.pramod.actor.example1

import akka.actor.ActorSystem

object Main extends App {
  val system = ActorSystem.create("example1")
  val firstActor = system.actorOf(FirstActor.props())
  val anotherFirstActor = system.actorOf(FirstActor.props())
  firstActor ! "Hi"
  firstActor ! 1

  for (i <- 1 to 10) {
    firstActor ! s"Hello World ${i}"
    anotherFirstActor ! s"Hello Sri Lanka ${i}"
  }

  for (i <- 1 to 10) {
    val firstActorNew = system.actorOf(FirstActor.props())
    firstActorNew ! s"Hello World ${i}"
  }
}