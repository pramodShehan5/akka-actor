package com.pramod.actor.example2

import akka.actor.{Actor, DeadLetter, Props}

object SecondActor {
  def props = Props.apply(new SecondActor())
}

class SecondActor extends Actor {
  override def receive: Receive = {
    case "Hello" => println(s"Hello Hello ${context.sender()}")//sender() ! "Hello, How are you?"
    case msg: String => println(s"$msg sender => ${context.sender()}")
    case TestExampleTwo1(msg) => self ! s"Hello $msg"
    case DeadLetter => println(s"Dead letter")
  }
}
