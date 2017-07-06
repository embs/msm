package msm.sc;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ServiceNotFoundException extends RuntimeException {

  public ServiceNotFoundException() {
    super("There is currently no service available for the given name.");
  }
}
