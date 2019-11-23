package com.example.json_reader

import spray.json._
import DefaultJsonProtocol._

case object WineMagJsonProtocol extends DefaultJsonProtocol {
  implicit val colorFormat = jsonFormat5(WineMagJson)
}
