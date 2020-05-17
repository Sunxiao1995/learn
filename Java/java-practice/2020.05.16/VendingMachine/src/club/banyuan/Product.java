package club.banyuan;

public enum Product {

    /**
     * 声明五个产品 构造时分别初始化价格 产品名 产品数量 以及在机器中的位置
     */

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

    /**
     * 每次用户购买产品后 调用此方法 产品数量减一 并且不为负
     */
    public void setProductCount() {

         productCount--;
         if(productCount < 0){
             productCount = 0;
         }
    }

    /**
     * 重新装填产品
     */
    public void filledProduct(){
         productCount = 10;
    }
}
