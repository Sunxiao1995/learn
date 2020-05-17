package club.banyuan.menu;

import club.banyuan.Machine;
import club.banyuan.MachineMenuBuild;

public class WithdrawAllMoney implements MachineMenu{

    @Override
    public void printCurrentMenu() {
        System.out.println("(9-2) All money is being withdrawn.");
        System.out.println("$" + Machine.getMachineRevenue()+" is withdrawn.\n");
    }

    @Override
    public void executeYouChoose() {
        Machine.returnTheBalance();
        Machine.withDrawMoney();
        MachineMenuBuild.setChangeMenu(MachineMenuBuild.OPEN_SERVICE_MENU);

    }

}
