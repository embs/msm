package bank.accountsservice;

public class Account {

  private final long id;

  public Account(long id) {
    this.id = id;
  }

  public long getId() {
    return this.id;
  }
}
