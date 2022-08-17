package com.pramod.actor.routers.pool

import akka.actor.{Actor, Props}

object Worker {
  def props() = Props.apply(new Worker())
}

class Worker extends Actor {
  override def receive: Receive = {
    case Work(msg) => println(s"Received work message $msg actorRef ${self.path.name} context path ${context.self}")
  }
}