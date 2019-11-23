package com.example.json_reader

case class WineMagJson(id: Int, country: String, title: String, variety: String, winery: String) {

  def print(): Unit = println(s"{id: $id; country: $country; title: $title; variety: $variety, winery: $winery}")
}




