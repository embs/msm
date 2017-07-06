package bank.gateway;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

  @RequestMapping("/accounts/create")
  public Account createAccount() {
    String createAccountUri = String.format("http://%s/create", accountsServiceAddr());
    RestTemplate restTemplate = new RestTemplate();

    return restTemplate.getForObject(createAccountUri, Account.class);
  }

  private String accountsServiceAddr() {
    RestTemplate restTemplate = new RestTemplate();
    Service service = null;

    String lookupUri = String.format("%s/lookup?name=%s",
      //"http://localhost:9001",
      "http://bank_gateway_msm-jsc:8080",
      "accounts_service");

    try {
      service = restTemplate.getForObject(lookupUri, Service.class);
    } catch(HttpClientErrorException e) {
      if(e.getStatusCode() == HttpStatus.NOT_FOUND)
        throw new ServiceNotFoundException();

      throw e;
    }

    return service.getAddress();
  }
}
