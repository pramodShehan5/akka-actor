package com.pramod.actor.supervisor

import akka.actor.SupervisorStrategy.{Escalate, Restart, Resume, Stop}
import akka.actor.{Actor, ActorRef, AllForOneStrategy, OneForOneStrategy, Props, SupervisorStrategy}

import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

object MyParentActor {
//  def props(childActor: ActorRef) = Props.apply(new MyParentActor(childActor))
  def props() = Props.apply(new MyParentActor())
}

class MyParentActor() extends Actor {

  var routees: List[ActorRef] = _

  override def preStart(): Unit = {
    routees = List.fill(3) {
      val child = context.actorOf(Props[MyChildActor])
      println(s"created ${child}")
      child
//      val childActor = context.actorOf(MyChildActor.props)
    }
  }

  override def receive: Receive = {
    case "Restart" =>
      println(s"Receiving msg HelloChild ${context.self}")
//      val childActor = context.actorOf(MyChildActor.props)
      routees(util.Random.nextInt(routees.size)) ! PleaseRestart
    case "HelloChildContinue" =>
      println(s"Receiving HelloChildContinue msg ${context.self}")
//      val childActor = context.actorOf(MyChildActor.props)
      routees(util.Random.nextInt(routees.size)) ! "Hello"
  }

  override def supervisorStrategy: SupervisorStrategy = {
    OneForOneStrategy(maxNrOfRetries = 10, withinTimeRange = 1 minute) {
      case ResumeException =>
        println(s"Resume child actor")
        Resume
      case RestartException =>
        println(s"Restart")
        Restart
      case StopException =>
        println("Stop")
        Stop
      case _ =>
        println("Escalate")
        Escalate
    }
  }
}
