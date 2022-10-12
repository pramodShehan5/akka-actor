package com.pramod.actor.supervisor

import akka.actor.{Actor, Props}

import scala.language.postfixOps

object MyChildActor {
  def props = Props.apply(new MyChildActor())
}

class MyChildActor extends Actor {
  override def preRestart(reason: Throwable, message: Option[Any]): Unit = {
    println(s"###Child RESTART### Receiving msg PleaseStop ${context.self}")
  }

  override def receive: Receive = {
    case PleaseStop =>
      println(s"###Child### Receiving msg PleaseStop ${context.self}")
      throw StopException
    case PleaseRestart =>
      println(s"###Child### Receiving msg PleaseRestart ${context.self}")
      throw RestartException
    case "Hello" =>
      println(s"###Child### Receiving Hello msg ${context.self}")
  }
}
