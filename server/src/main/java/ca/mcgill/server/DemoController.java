package ca.mcgill.server;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

  // 1. Resource location is at url + /online
  // http//127.0.0.1:8080
  @GetMapping(value = "/online")
  public String helloWorld() {
    return "This is a new text";
  }

  @GetMapping(value = "/api/gamenames")
  public String[] severalHelloWorld() {
    return new String[] {
        "str1", "str2"
    };
  }
}
