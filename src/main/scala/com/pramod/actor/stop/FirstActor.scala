package com.pramod.actor.stop

import akka.actor.SupervisorStrategy.{Escalate, Restart, Resume, Stop}
import akka.actor.{Actor, OneForOneStrategy, Props, SupervisorStrategy}
import com.pramod.actor.supervisor.{RestartException, ResumeException, StopException}

import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

object FirstActor {
  def props() = Props.apply(new FirstActor())
}

class FirstActor extends Actor {
  override def postStop(): Unit = {
    println("Calling postStop()")
  }

  override def receive: Receive = {
    case msg: String => println(s"Incoming message $msg")
    case ContextStop =>
      context.stop(self)
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