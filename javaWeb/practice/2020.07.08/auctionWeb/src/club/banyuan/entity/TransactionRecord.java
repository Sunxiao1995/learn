package club.banyuan.entity;

public class TransactionRecord {
  private int id;
  private int transaction_price;
  private int user_id;
  private int auctionItem_id;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getTransaction_price() {
    return transaction_price;
  }

  public void setTransaction_price(int transaction_price) {
    this.transaction_price = transaction_price;
  }

  public int getUser_id() {
    return user_id;
  }

  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }

  public int getAuctionItem_id() {
    return auctionItem_id;
  }

  public void setAuctionItem_id(int auctionItem_id) {
    this.auctionItem_id = auctionItem_id;
  }

  @Override
  public String toString() {
    return "TransactionRecord{" +
        "id=" + id +
        ", transaction_price=" + transaction_price +
        ", user_id=" + user_id +
        ", auctionItem_id=" + auctionItem_id +
        '}';
  }
}
