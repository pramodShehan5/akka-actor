package com.pramod.actor.deadletter

import akka.actor.{Actor, DeadLetter, Props}

object DeadLetterActor {
  def props() = Props.apply(new DeadLetterActor())
}

class DeadLetterActor extends Actor {
  override def receive: Receive = {
    case d: DeadLetter => println(s"Received deadletter $d")
    case msg => println(s"Received msg => $msg")
  }
}
