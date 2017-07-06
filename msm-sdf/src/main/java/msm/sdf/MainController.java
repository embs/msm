package msm.sdf;

import com.coreos.jetcd.Client;
import com.coreos.jetcd.ClientBuilder;
import com.coreos.jetcd.KV;
import com.coreos.jetcd.kv.GetResponse;
import com.coreos.jetcd.kv.PutResponse;
import com.coreos.jetcd.data.ByteSequence;
import com.coreos.jetcd.data.KeyValue;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

  @RequestMapping("/lookup")
  public Service register(@RequestParam(value="name") String name) throws Exception {
    Client client = ClientBuilder.newBuilder().setEndpoints(etcdAddr()).build();
    KV kvClient = client.getKVClient();

    ByteSequence key = ByteSequence.fromString(name);

    CompletableFuture<GetResponse> getFuture = kvClient.get(key);
    GetResponse response = getFuture.get();
    List<KeyValue> kvs = response.getKvs();

    if(kvs.isEmpty())
      throw new ServiceNotFoundException();

    KeyValue kv = kvs.get(0);
    String serviceName = kv.getKey().toStringUtf8();
    String serviceAddr = kv.getValue().toStringUtf8();

    return new Service(serviceName, serviceAddr);
  }

  private String etcdAddr() {
    String envar = System.getenv("ETCD_ADDR");

    if(envar != null)
      return envar;

    return "http://0.0.0.0:2379";
  }
}
