import java.util.Properties
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

  val props = new Properties() 
  props.put("bootstrap.servers", "master1.internal.cloudapp.net:9092, master2.internal.cloudapp.net:9092, worker1.internal.cloudapp.net:9092, worker2.internal.cloudapp.net:9092, worker3.internal.cloudapp.net:9092")  
  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

  
  val producer: KafkaProducer[Nothing, String] = new KafkaProducer[Nothing, String](props)

  
  val topic = "rupali1"

  println(s"Sending Records in Kafka Topic [$topic]")

  for (i <- 1 to 50) {
       val record: ProducerRecord[Nothing, String] = new ProducerRecord(topic, i.toString)
    println(s"$record")
    producer.send(record)
  }

  producer.close()


