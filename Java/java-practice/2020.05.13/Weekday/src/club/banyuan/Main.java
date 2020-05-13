package club.banyuan;

public class Main {
    public static void isWeekdayOrHoliday(String aDay){
        System.out.println(aDay+"是否为节假日，"+Weekday.isHoliday(aDay));
    }
    public static String isCompareToSet(int compared){
        if(compared < 0){
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
