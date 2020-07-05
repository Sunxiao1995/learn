package club.banyuan.Entity;

public class Order_detail {
  private Integer id;
  private Integer orderId;
  private Integer productId;
  private Integer quantity;
  private Double cost;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Double getCost() {
    return cost;
  }

  public void setCost(Double cost) {
    this.cost = cost;
  }

  @Override
  public String toString() {
    return "order_detail{" +
        "id=" + id +
        ", orderId=" + orderId +
        ", productId=" + productId +
        ", quantity=" + quantity +
        ", cost=" + cost +
        '}';
  }
}
