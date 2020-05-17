package club.banyuan.menu;

import club.banyuan.Machine;
import club.banyuan.MachineMenuBuild;
import club.banyuan.Product;

public class Graphical implements MachineMenu{
    @Override
    public void printCurrentMenu() {
        System.out.print("\n"+
                "*---------------------------*\n" +
                "|     Vending   Machine     |\n" +
                "*---------------------------*\n" +
                "|   A    B    C    D    E   |\n");
        System.out.print("|  $"+ Product.FIRST_PRODUCT.getProductPrice()+"  $ "+
                Product.SECOND_PRODUCT.getProductPrice()+"  $ "+
                Product.THIRD_PRODUCT.getProductPrice()+"  $ "+
                Product.FOUR_PRODUCT.getProductPrice()+"  $ "+
                Product.FIVE_PRODUCT.getProductPrice()+"  |\n");
        System.out.print("|  ["+returnUserPurchasingPower(Product.FIRST_PRODUCT)+"]  ["+
                returnUserPurchasingPower(Product.SECOND_PRODUCT)+"]  ["+
                returnUserPurchasingPower(Product.THIRD_PRODUCT)+"]  ["+
                returnUserPurchasingPower(Product.FOUR_PRODUCT)+"]  ["+
                returnUserPurchasingPower(Product.FIVE_PRODUCT)+"]  |\n");
        System.out.printf("*---------------------------*\n"+
                "|                  [$%2d]    |\n"+
                "|                           |\n"+
                "|           [=%s=]           |\n"+
                "*---------------------------*\n", Machine.getUserRemainingMoney(),Machine.getAProductFinallySold());
    }

    @Override
    public void executeYouChoose() {
        MachineMenuBuild.setChangeMenu(MachineMenuBuild.ROOT_MENU);

    }


    public String returnUserPurchasingPower(Product product){
        if(Machine.getUserRemainingMoney() < product.getProductPrice()){
            return " ";
        } else if(product.getProductCount() < 0){
            return "X";
        }else{
            return "O";
        }
    }
}
