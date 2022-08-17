package com.pramod.actor.deadletter

import akka.actor.{Actor, Props}

object BasicActor {
  def props() = Props.apply(new BasicActor())
}

class BasicActor extends Actor {
  override def receive: Receive = {
    case "Hi" => println(s"Hi Pramod")
    case "How" => sender() ! "Fine"
  }
}