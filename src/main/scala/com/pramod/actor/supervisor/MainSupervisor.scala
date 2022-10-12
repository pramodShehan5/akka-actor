package com.pramod.actor.supervisor

import akka.actor.ActorSystem

object MainSupervisor extends App {
  val system = ActorSystem.create("supervisor")
//  val childActor = system.actorOf(MyChildActor.props)
  val parentActor = system.actorOf(MyParentActor.props)
  parentActor ! "HelloChildContinue"
  parentActor ! "HelloChildContinue"
  parentActor ! "HelloChildContinue"
  parentActor ! "HelloChildContinue"
  parentActor ! "Restart"
  parentActor ! "HelloChildContinue"
  parentActor ! "HelloChildContinue"
  parentActor ! "HelloChildContinue"
  parentActor ! "HelloChildContinue"
  parentActor ! "HelloChildContinue"
  parentActor ! "HelloChildContinue"
  parentActor ! "HelloChildContinue"
}