package msm.sc;

import org.apache.kafka.clients.producer.ProducerRecord;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
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

  @RequestMapping("/lookup")
  public Service lookup(@RequestParam(value="name") String name) {
    RestTemplate restTemplate = new RestTemplate();
    Service service = null;

    try {
      service = restTemplate.getForObject(lookupUri(name), Service.class);
    } catch(HttpClientErrorException e) {
      if(e.getStatusCode() == HttpStatus.NOT_FOUND)
        throw new ServiceNotFoundException();

      throw e;
    }

    return service;
  }

  private String lookupUri(String serviceName) {
    return String.format("http://%s/lookup?name=%s", sdfAddr(), serviceName);
  }

  private String sdfAddr() {
    String addr = System.getenv("SDF_ADDR");

    if(addr == null)
      addr = "localhost:9003";

    return addr;
  }
}
