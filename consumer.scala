import java.util.{Collections, Properties}
import scala.collection.JavaConverters._
import org.apache.kafka.clients.consumer.{ConsumerRecords, KafkaConsumer}

val props = new Properties()
props.put("bootstrap.servers", "master1.internal.cloudapp.net:9092,  worker1.internal.cloudapp.net:9092, worker2.internal.cloudapp.net:9092, worker3.internal.cloudapp.net:9092")
props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
props.put("group.id", "consumer-group-1")

  val topic = "rupali1"
  val consumer: KafkaConsumer[Nothing, String] = new KafkaConsumer[Nothing, String](props)
  consumer.subscribe(Collections.singletonList(topic))

  while (true) {
    val records: ConsumerRecords[Nothing, String] = consumer.poll(100)
    for (record <- records.asScala) {
      println(record)
    }
  }

