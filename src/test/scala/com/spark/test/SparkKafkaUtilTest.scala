package com.spark.test

import org.apache.spark.streaming.kafka.SparkKafkaUtil
import org.apache.spark.core.SparkKafkaContext

object SparkKafkaUtilTest {
  def main(args: Array[String]): Unit = {
   val kp = SparkKafkaContext.getKafkaParam(
      brokers, 
      "dataflow-um_test", 
      "consum",   // last/consum
      "last" //wrong_from
      )
    val sku=new SparkKafkaUtil(kp)
   sku.getConsumerOffset(kp, "dataflow-um_test", Set("dmpumevent"))
     .foreach(println)
     //最早的
   val ss=s"""dmpumevent,5,12199951|dmpumevent,7,5072744|dmpumevent,51,1911015|dmpumevent,63,1911138|dmpumevent,37,1907969|dmpumevent,64,1908026|dmpumevent,65,1911937|dmpumevent,46,1908044|dmpumevent,56,1911912|dmpumevent,25,1908041|dmpumevent,72,1911076|dmpumevent,11,5076640|dmpumevent,71,1911914|dmpumevent,17,5076667|dmpumevent,35,1911959|dmpumevent,33,1911023|dmpumevent,79,1908051|dmpumevent,27,1911091|dmpumevent,26,1911892|dmpumevent,73,1908036|dmpumevent,57,1911021|dmpumevent,1,12391436|dmpumevent,2,13128909|dmpumevent,47,1911955|dmpumevent,38,1911928|dmpumevent,75,1911026|dmpumevent,61,1907976|dmpumevent,39,1911031|dmpumevent,23,1911868|dmpumevent,52,1908080|dmpumevent,32,1911908|dmpumevent,8,5076655|dmpumevent,77,1911890|dmpumevent,44,1911892|dmpumevent,20,1911928|dmpumevent,74,1911893|dmpumevent,69,1911121|dmpumevent,68,1911947|dmpumevent,76,1908087|dmpumevent,31,1908041|dmpumevent,14,5076708|dmpumevent,19,5072769|dmpumevent,70,1908051|dmpumevent,40,1908052|dmpumevent,18,5075755|dmpumevent,0,11622029|dmpumevent,16,5072812|dmpumevent,29,1911947|dmpumevent,21,1911036|dmpumevent,3,11846886|dmpumevent,53,1911995|dmpumevent,78,1911171|dmpumevent,4,12146933|dmpumevent,59,1911865|dmpumevent,36,1911056|dmpumevent,54,1911122|dmpumevent,67,1907965|dmpumevent,34,1908016|dmpumevent,66,1910985|dmpumevent,10,5072730|dmpumevent,43,1908031|dmpumevent,62,1911946|dmpumevent,60,1911161|dmpumevent,49,1908017|dmpumevent,50,1911883|dmpumevent,42,1910978|dmpumevent,30,1911017|dmpumevent,24,1911031|dmpumevent,28,1908054|dmpumevent,22,1908061|dmpumevent,13,5072789|dmpumevent,15,5075747|dmpumevent,58,1908012|dmpumevent,12,5075745|dmpumevent,45,1911133|dmpumevent,55,1908073|dmpumevent,41,1911857|dmpumevent,48,1911040|dmpumevent,9,5075781|dmpumevent,6,5075709"""
   sku.updateConsumerOffsets(kp, ss)
  }
}