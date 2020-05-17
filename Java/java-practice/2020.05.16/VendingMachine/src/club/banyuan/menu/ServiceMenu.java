package club.banyuan.menu;

import club.banyuan.Machine;
import club.banyuan.MachineMenuBuild;

import java.util.Scanner;

public class ServiceMenu implements MachineMenu{
    @Override
    public void printCurrentMenu() {
        System.out.println("\n(9) Opening service menu. Access code is required.");
        System.out.print("Enter access code: ");
    }

    /**
     * 密码正确才能进入管理员界面
     */
    @Override
    public void executeYouChoose() {
        Scanner sc = new Scanner(System.in);
        String password =  sc.nextLine();
        if(Machine.getServicePassword().equals(password)){
            System.out.println("Correct code!");
            MachineMenuBuild.setChangeMenu(MachineMenuBuild.OPEN_SERVICE_MENU);
        }else {
            System.out.println("Incorrect code!");
            MachineMenuBuild.setChangeMenu(MachineMenuBuild.GRAPHICAL_MENU);
        }
    }


}
