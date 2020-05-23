package club.banyuan;

import org.junit.Assert;
import org.junit.Test;

public class TestRecommender {
    @Test
    public void test(){
        PersonalRecommender one = new PersonalRecommender();
        one.addLikes("张三","1111");
        one.addLikes("李四","1112");
        one.addLikes("王五","1113");
        one.addLikes("张三","1114");
        one.addLikes("李四","1115");
        one.addLikes("王五","1111");
        one.addLikes("张三","1112");
        one.addLikes("李四","1113");
        one.addLikes("王五","1114");
        one.addLikes("张三","1115");


        Assert.assertTrue(one.likesBoth("张三","1111","1114"));

        System.out.println(one.recommendByPerson("张三"));
        System.out.println(one.recommendByProject("1111"));
    }

}
