package club.banyuan;

import org.junit.Test;

public class TestPair {
   @Test
    public void test(){
     Pair<String> a = new Pair<>("a","b") ;
     Pair<Integer> b = new Pair<>(1,2);
       System.out.println("first: "+a.getFirst()+"  ,second: "+a.getSecond());
       System.out.println("first: "+b.getFirst()+"  ,second: "+b.getSecond());
       a.swap();
       b.swap();
       System.out.println("first: "+a.getFirst()+"  ,second: "+a.getSecond());
       System.out.println("first: "+b.getFirst()+"  ,second: "+b.getSecond());
       Pair<String> temp = PairUtil.swap(a);
       System.out.println("first: "+temp.getFirst()+"  ,second: "+temp.getSecond());
       Integer[] array =  {1,2,3,4,5,6};
       Pair<Integer> temp2 = PairUtil.minmax(array);
       System.out.println("first: "+temp2.getFirst()+"  ,second: "+temp2.getSecond());
       Measurable[] measurable = {new MeasurableTest(1.0) ,new MeasurableTest(2.0),new MeasurableTest(3.0)};
       Pair<Measurable> temp3 = PairUtil.minmax(measurable);
       System.out.println("first: "+temp3.getFirst().getMeasure()+"  ,second: "+temp3.getSecond().getMeasure());






    }
}
