package com.pramod.actor.routers.pool

import akka.actor.{Actor, ActorRef, Props}

object Router {
  def props() = Props.apply(new Router())
}

class Router extends Actor {
  var routees: List[ActorRef] = _

  override def preStart(): Unit = {
    routees = List.fill(5) {
      println("created")
      context.actorOf(Props[Worker])

    }
  }

  override def receive: Receive = {
    case msg: Work =>
      println(s"Router received ${msg.message} ")
      routees(util.Random.nextInt(routees.size))forward(msg)
  }
}
