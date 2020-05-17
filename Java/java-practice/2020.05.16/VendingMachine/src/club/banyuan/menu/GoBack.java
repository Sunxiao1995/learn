package club.banyuan.menu;

import club.banyuan.MachineMenuBuild;

public class GoBack implements MachineMenu{
    @Override
    public void printCurrentMenu() {

    }

    @Override
    public void executeYouChoose() {
        MachineMenuBuild.setChangeMenu(MachineMenuBuild.GRAPHICAL_MENU);

    }

}
