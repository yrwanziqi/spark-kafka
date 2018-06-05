package com.spark.test

import org.apache.spark.streaming.kafka.SparkKafkaUtil
import org.apache.spark.core.SparkKafkaContext

object SparkKafkaUtilTest {
  def main(args: Array[String]): Unit = {
   val kp = SparkKafkaContext.getKafkaParam(
      brokers, 
      "botservice_probe_retry", 
      "consum",   // last/consum
      "last" //wrong_from
      )
    val topics=Set("mac_probelog")
    val sku=new SparkKafkaUtil(kp)
  //sku.updataOffsetToEarliest(topics, kp)
  sku.getConsumerOffset(kp, "botservice_probe_retry",topics).foreach(println)
   //sku.getEarliestOffsets(topics, kp).foreach(println)
   //最早的
   //val offsets=s"""mac_probelog,0,480645996|mac_probelog_wifi,1,16622577|mac_probelog_wifi,4,16261842|mac_probelog_wifi,3,16036652|mac_probelog_wifi,5,17184533|mac_probelog_wifi,0,16416957|mac_probelog_wifi,2,15432487"""
   //sku.updataOffsetToCustom(kp, offsets)
  }
}