package com.pramod.actor.example1

import akka.actor.{Actor, Props}
import akka.event.Logging

object FirstActor {
  def props() = Props(new FirstActor())
}

class FirstActor extends Actor {
  val log = Logging(context.system, this)

  println("LifeCycleActor: constructor")

  override def preStart { println("LifeCycleActor: preStart") }

  override def postStop { println("LifeCycleActor: postStop") }

  override def preRestart(reason: Throwable, message: Option[Any]) {
    println("LifeCycleActor: preRestart")
    println(s"LifeCycleActor reason: ${reason.getMessage}")
    println(s"LifeCycleActor message: ${message.getOrElse("")}")
    super.preRestart(reason, message)
  }
  override def postRestart(reason: Throwable) {
    println("LifeCycleActor: postRestart")
    println(s"LifeCycleActor reason: ${reason.getMessage}")
    super.postRestart(reason)
  }
  override def receive: Receive = {
    case msg: String => println(s"Received message - $msg context - ${context.self} system ${context.system}")
    case _ => println(s"Received unsupported message")
  }
}