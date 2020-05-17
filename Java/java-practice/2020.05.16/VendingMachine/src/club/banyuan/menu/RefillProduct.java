package club.banyuan.menu;

import club.banyuan.MachineMenuBuild;
import club.banyuan.Product;

public class RefillProduct implements MachineMenu{
    @Override
    public void printCurrentMenu() {
        System.out.println("\n(9-3) Which product would you like to refill?\n" +
                " 1. A\n" +
                " 2. B\n" +
                " 3. C\n" +
                " 4. D\n" +
                " 5. E\n" +
                " 0. Go back");

    }

    @Override
    public void executeYouChoose(String choose) {
        if (!"0".equals(choose)) {
            int chooseRefilledIndex = Integer.parseInt(choose) - 1;
            Product.values()[chooseRefilledIndex].filledProduct();
            System.out.println("You have refilled product " + Product.values()[chooseRefilledIndex].getID() + " to full.\n");
        }
        MachineMenuBuild.setChangeMenu(MachineMenuBuild.OPEN_SERVICE_MENU);
    }
}


