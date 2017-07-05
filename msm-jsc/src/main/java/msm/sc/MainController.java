package msm.sc;

import org.apache.kafka.clients.producer.ProducerRecord;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

  @RequestMapping("/register")
  public void register(@RequestParam(value="name") String name,
                       @RequestParam(value="host") String host,
                       @RequestParam(value="port") String port) {
    ProducerRecord<String, String> record;
    final String TOPIC = "register";
    String address = String.format("%s:%s", host, port);
    record = new ProducerRecord<String, String>(TOPIC, name, address);

    ProducerSing.i().send(record);
  }
}
