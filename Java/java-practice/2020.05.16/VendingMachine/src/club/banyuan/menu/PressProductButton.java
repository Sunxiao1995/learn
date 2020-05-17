package club.banyuan.menu;

import club.banyuan.Machine;
import club.banyuan.MachineMenuBuild;
import club.banyuan.Product;

public class PressProductButton implements MachineMenu{
    @Override
    public void printCurrentMenu() {
        System.out.println("\n(3) Which product button would you like to press?\n" +
                " 1. A\n" +
                " 2. B\n" +
                " 3. C\n" +
                " 4. D\n" +
                " 5. E\n" +
                " 0. Go back");
    }

    @Override
    public void executeYouChoose() {

    }

    @Override
    public void executeYouChoose(String choose) {
        switch (choose){
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
                Product aProduct = Product.values()[Integer.parseInt(choose)-1];
                if(aProduct.getProductCount() <= 0){
                    System.out.println("Products to sell out");
                    break;
                }
                if(aProduct.getProductPrice() > Machine.getUserRemainingMoney()){
                    System.out.println("You have pressed button "+Product.values()[Integer.parseInt(choose)-1].getID());
                    System.out.println("invalid choice");
                    MachineMenuBuild.setChangeMenu(MachineMenuBuild.GRAPHICAL_MENU);
                    break;
                }
                Product.values()[Integer.parseInt(choose)-1].setProductCount();
                Machine.setUserRemainingMoney(Product.values()[Integer.parseInt(choose)-1].getProductPrice());
                Machine.setMachineRevenue(Product.values()[Integer.parseInt(choose)-1].getProductPrice());
                Machine.setAProductFinallySold(Product.values()[Integer.parseInt(choose)-1].getID());
                MachineMenuBuild.setChangeMenu(MachineMenuBuild.GRAPHICAL_MENU);
                System.out.println("You have pressed button "+Product.values()[Integer.parseInt(choose)-1].getID());
                break;
            case "0":
                MachineMenuBuild.setChangeMenu(MachineMenuBuild.GRAPHICAL_MENU);
                break;
        }

    }

}
