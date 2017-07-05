package msm.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.coreos.jetcd.Client;
import com.coreos.jetcd.ClientBuilder;
import com.coreos.jetcd.KV;
import com.coreos.jetcd.api.RangeResponse;

import java.util.concurrent.CompletableFuture;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    Client client = ClientBuilder.newBuilder().endpoints("http://localhost:2379").build();
    KV kvClient = client.getKVClient();
    CompletableFuture<RangeResponse> getFuture = kvClient.get(key);
    RangeResponse response = getFuture.get();
    System.out.print("Response: ");
    System.out.println(response);
    SpringApplication.run(Application.class, args);
  }
}
