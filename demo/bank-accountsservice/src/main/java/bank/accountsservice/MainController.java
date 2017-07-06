package bank.accountsservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

  private final AtomicLong counter = new AtomicLong(); 

  @RequestMapping("/create")
  public Account create() {
    return new Account(counter.incrementAndGet());
  }
}
