package com.example.json_reader

import org.apache.spark.sql.SparkSession
import org.json4s._
import org.json4s.jackson.JsonMethods._

import spray.json._
import DefaultJsonProtocol._


//case class TmpJson(id: Int, country: String, title: String, variety: String, winery: String)
//
//object TmpJsonProtocol extends DefaultJsonProtocol {
//  implicit val colorFormat = jsonFormat5(TmpJson)
//}


object JsonReader extends App {
  val (inputFile) = (args(0))

  val spark = SparkSession.builder()
    .appName("json_reader")
    .master("local[*]")
    .getOrCreate()

  val sc = spark.sparkContext

//  implicit val formats = DefaultFormats

  val lines = sc.textFile(inputFile)

  println("\n\nstart 0\n\n")

//  val a = parse("""{"id":0,"country":"Italy","points":87,"title":"Nicosia 2013 Vulkà Bianco  (Etna)","variety":"White Blend","winery":"Nicosia"}""")
//  val b = a.extract[WineMagJson]
//  b.print()

  implicit val wineFormat = jsonFormat5(WineMagJson)

//  val l = """{"id":0,"country":"Italy","points":87,"title":"Nicosia 2013 Vulkà Bianco  (Etna)","variety":"White Blend","winery":"Nicosia"}"""
//  val a = l.parseJson
//  val b = a.convertTo[WineMagJson]
//  b.print()


  println("\n\nstart\n\n")
//  lines.take(10)
//      .foreach(line => println(line))
//  lines.take(10)
//    .map(line => parse(line))
//    .foreach(jsonb => jsonb.extract[WineMagJson].print())

    lines.take(10)
      .map(line => line.parseJson)
      .foreach(ast => ast.convertTo[WineMagJson].print())

  println("\n\nend\n\n")
}
