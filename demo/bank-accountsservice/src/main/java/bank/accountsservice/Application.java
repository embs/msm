package bank.accountsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    new Application().register();
    SpringApplication.run(Application.class, args);
  }

  private void register() {
    RestTemplate restTemplate = new RestTemplate();

    String uri = String.format("%s/register?name=%s&host=%s&port=%s",
      "http://bank_accountsservice_msm-jsc:8080",
      //"http://localhost:9001",
      "accounts_service",
      "bank_accountsservice",
      //"localhost",
      "8080");

    restTemplate.getForEntity(uri, String.class);
  }
}
