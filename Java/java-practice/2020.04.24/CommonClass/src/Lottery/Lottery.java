package Lottery;
import java.util.Random;

public class Lottery{
	private static String[] str = {"大吉","中吉","小吉","吉","末吉","凶","大凶"};
	
	

	private static int slipsPosition = 0;
    
	
	public static String chooseSlips(){
	    Random random = new Random();
	    int i = random.nextInt(100);
         //System.out.println(i);
	    //System.out.println(i);
		if(i >= 0 && i <5 )
			//return str[0];
			{slipsPosition = 0;}
		if(i >= 5 && i < 15)
			//return str[1];
			{slipsPosition = 1;}
		if(i >=15 && i < 30)
			//return str[2];
			{slipsPosition =2;}
		if(i >= 30 && i < 60)
			//return str[3];
			{slipsPosition = 3;}
		if(i >= 60 && i < 80)
			//return str[4];
			{slipsPosition = 4;}
		if(i >= 80 && i < 95)
		    {slipsPosition = 5;}
	        //return str[5];
		if(i >= 95 && i < 100)
			{slipsPosition = 6;}
		//System.out.println(slipsPosition);
		//System.out.println(str[slipsPosition]);
		    

	
       return str[slipsPosition];
}

}