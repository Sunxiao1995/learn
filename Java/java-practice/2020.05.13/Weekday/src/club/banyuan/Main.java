package club.banyuan;

public class Main {
    public static void isWeekdayOrHoliday(String aDay){
        System.out.println(aDay+"是否为节假日，"+Weekday.isHoliday(aDay));
    }
    public static String isCompareToSet(int compared){    //可以用两个双目运算符来做这个操作
        if(compared < 0){                                 //命名is一般用来在返回布尔类型的值 根据命名基本判断方法是用来做什么的
            return "小于sat";
        }else if(compared > 0){
           return "大与sat";
        }else {
            return "等于sat";
        }
    }

    public static void main(String[] args) {
        for (Weekday aDay: Weekday.values()) {
            isWeekdayOrHoliday(aDay.getWeekday());
        }

        Weekday sat = Weekday.SATURDAY;
        for (Weekday day :Weekday.values()) {
            System.out.println("与sat比较的值为"+day.compareTo(sat)+"，"+isCompareToSet(day.compareTo(sat)));
        }
        
    }
}
