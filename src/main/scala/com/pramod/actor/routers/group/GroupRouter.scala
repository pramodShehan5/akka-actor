package com.pramod.actor.routers.group

import akka.actor.{Actor, Props}

//object GroupRouter {
//  def props() = Props.apply(new GroupRouter())
//}

class GroupRouter(routees: List[String]) extends Actor {
  override def receive: Receive = {
    case msg: String =>
      println(s"Router received $msg ")
      context.actorSelection(routees(util.Random.nextInt(routees.size))) forward (msg)
  }
}
