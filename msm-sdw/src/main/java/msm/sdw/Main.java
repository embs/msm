package msm.sdw;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

public class Main {

  public static void main(String[] args) throws Exception {
    Listener listener = new Listener();
    Writer writer = new Writer();

    while (true) {
      ConsumerRecords<String, String> records = listener.poll();
      for (ConsumerRecord<String, String> record : records) {
        System.out.printf("offset = %d, key = %s, value = %s%n",
                          record.offset(), record.key(), record.value());

        writer.write(record.key(), record.value());
      }
    }
  }
}
