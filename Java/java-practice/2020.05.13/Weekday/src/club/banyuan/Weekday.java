package club.banyuan;

public enum Weekday {
    MONDAY("星期一",false),
    TUESDAY("星期二",false),
    WEDNESDAY("星期三",false),
    THURSDAY("星期四",false),
    FRIDAY("星期五",false),
    SATURDAY("星期六",true),
    SUNDAY("星期日",true);

    private final String  weekday;
    private final boolean isHoliday;
    Weekday(String weekday,boolean isHoliday){
        this.weekday = weekday;
        this.isHoliday = isHoliday;
    }

    public String getWeekday() {
        return weekday;
    }

    public static boolean isHoliday(String weekday) {
        for (Weekday temp:Weekday.values()) {
            if(temp.weekday.equals(weekday)){
                return temp.isHoliday;
            }
        }
        System.out.println("输入不合法");
        return false;
    }

    public static boolean isWeekday(String weekday){
        return !isHoliday(weekday);
    }


    @Override
    public String toString() {
        return this.weekday;
    }
}
