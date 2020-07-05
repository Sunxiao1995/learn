package club.banyuan.Entity;

import java.util.Date;

public class Order {
  private Integer id;
  private Integer userId;
  private String loginName;
  private String userAddress;
  private Date createTime;
  private Double cost;
  private String serialNumber;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getLoginName() {
    return loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
  }

  public String getUserAddress() {
    return userAddress;
  }

  public void setUserAddress(String userAddress) {
    this.userAddress = userAddress;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Double getCost() {
    return cost;
  }

  public void setCost(Double cost) {
    this.cost = cost;
  }

  public String getSerialNumber() {
    return serialNumber;
  }

  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  @Override
  public String toString() {
    return "order{" +
        "id=" + id +
        ", userId=" + userId +
        ", loginName='" + loginName + '\'' +
        ", userAddress='" + userAddress + '\'' +
        ", createTime=" + createTime +
        ", cost=" + cost +
        ", serialNumber='" + serialNumber + '\'' +
        '}';
  }
}
