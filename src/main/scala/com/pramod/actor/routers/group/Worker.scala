package com.pramod.actor.routers.group

import akka.actor.{Actor, Props}

object Worker {
  def props() = Props.apply(new Worker())
}

class Worker extends Actor {
  override def receive: Receive = {
    case msg: String => println(s"Received $msg actorRef ${self.path.name}")
  }
}
