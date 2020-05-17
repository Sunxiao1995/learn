package club.banyuan.menu;

import club.banyuan.Machine;
import club.banyuan.MachineMenuBuild;

public class InsertCoin implements MachineMenu{
    @Override
    public void printCurrentMenu() {
        System.out.println("\n(2) Which coin would you like to insert?\n" +
                " 1. $1\n" +
                " 2. $2\n" +
                " 3. $5\n" +
                " 4. $10\n" +
                " 0. Go back");
    }

    @Override
    /**
     * 加钱 0返回上一级
     */
    public void executeYouChoose(String choose) {
        MachineMenu.isInputLegalOrNot(choose);
        if("5".equals(choose) || "9".equals(choose))
        {throw new IllegalArgumentException();}
        switch(choose){
            case "1":
            case "2":
            case "3":
            case "4":
                int insertMoneyAccordingChoose = Integer.parseInt(insertMoneyAccordingChoose(choose));
                Machine.initUserRemainingMoney(insertMoneyAccordingChoose);
                System.out.println("You have inserted $"+insertMoneyAccordingChoose(choose));
                if(MachineMenuBuild.ROOT_MENU.getCurrentMenu()instanceof RootMenu)
                MachineMenuBuild.GRAPHICAL_MENU.currentMenu.printCurrentMenu();
                break;
            case "0":
                System.out.println("Going back!");
                MachineMenuBuild.setChangeMenu(MachineMenuBuild.GRAPHICAL_MENU);
                break;
        }
    }


    /**
     * 根据对应的选择 返回每次应该添加的钱
     * @param choose
     * @return
     */
    private String insertMoneyAccordingChoose(String choose){
        switch (choose){
            case "1":
                return "1";
            case "2":
                return "2";
            case "3":
                return "5";
            case "4":
                return "10";
        }
        return "0";
    }
}
