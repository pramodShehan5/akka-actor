package com.pramod.actor.lifecycle

import akka.actor.ActorSystem

object MainResarted extends App {
  val actorSystem = ActorSystem.create("restarted")
  val actor = actorSystem.actorOf(MyActor.props())
  actor ! ForceRestart
  actor ! "Hello"
}