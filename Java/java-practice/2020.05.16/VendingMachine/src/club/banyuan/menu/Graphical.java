package club.banyuan.menu;

import club.banyuan.Machine;
import club.banyuan.MachineMenuBuild;
import club.banyuan.Product;

public class Graphical implements MachineMenu{
    @Override

    /**
     * 打印图形界面
     */
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
    /**
     * 图形界面展示完会当即进入主菜单
     */
    public void executeYouChoose() {
        MachineMenuBuild.setChangeMenu(MachineMenuBuild.ROOT_MENU);

    }

    /**
     * 根据当前产品的数量 判断当前的亮灯情况
     * @param product 当前产品
     * @return 如果钱不够 不作出反应 缺货显示X 有货钱够显示O
     */
    public String returnUserPurchasingPower(Product product){
        if(Machine.getUserRemainingMoney() < product.getProductPrice()){
            return " ";
        } else if(product.getProductCount() <= 0){
            return "X";
        }else{
            return "O";
        }
    }
}
