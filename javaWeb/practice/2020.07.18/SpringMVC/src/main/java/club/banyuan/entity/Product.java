package club.banyuan.entity;

public class Product {

  private Integer id;
  private String name;
  private String description;
  private Double price;
  private Integer stock;
  private Integer categoryLevel1Id;
  private Integer categoryLevel2Id;
  private Integer categoryLevel3Id;
  private String fileName;
  private Integer isDelete;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Integer getStock() {
    return stock;
  }

  public void setStock(Integer stock) {
    this.stock = stock;
  }

  public Integer getCategoryLevel1Id() {
    return categoryLevel1Id;
  }

  public void setCategoryLevel1Id(Integer categoryLevel1Id) {
    this.categoryLevel1Id = categoryLevel1Id;
  }

  public Integer getCategoryLevel2Id() {
    return categoryLevel2Id;
  }

  public void setCategoryLevel2Id(Integer categoryLevel2Id) {
    this.categoryLevel2Id = categoryLevel2Id;
  }

  public Integer getCategoryLevel3Id() {
    return categoryLevel3Id;
  }

  public void setCategoryLevel3Id(Integer categoryLevel3Id) {
    this.categoryLevel3Id = categoryLevel3Id;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public Integer getIsDelete() {
    return isDelete;
  }

  public void setIsDelete(Integer isDelete) {
    this.isDelete = isDelete;
  }

  @Override
  public String toString() {
    return "product{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", description='" + description + '\'' +
        ", price=" + price +
        ", stock=" + stock +
        ", categoryLevel1Id=" + categoryLevel1Id +
        ", categoryLevel2Id=" + categoryLevel2Id +
        ", categoryLevel3Id=" + categoryLevel3Id +
        ", fileName='" + fileName + '\'' +
        ", isDelete=" + isDelete +
        '}';
  }

  @Override
  public int hashCode() {

    int result = 10;
    result = 31 * result + name.hashCode();
    result = 31 * result + id;

    return result;
  }

  @Override
  public boolean equals(Object obj) {
    Product product = (Product) obj;
    if (id.equals(product.getId())) {
      return true;
    } else {
      return false;
    }
  }
}
