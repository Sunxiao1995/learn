package club.banyuan.vo;

import java.util.Date;

public class UserAndRecord {
  String name;
  Date start_time;
  Date end_time;
  int starting_price;
  int ending_price;
  String userName;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getStart_time() {
    return start_time;
  }

  public void setStart_time(Date start_time) {
    this.start_time = start_time;
  }

  public Date getEnd_time() {
    return end_time;
  }

  public void setEnd_time(Date end_time) {
    this.end_time = end_time;
  }

  public int getStarting_price() {
    return starting_price;
  }

  public void setStarting_price(int starting_price) {
    this.starting_price = starting_price;
  }

  public int getEnding_price() {
    return ending_price;
  }

  public void setEnding_price(int ending_price) {
    this.ending_price = ending_price;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  @Override
  public String toString() {
    return "UserAndRecord{" +
        "name='" + name + '\'' +
        ", start_time=" + start_time +
        ", end_time=" + end_time +
        ", starting_price=" + starting_price +
        ", ending_price=" + ending_price +
        ", userName='" + userName + '\'' +
        '}';
  }
}
