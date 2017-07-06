package msm.sdf;

public class Service {
  private final String name;
  private final String address;

  public Service(String name, String address) {
    this.name = name;
    this.address = address;
  }

  public String getName() {
    return this.name;
  }

  public String getAddress() {
    return this.address;
  }
}
