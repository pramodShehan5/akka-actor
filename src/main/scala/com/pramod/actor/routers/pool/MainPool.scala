package com.pramod.actor.routers.pool

import akka.actor.ActorSystem

object MainPool extends App {
  val system = ActorSystem.create("pool")
  val routerActor = system.actorOf(Router.props(), "router")
  routerActor ! Work("Hello World")
  routerActor ! Work("I am World")
  routerActor ! Work("How are you")
  routerActor ! Work("My name is Achini")

  system.terminate()
}
