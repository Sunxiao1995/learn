package club.banyuan.menu;

public interface MachineMenu {
    /**
     * 接口 定义两个方法 print方法打印当前菜单 executeYouChoose执行相应的用户选择 有子菜单的需要调用有参方法
     * 无子菜单的调用无参数方法
     */

    default void printCurrentMenu(){
    }

    default void executeYouChoose(){
    }

    default void executeYouChoose(String choose) {

    }

    /**
     * 菜单的选项只有这几种 如果输入不是这几种 显示不合法 有写菜单没有其中的某一种 在额外判断
     * @param choose
     */
    static void isInputLegalOrNot(String choose){
        switch (choose){
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "9":break;
            default:throw new IllegalArgumentException();
        }
    }
}




















