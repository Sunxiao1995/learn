package club.banyuan.menu;

import club.banyuan.MachineMenuBuild;
import club.banyuan.Product;

public class ReadProductInformation implements MachineMenu{
    @Override
    public void printCurrentMenu() {
        System.out.println("A. "+ Product.FIRST_PRODUCT.getProductName()+"  ($"+Product.FIRST_PRODUCT.getProductPrice()+")\n"+
                "B. "+ Product.SECOND_PRODUCT.getProductName()+"  ($"+Product.SECOND_PRODUCT.getProductPrice()+")\n"+
                "C. "+ Product.THIRD_PRODUCT.getProductName()+"  ($"+Product.THIRD_PRODUCT.getProductPrice()+")\n"+
                "D. "+ Product.FOUR_PRODUCT.getProductName()+"  ($"+Product.FOUR_PRODUCT.getProductPrice()+")\n"+
                "E. "+ Product.FIVE_PRODUCT.getProductName()+"  ($"+Product.FIVE_PRODUCT.getProductPrice()+")\n");
    }

    @Override
    public void executeYouChoose() {
        MachineMenuBuild.setChangeMenu(MachineMenuBuild.ROOT_MENU);
    }
}
