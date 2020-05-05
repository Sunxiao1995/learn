package club.banyuan;

import java.util.Scanner;

public class BuildMenu {
    public static Menu rootMenu() {         //创建根目录
        Menu Root = new Menu();
        System.out.println("请输入主菜单名：");
        Scanner scanner = new Scanner(System.in);
        Root.menuName = scanner.nextLine();
        Root.menuLevel = 1;
        return Root;
    }

    public static void buildMenu(Menu recentMenu) {    //创建目录的子节点 ，并与父目录链接，运用递归的思想，father和Menu数组相当于双向链表了

        recentMenu.setSubMenuCount();     //当前目录的子节点数
        recentMenu.allSubMenuName = new String[recentMenu.subMenuCount]; // 创建当前目录的菜单
        for (int i = 0; i < recentMenu.allSubMenuName.length; i++) {  //当前目录的菜单赋值
            System.out.println("当前为" + recentMenu.menuName + "菜单，" + "输入第" + (i + 1) + "子项菜单名");
            Scanner scanner = new Scanner(System.in);
            recentMenu.allSubMenuName[i] = scanner.nextLine();
        }
        recentMenu.subMenuArray = new Menu[recentMenu.subMenuCount];// 创建子节点的数组空间

        for (int j = 0; j < recentMenu.subMenuCount; j++) {  //判断是否有子节点,如果进入则有
            System.out.println("是否进入" + recentMenu.allSubMenuName[j] + "菜单" + "1.是 2.否");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();

            if (input.equals("2")) {

                continue;
            } else {
                recentMenu.subMenuArray[j] = new Menu();  //设置子节点属性
                recentMenu.subMenuArray[j].fatherMenu = recentMenu;
                recentMenu.subMenuArray[j].menuName = recentMenu.allSubMenuName[j];
                recentMenu.subMenuArray[j].numberInFatherMenu = j + 1;
                recentMenu.subMenuArray[j].menuLevel = recentMenu.menuLevel + 1;
                recentMenu = recentMenu.subMenuArray[j];
                buildMenu(recentMenu);     //递归
            }
            recentMenu = recentMenu.fatherMenu;  // 在子节点判断完成后要返回其父节点
        }


    }

    public static void useMenu(Menu recent) {
        System.out.println();
        System.out.println("现在开始测试");
        System.out.println("当前菜单："+recent.menuName);
        for (int i = 0; i < recent.allSubMenuName.length; i++) {
            System.out.println((i + 1) + ":" + recent.allSubMenuName[i]);
        }
        System.out.println("0：上一级");
        System.out.println();
        System.out.println("请输入你想进入的菜单,按0返回上一级");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        if (input == 0) {
            if (recent.fatherMenu == null) {
                System.out.println("已经是根目录，退出程序");
                return;
            } else {
                Menu nextMenu = recent.fatherMenu;
                useMenu(nextMenu);
            }

        } else {
            if(recent.subMenuArray[input - 1] != null){
            Menu nextMenu = recent.subMenuArray[input - 1];
            useMenu(nextMenu);}
            else{
                System.out.println("已经是最底层了");
                Menu nextMenu =recent;
                useMenu(nextMenu);
            }
        }

    }
}


