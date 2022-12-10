package ca.mcgill.server;

import com.google.gson.Gson;
import communicationbeans.User;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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


  // 1. username, 2. userage
  // return -> User that has been serialzied into json string -> User (new Gson())
  @PostMapping(value = "/users")
  public ResponseEntity<String> createUser(@RequestParam String username, @RequestParam int userage) {
    User newUser = new User(username, userage);
    String response = new Gson().toJson(newUser);
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

}
