package club.banyuan;

import java.util.Scanner;

public class Menu {
    private boolean isEdit;
     String menuName;//目录名
     int menuLevel;//目录所在层级
     int subMenuCount;//子目录数
     String[] allSubMenuName;//当前菜单
     Menu[] subMenuArray;//子目录组成的数组
     Menu fatherMenu;//当前目录的父目录
     int numberInFatherMenu;//当前目录在父层目录中的编号

    public String getMenuName() {
        return menuName;
    }

    public void setName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(int menuLevel) {
        this.menuLevel = menuLevel;
    }

    public int getSubMenuCount() {
        return subMenuCount;
    }

    public void setSubMenuCount() {
        System.out.println("请输入当前目录的子目录数：");
        Scanner sc = new Scanner(System.in);
        int inputSubMenuCount = sc.nextInt();
        sc.nextLine();
        this.subMenuCount = inputSubMenuCount;
    }

    public Menu[] getSubMenuArray() {
        return subMenuArray;
    }

    public void setSubMenuArray(Menu[] subMenuArray) {
        this.subMenuArray = subMenuArray;
    }

    public Menu getFatherMenu() {
        return fatherMenu;
    }

    public void setFatherMenu(Menu fatherMenu) {
        this.fatherMenu = fatherMenu;
    }

    public int getNumberInFatherMenu() {
        return numberInFatherMenu;
    }

    public void setIdInFatherMenu(int numberInFatherMenu) {
        this.numberInFatherMenu = numberInFatherMenu;
    }

}