package ca.mcgill;

public class User {
  public User(String username, int userage) {
    this.username = username;
    this.userage = userage;
  }

  public String getUsername() {
    return username;
  }

  public int getUserage() {
    return userage;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setUserage(int userage) {
    this.userage = userage;
  }
  private String username;
  private int userage;
}
