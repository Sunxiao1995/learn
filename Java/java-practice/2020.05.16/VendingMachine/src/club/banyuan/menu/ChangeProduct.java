package club.banyuan.menu;

import club.banyuan.MachineMenuBuild;
import club.banyuan.Product;

import java.util.Scanner;

public class ChangeProduct implements MachineMenu {

    @Override
    public void printCurrentMenu() {
        System.out.println("\n(4-4) Which product would you like to change?\n" +
                " 1. A\n" +
                " 2. B\n" +
                " 3. C\n" +
                " 4. D\n" +
                " 5. E\n" +
                " 0. Go back");

    }


    @Override
    /**
     * 根据用户的输入可以得到位置 0返回上一级
     * 根据位置找到产品分别修改产品名 价格 并填充产品
     * 输入
     */
    public void executeYouChoose(String choose) {
        MachineMenu.isInputLegalOrNot(choose);
        if("9".equals(choose))
        {throw new IllegalArgumentException();}
        if (!"0".equals(choose)) {
            System.out.println("Your choice: " + choose);
            System.out.println("You are changing product " + Product.values()[Integer.parseInt(choose) - 1].getID());
            System.out.print("Enter new product name :");

            Scanner sc = new Scanner(System.in);
            String changeProductName = sc.nextLine();

            System.out.print("Enter new product price :");
            Scanner scanner = new Scanner(System.in);
            int changeProductPrice = scanner.nextInt();
            Product.values()[Integer.parseInt(choose) - 1].setProductName(changeProductName);
            Product.values()[Integer.parseInt(choose) - 1].setPrice(changeProductPrice);
            Product.values()[Integer.parseInt(choose) - 1].filledProduct();
            System.out.println("\nThe new product " + Product.values()[Integer.parseInt(choose) - 1].getID() + " has been filled to full.");
        }
        MachineMenuBuild.setChangeMenu(MachineMenuBuild.OPEN_SERVICE_MENU);
    }
}
