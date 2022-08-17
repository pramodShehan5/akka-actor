package com.pramod.actor.example2

import akka.actor.ActorSystem

case class TestExampleTwo1(name: String)



object SecondMain extends App {
  val system = ActorSystem.create("com/pramod/actor/example2")
  val secondActor = system.actorOf(SecondActor.props, "secondActor")
  secondActor ! "Hello"
  secondActor ! TestExampleTwo1("Pramod Shehan")
  system.deadLetters
}
