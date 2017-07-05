package msm.sdw;

import com.coreos.jetcd.Client;
import com.coreos.jetcd.ClientBuilder;
import com.coreos.jetcd.KV;
import com.coreos.jetcd.data.ByteSequence;

public class Writer {
  private KV kvClient;

  public Writer() throws Exception {
    String endpoint = etcdAddr(); 
    Client client = ClientBuilder.newBuilder().setEndpoints(endpoint).build();
    kvClient = client.getKVClient();
  }

  public void write(String key, String value) throws Exception {
    System.out.printf("Writing key: %s, value: %s%n", key, value);

    ByteSequence keyB = ByteSequence.fromString(key);
    ByteSequence valueB = ByteSequence.fromString(value);

    kvClient.put(keyB, valueB).get();
  }

  private String etcdAddr() {
    String envar = System.getenv("ETCD_ADDR");

    if(envar != null)
      return envar;

    return "http://0.0.0.0:2379";
  }
}
