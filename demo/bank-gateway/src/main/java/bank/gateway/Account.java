package bank.gateway;

public class Account {

  private final long id;

  public Account() {
    this.id = 0;
  }

  public Account(long id) {
    this.id = id;
  }

  public long getId() {
    return this.id;
  }
}
