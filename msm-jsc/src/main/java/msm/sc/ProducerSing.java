package msm.sc;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;

public class ProducerSing {
  private static Producer<String, String> instance; 

  public static Producer<String, String> i() {
    if(instance == null)
      return new KafkaProducer<>(props());
    else
      return instance;
  }

  private static Properties props() {
    String srlzr = "org.apache.kafka.common.serialization.StringSerializer";
    Properties props = new Properties();

    props.put("bootstrap.servers", kafkaAddr());
    props.put("acks", "all");
    props.put("retries", 0);
    props.put("batch.size", 16384);
    props.put("linger.ms", 1);
    props.put("buffer.memory", 33554432);
    props.put("key.serializer", srlzr); 
    props.put("value.serializer", srlzr);

    return props;
  }

  private static String kafkaAddr() {
    String addr = System.getenv("KAFKA_ADDR");

    if(addr == null)
      addr = "localhost:9092";
    
    return addr;
  }
}
