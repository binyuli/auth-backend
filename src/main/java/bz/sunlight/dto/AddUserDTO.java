package bz.sunlight.dto;

import java.util.List;

public class AddUserDTO {
  private String name;
  private String username;
  private String password;
  private List<String> roles;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<String> getRoles() {
    return roles;
  }

  public void setRoles(List<String> roles) {
    this.roles = roles;
  }

  @Override
  public String toString() {
    return "AddUserDTO{" +
        "name='" + name + '\'' +
        ", username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", roles=" + roles +
        '}';
  }
}
