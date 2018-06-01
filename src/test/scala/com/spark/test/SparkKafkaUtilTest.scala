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
  }
}