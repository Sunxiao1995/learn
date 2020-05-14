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

    public String getWeekday()   {
        return weekday;
    }

    public boolean isHoliday() {
                return isHoliday;

    }

    public boolean isWeekday(){
        return isHoliday;
    }


    @Override
    public String toString() {

        return this.weekday;
    }


}
