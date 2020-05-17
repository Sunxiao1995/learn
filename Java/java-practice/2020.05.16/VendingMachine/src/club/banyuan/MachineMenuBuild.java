package club.banyuan;

import club.banyuan.menu.*;

public enum MachineMenuBuild {

    /**
     * 声明每一个菜单类 在构造时 初始化id 每个枚举菜单类里有对应的实现了统一接口的菜单类
     * 实现了接口的菜单类都用接口类型保存在枚举类中 在执行的时候执行接口的方法 会调用实际上的实现类的方法
     * 接口中定义了print 和 chooseMenu方法 菜单实现类分别实现这些方法
     * print打印当前菜单 chooseMenu根据用户的选择 作出相对应的动作 并且轮转当前的所在菜单
     * 静态属性 MachineMenuBuild changeMenu 代表当前所属的菜单 只要此属性不等于QUIT 程序会一直执行
     *
     */
    GRAPHICAL_MENU("00",new Graphical()),
    ROOT_MENU("0000",new RootMenu()),
    READ_PRODUCT_INFORMATION("1",new ReadProductInformation()),
    INSERT_COIN("2",new InsertCoin()),
    PRESS_PRODUCT_BUTTON("3",new PressProductButton()),
    PRESS_RETURN_BUTTON("4",new PressReturnButton()),
    SERVICE_MENU("9",new ServiceMenu()),
    OPEN_SERVICE_MENU("9-9",new OpenServiceMenu()),
    QUIT("0",new Quit()),
    INSPECT_MACHINE_STATUS("9-1",new InspectMachineStatus()),
    WITHDRAW_ALL_MONEY("9-2",new WithdrawAllMoney()),
    REFILL_PRODUCT("9-3",new RefillProduct()),
    CHANGE_PRODUCT("9-4",new ChangeProduct()),
    GO_BACK("9-0",new GoBack());

    private final String ID;
    public final MachineMenu currentMenu;
    private static MachineMenuBuild changeMenu = GRAPHICAL_MENU;

    MachineMenuBuild(String id, MachineMenu currentMenu) {
        ID = id;
        this.currentMenu = currentMenu;
    }

    public String getID() {
        return ID;
    }

    public MachineMenu getCurrentMenu() {
        return currentMenu;
    }

    public static MachineMenuBuild getChangeMenu() {
        return changeMenu;
    }

    /**
     * 根据传入的下一个即将进入的菜单 改变changeMenu
     * @param changeMenu 传入的下一个即将进入的菜单
     */
    public static void setChangeMenu(MachineMenuBuild changeMenu) {
        MachineMenuBuild.changeMenu = changeMenu;
    }


    }



