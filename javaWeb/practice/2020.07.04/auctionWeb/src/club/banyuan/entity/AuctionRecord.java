package club.banyuan.entity;

import java.util.Date;

public class AuctionRecord {
  private int id;
  private int userId;
  private Date time;
  private int price;
  private int auctionItem_id;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public Date getTime() {
    return time;
  }

  public void setTime(Date time) {
    this.time = time;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getAuctionItem_id() {
    return auctionItem_id;
  }

  public void setAuctionItem_id(int auctionItem_id) {
    this.auctionItem_id = auctionItem_id;
  }

  @Override
  public String toString() {
    return "AuctionRecord{" +
        "id=" + id +
        ", userId=" + userId +
        ", time=" + time +
        ", price=" + price +
        ", auctionItem_id=" + auctionItem_id +
        '}';
  }
}
