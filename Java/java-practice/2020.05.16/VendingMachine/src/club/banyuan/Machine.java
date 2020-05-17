package club.banyuan;

import java.util.Scanner;

public class Machine {

    /**
     * 一个售货机所以用的静态属性和方法
     * 属性分别代表 服务密码 机器收到的钱 当前未返还的钱 用来显示最后一个被卖出的商品，=表示清除
     */

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

    /**
     * 使用者塞入钱
     * @param insertMoney 塞入的钱
     */
    public static void initUserRemainingMoney(int insertMoney) {
        userRemainingMoney += insertMoney;
        if(userRemainingMoney >99){
            userRemainingMoney = 99;
        }
    }

    /**
     * 使用者购买商品后 余额减少
     * @param userRemainingMoney 使用的钱
     */
    public static void setUserRemainingMoney(int userRemainingMoney) {
        Machine.userRemainingMoney -= userRemainingMoney;
        if (userRemainingMoney < 0) {
            Machine.userRemainingMoney = 0;
        }
    }

    public static int getMachineRevenue() {
        return MachineRevenue;
    }

    /**
     * 每次购买后 机器的钱增加
     * @param userBuy 购买得到的钱
     */
    public static void setMachineRevenue(int userBuy) {
        MachineRevenue += userBuy;
    }

    public static String getAProductFinallySold() {
        return aProductFinallySold;
    }

    /**
     * 设置最后一个被购买的商品
     * @param aProductFinallySold 商品名称
     */
    public static void setAProductFinallySold(String aProductFinallySold) {
        Machine.aProductFinallySold = aProductFinallySold;
    }

    public static void withDrawMoney(){
        MachineRevenue = 0;
    }

    public static void returnTheBalance() {
        userRemainingMoney = 0;
    }

    /**
     * 用户使用机器
     * if语句中的菜单由于没有子菜单 会直接显示当前菜单可以得到的信息以及执行当前菜单的操作 随后返回前一个菜单
     * 其余具有子菜单 会需要用户继续输入 执行用户需要被执行的操作 随后改变菜单的状态
     */
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
            try {
                MachineMenuBuild.getChangeMenu().currentMenu.executeYouChoose(str);
            } catch (IllegalArgumentException e){
                System.out.println("Invalid choice!");
            }
        }
    }
}

