package club.banyuan.menu;

import club.banyuan.MachineMenuBuild;

public class OpenServiceMenu implements MachineMenu {
    @Override
    public void printCurrentMenu() {
        System.out.println(
                "\n(9) What would you like to do?\n" +
                " 1. Inspect machine status\n" +
                " 2. Withdraw all money\n" +
                " 3. Refill product\n" +
                " 4. Change product\n" +
                " 0. Go back");

    }


    @Override
    public void executeYouChoose(String choose) {
        MachineMenu.isInputLegalOrNot(choose);
        if("5".equals(choose) || "9".equals(choose))
        {throw new IllegalArgumentException();}
        String childChoose = "9-"+choose;
        for (MachineMenuBuild chooseMenu : MachineMenuBuild.values()) {
            if (childChoose.equals(chooseMenu.getID())) {
                MachineMenuBuild.setChangeMenu(chooseMenu);
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
