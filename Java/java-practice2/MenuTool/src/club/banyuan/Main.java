package club.banyuan;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Menu Root = BuildMenu.rootMenu();  //创建主菜单
        BuildMenu.buildMenu(Root);         //创建各子集菜单
        BuildMenu.useMenu(Root);           //测试菜单，有个bug是在主菜单的界面上输入0才能退出程序

    }
}