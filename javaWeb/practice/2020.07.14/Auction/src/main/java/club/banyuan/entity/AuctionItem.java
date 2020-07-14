package club.banyuan.entity;

import java.util.Date;

public class AuctionItem {
  private int id;
  private String name;
  private Integer starting_price;
  private Integer base_price;
  private Date start_time;
  private Date end_time;
  private String description;
  private Integer state;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getStarting_price() {
    return starting_price;
  }

  public void setStarting_price(Integer starting_price) {
    this.starting_price = starting_price;
  }

  public Integer getBase_price() {
    return base_price;
  }

  public void setBase_price(Integer base_price) {
    this.base_price = base_price;
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getState() {
    return state;
  }

  public void setState(Integer state) {
    this.state = state;
  }

  public AuctionItem(int id, String name, Integer starting_price, Integer base_price,
      Date start_time, Date end_time, String description, Integer state) {
    this.id = id;
    this.name = name;
    this.starting_price = starting_price;
    this.base_price = base_price;
    this.start_time = start_time;
    this.end_time = end_time;
    this.description = description;
    this.state = state;
  }

  public AuctionItem() {
  }

  @Override
  public String toString() {
    return "AuctionItem{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", starting_price=" + starting_price +
        ", base_price=" + base_price +
        ", start_time=" + start_time +
        ", end_time=" + end_time +
        ", description='" + description + '\'' +
        ", state=" + state +
        '}';
  }
}
