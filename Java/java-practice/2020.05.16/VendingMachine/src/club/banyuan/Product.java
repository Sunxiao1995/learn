package club.banyuan;

public enum Product {


    FIRST_PRODUCT(10,"Juice",10,"A"),
    SECOND_PRODUCT(6,"Cola",10,"B"),
    THIRD_PRODUCT(5,"Tea",10,"C"),
    FOUR_PRODUCT(8,"Water",10,"D"),
    FIVE_PRODUCT(7,"Coffer",10,"E");


    private int productPrice;
    private String productName;
    private int productCount;
    private String ID;

     Product(int productPrice,String productName,int productCount,String ID){
        this.productPrice = productPrice;
        this.productName = productName;
        this.productCount = productCount;
        this.ID = ID;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductCount() {
        return productCount;
    }

    public String getID() {
        return ID;
    }

    public void setProductCount() {

         productCount--;
    }
    public void filledProduct(){
         productCount = 10;
    }
}
