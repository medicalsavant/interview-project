package org.corrohealth.models;

public class PersonalDetails {
  private String email;
  private String phone;
  private String location;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }


  @Override
  public String toString() {
    return "PersonalDetails{" +
            "email='" + email + '\'' +
            ", phone='" + phone + '\'' +
            ", location='" + location + '\'' +
            '}';
  }
}
