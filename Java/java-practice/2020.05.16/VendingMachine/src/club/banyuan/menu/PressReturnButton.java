package club.banyuan.menu;

import club.banyuan.Machine;
import club.banyuan.MachineMenuBuild;

public class PressReturnButton implements MachineMenu {
    @Override
    public void printCurrentMenu() {
        System.out.println("(4) Return button is pressed.\n" +
              "$" + Machine.getUserRemainingMoney()+" has been returned.");

    }

    /**
     * 用户退款 余额变成0 且最后一个被卖出的商品初始化
     */
    @Override
    public void executeYouChoose() {
        Machine.returnTheBalance();
        Machine.setAProductFinallySold("=");
        MachineMenuBuild.setChangeMenu(MachineMenuBuild.GRAPHICAL_MENU);

    }


}
