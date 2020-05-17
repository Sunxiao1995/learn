package club.banyuan.menu;

import club.banyuan.MachineMenuBuild;

public class GoBack implements MachineMenu{

    /**
     * 返回主界面
     */
    @Override
    public void executeYouChoose() {
        MachineMenuBuild.setChangeMenu(MachineMenuBuild.GRAPHICAL_MENU);

    }

}
