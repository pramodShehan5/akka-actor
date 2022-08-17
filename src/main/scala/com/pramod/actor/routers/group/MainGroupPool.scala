package com.pramod.actor.routers.group

import akka.actor.{ActorSystem, Props}

object MainGroupPool extends App {
  val system = ActorSystem.create("group-pool")
  val worker1 = system.actorOf(Worker.props(),"worker1")
  val worker2 = system.actorOf(Worker.props(),"worker2")
  val worker3 = system.actorOf(Worker.props(),"worker3")
  println(s"worker1 ${worker1.path}")
  val workers = List("user/worker1", "user/worker2", "user/worker3")
  val router = system.actorOf(Props(classOf[GroupRouter], workers))
  router ! "Hello"
  router ! "Hello Pramod"
  router ! "Hello Achini"
  router ! "Hello world"
  router ! "Hello, Good morning"
  router ! "Hello, How are you"
  router ! "Hello Fine"
}
