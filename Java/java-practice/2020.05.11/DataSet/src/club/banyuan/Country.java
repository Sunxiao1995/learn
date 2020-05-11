package club.banyuan;

// TODO: 实现 Measurable 接口. getMeasure() 返回国家的人口总数. 提供构造方法，让DataSetTester运行正常
public class Country implements Measurable,Measurer{
    private int countryAllPeople;
    //private static int maxMum;
    public Country(){

    }
    public Country(int i) {
      countryAllPeople = i;
     // maxMum = (maxMum > i) ? maxMum:i;
    }

    @Override
    public double getMeasure() {
        return countryAllPeople;
    }

    @Override
    public double measure(Object anObject) {
            Country anCountry = (Country)anObject;
        return anCountry.getMeasure();
    }
}
