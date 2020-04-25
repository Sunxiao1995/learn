package randomTest;

import java.util.Random;

public class randomTest{
static private int i;

public static int randomInt(int from,int to){
	
    //根据输入的值判断区间
	if(from > to){
		int temp = from;
		from = to;
		to = temp;
	}
    // 生成范围内的随机数
	Random random = new Random();
	i = random.nextInt(to - from + 1) + from;
	return i;
}


}




