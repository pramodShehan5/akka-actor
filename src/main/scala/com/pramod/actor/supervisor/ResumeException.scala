package com.pramod.actor.supervisor

case object ResumeException extends Exception

case object RestartException extends Exception

case object StopException extends Exception

case object PleaseRestart

case object PleaseResume

case object PleaseStop