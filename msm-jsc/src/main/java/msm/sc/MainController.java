package msm.sc;

import org.apache.kafka.clients.producer.ProducerRecord;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

  @RequestMapping("/register")
  public void register(@RequestParam(value="name") String name) {
    ProducerSing.i().send(new ProducerRecord<String,String>("register", name));
  }
}
