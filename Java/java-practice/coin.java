class Coin{
	public static void main(String[] args) {
		int one_penny = 1;
		int two_penny = 1;
		int five_penny = 1;
		for(one_penny=1;one_penny <= 100;one_penny++){
			for(two_penny=1;two_penny <= 75;two_penny++){
				for(five_penny=1;five_penny <= 30;five_penny++){
					if((one_penny+two_penny+five_penny == 100) && (one_penny+two_penny*2+five_penny*5 == 150)){
						System.out.print(one_penny+" ");
					    System.out.print(two_penny+" ");
					    System.out.println(five_penny);}
				}
			}
		}
	}
}
