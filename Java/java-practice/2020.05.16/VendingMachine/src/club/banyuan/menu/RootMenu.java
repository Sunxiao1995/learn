package club.banyuan.menu;


import club.banyuan.MachineMenuBuild;


public class RootMenu implements MachineMenu{


    @Override
    public void printCurrentMenu() {

        System.out.println("What would you like to do?\n" +
                " 1. Read product information\n" +
                " 2. Insert coin\n" +
                " 3. Press product button\n" +
                " 4. Press return button\n" +
                " 9. Open service menu (code required)\n" +
                " 0. Quit");
    }

    @Override
    public void executeYouChoose(String choose) {
        for (MachineMenuBuild chooseMenu : MachineMenuBuild.values()) {
            if (choose.equals(chooseMenu.getID())) {
                MachineMenuBuild.setChangeMenu(chooseMenu);
                return;
            }
        }
        throw new IllegalArgumentException();
    }

}
