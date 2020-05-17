package club.banyuan.menu;

import club.banyuan.Machine;
import club.banyuan.MachineMenuBuild;
import club.banyuan.Product;

public class InspectMachineStatus implements MachineMenu{
    @Override
    public void printCurrentMenu() {
        System.out.println("(9-1) Machine status");
        System.out.println("Amount of revenue: $"+ Machine.getMachineRevenue());
        System.out.println("Amount of inserted coins : $" +Machine.getUserRemainingMoney());
        System.out.println( "A. "+ Product.FIRST_PRODUCT.getProductName()+"  ($"+Product.FIRST_PRODUCT.getProductPrice()+")"+String.valueOf(Product.FIRST_PRODUCT.getProductCount()) +" left\n"+
                "B. "+ Product.SECOND_PRODUCT.getProductName()+"  ($"+Product.SECOND_PRODUCT.getProductPrice()+")"+String.valueOf(Product.SECOND_PRODUCT.getProductCount()) +" left\n"+
                "C. "+ Product.THIRD_PRODUCT.getProductName()+"  ($"+Product.THIRD_PRODUCT.getProductPrice()+")"+String.valueOf(Product.THIRD_PRODUCT.getProductCount()) +" left\n"+
                "D. "+ Product.FOUR_PRODUCT.getProductName()+"  ($"+Product.FOUR_PRODUCT.getProductPrice()+")"+String.valueOf(Product.FOUR_PRODUCT.getProductCount()) +" left\n"+
                "E. "+ Product.FIVE_PRODUCT.getProductName()+"  ($"+Product.FIVE_PRODUCT.getProductPrice()+")"+String.valueOf(Product.FIVE_PRODUCT.getProductCount()) +" left\n");
    };


    @Override
    public void executeYouChoose() {
        MachineMenuBuild.setChangeMenu(MachineMenuBuild.OPEN_SERVICE_MENU);
    }


}
