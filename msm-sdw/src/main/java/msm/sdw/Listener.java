package msm.sdw;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;

public class Listener {
  private Properties props;
  private KafkaConsumer<String, String> consumer;
  private final String TOPIC_TO_LISTEN = "register";
  private final String CONSUMER_GROUP = "msm-sdw";
  private final Integer POLLING_TIMEOUT = 100;

  public Listener() {
    buildProps();
    consumer = new KafkaConsumer<>(props);
    consumer.subscribe(Arrays.asList(TOPIC_TO_LISTEN));
  }

  public ConsumerRecords<String, String> poll() {
    return consumer.poll(POLLING_TIMEOUT);
  }

  private void buildProps() {
    props = new Properties();
    String srlzr = "org.apache.kafka.common.serialization.StringDeserializer";

    props.put("bootstrap.servers", kafkaAddr());
    props.put("group.id", CONSUMER_GROUP);
    props.put("enable.auto.commit", "true");
    props.put("auto.commit.interval.ms", "1000");
    props.put("key.deserializer", srlzr); 
    props.put("value.deserializer", srlzr); 
  }

  private String kafkaAddr() {
    String envar = System.getenv("KAFKA_ADDR");

    if(envar != null)
      return envar;

    return "localhost:9092";
  }
}
