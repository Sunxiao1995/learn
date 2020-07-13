package club.banyuan.entity;

import java.util.Date;

public class Address {
  private Integer id;
  private Integer userId;
  private String address;
  private Date createTime;
  private Integer isDefault;
  private String remake;

  public Address() {
  }

  public Address(Integer id, Integer userId, String address, Date createTime,
      Integer isDefault, String remake) {
    this.id = id;
    this.userId = userId;
    this.address = address;
    this.createTime = createTime;
    this.isDefault = isDefault;
    this.remake = remake;
  }

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

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Integer getIsDefault() {
    return isDefault;
  }

  public void setIsDefault(Integer isDefault) {
    this.isDefault = isDefault;
  }

  public String getRemake() {
    return remake;
  }

  public void setRemake(String remake) {
    this.remake = remake;
  }

  @Override
  public String toString() {
    return "Address{" +
        "id=" + id +
        ", userId=" + userId +
        ", address='" + address + '\'' +
        ", createTime=" + createTime +
        ", isDefault=" + isDefault +
        ", remake='" + remake + '\'' +
        '}';
  }
}
