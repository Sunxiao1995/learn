package club.banyuan;

import java.util.Scanner;

public class Machine {
    private static final String ServicePassword = "1110";

    private static int MachineRevenue;
    private static int userRemainingMoney = 0;

    private static String aProductFinallySold = "=";

    public static String getServicePassword() {
        return ServicePassword;
    }

    public static int getUserRemainingMoney() {
        return userRemainingMoney;
    }

    public static void initUserRemainingMoney(int insertMoney) {
        userRemainingMoney += insertMoney;
    }

    public static void setUserRemainingMoney(int userRemainingMoney) {
        Machine.userRemainingMoney -= userRemainingMoney;
        if (userRemainingMoney < 0) {
            Machine.userRemainingMoney = 0;
        }
    }

    public static int getMachineRevenue() {
        return MachineRevenue;
    }

    public static void setMachineRevenue(int userBuy) {
        MachineRevenue += userBuy;
    }

    public static String getAProductFinallySold() {
        return aProductFinallySold;
    }

    public static void setAProductFinallySold(String aProductFinallySold) {
        Machine.aProductFinallySold = aProductFinallySold;
    }

    public static void withDrawMoney(){
        MachineRevenue = 0;
    }

    public static void returnTheBalance() {
        userRemainingMoney = 0;
    }

    public static void useMachine() {
        while (MachineMenuBuild.getChangeMenu() != MachineMenuBuild.QUIT) {
            MachineMenuBuild.getChangeMenu().currentMenu.printCurrentMenu();
            if (MachineMenuBuild.getChangeMenu() == MachineMenuBuild.READ_PRODUCT_INFORMATION ||
                    MachineMenuBuild.getChangeMenu() == MachineMenuBuild.GRAPHICAL_MENU ||
                    MachineMenuBuild.getChangeMenu() == MachineMenuBuild.SERVICE_MENU ||
                    MachineMenuBuild.getChangeMenu() == MachineMenuBuild.INSPECT_MACHINE_STATUS ||
                    MachineMenuBuild.getChangeMenu() == MachineMenuBuild.GO_BACK ||
                    MachineMenuBuild.getChangeMenu() == MachineMenuBuild.PRESS_RETURN_BUTTON ||
                    MachineMenuBuild.getChangeMenu() == MachineMenuBuild.WITHDRAW_ALL_MONEY) {
                MachineMenuBuild.getChangeMenu().currentMenu.executeYouChoose();
                continue;
            }
            System.out.print("\nyou choice :");
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            MachineMenuBuild.getChangeMenu().currentMenu.executeYouChoose(str);
        }
    }
}

