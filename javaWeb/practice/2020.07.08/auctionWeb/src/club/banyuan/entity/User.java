package club.banyuan.entity;

public class User {
  private int id;
  private String userName;
  private String password;
  private int identityNum;
  private int phoneNum;
  private String address;
  private int postalCode;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getIdentityNum() {
    return identityNum;
  }

  public void setIdentityNum(int identityNum) {
    this.identityNum = identityNum;
  }

  public int getPhoneNum() {
    return phoneNum;
  }

  public void setPhoneNum(int phoneNum) {
    this.phoneNum = phoneNum;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(int postalCode) {
    this.postalCode = postalCode;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", userName='" + userName + '\'' +
        ", password='" + password + '\'' +
        ", identityNum=" + identityNum +
        ", phoneNum=" + phoneNum +
        ", address='" + address + '\'' +
        ", postalCode=" + postalCode +
        '}';
  }
}
