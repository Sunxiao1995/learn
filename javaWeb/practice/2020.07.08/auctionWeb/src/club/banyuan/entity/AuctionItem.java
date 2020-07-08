package club.banyuan.entity;

import java.util.Date;

public class AuctionItem {
  private int id;
  private String name;
  private String starting_price;
  private String base_price;
  private Date start_time;
  private Date end_time;
  private String description;

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

  public String getStarting_price() {
    return starting_price;
  }

  public void setStarting_price(String starting_price) {
    this.starting_price = starting_price;
  }

  public String getBase_price() {
    return base_price;
  }

  public void setBase_price(String base_price) {
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

  @Override
  public String toString() {
    return "AuctionItem{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", starting_price='" + starting_price + '\'' +
        ", base_price='" + base_price + '\'' +
        ", start_time=" + start_time +
        ", end_time=" + end_time +
        ", description='" + description + '\'' +
        '}';
  }
}
