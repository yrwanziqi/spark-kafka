package org.apache.spark.core

trait SparkKafkaConfsKey {
   val GROUPID="group.id"
   val BROKER="metadata.broker.list"
   val SERIALIZER="serializer.class"
   /*
    * 如果groupid不存在或者过期选择从last还是从earliest开始
    */
   val WRONG_GROUP_FROM="wrong.groupid.from"
   /*
    * 从last还是从consumer开始
    */
   val CONSUMER_FROM="kafka.consumer.from"
   
   val KAFKAOFFSET="kafka.offset"
   val MAX_RATE_PER_PARTITION="spark.streaming.kafka.maxRatePerPartition"
}