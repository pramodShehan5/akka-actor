package com.pramod.actor.lifecycle

import akka.actor.{Actor, Props}

object MyActor {
  def props() = Props.apply(new MyActor())
}

class MyActor extends Actor{
  override def preStart(): Unit = {
    println(s"Calling PreStart()")
    super.preStart()
  }

  override def preRestart(reason: Throwable, message: Option[Any]): Unit = {
    println(s"Calling preRestart messasge ${message} reason ${reason.getMessage}")
    super.preRestart(reason, message)
  }

  override def postRestart(reason: Throwable): Unit = {
    println(s"Calling postRestart reason ${reason.getMessage}")
    super.postRestart(reason)
  }

  override def postStop(): Unit = {
    println("Calling postStop()")
    super.postStop()
  }

  override def receive: Receive = {
    case ForceRestart =>
      println(s"Incoming ForceRestart Path : ${self.path}")
      throw new Exception("test exception")
    case _ => println(s"Not supported path : ${self.path}")
  }
}