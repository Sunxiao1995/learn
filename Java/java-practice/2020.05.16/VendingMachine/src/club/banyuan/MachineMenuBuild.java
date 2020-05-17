package club.banyuan;

import club.banyuan.menu.*;

public enum MachineMenuBuild {
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

    public static void setChangeMenu(MachineMenuBuild changeMenu) {
        MachineMenuBuild.changeMenu = changeMenu;
    }


    }



