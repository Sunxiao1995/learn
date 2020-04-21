class Practice{
//编写一个方法不使用 * 完成两个数相乘

	static int multiply(int n1, int n2){
		int mul = 0;
		for(int i = 0; i < n1; i++){      //n1*n2可以看成是n1个n2相加；
			for(int j = 0; j < n2; j++){  //n2*1可以看成是n2个1相加；
                mul++;

			}
		}
		return mul;
	}

//编写一个方法输入分钟时间，向控制台输出多少年，多少天
	static void convert(long minute){
		long year = minute/(365*24*60);
        long temp = minute%(365*24*60);
		int day = (int)temp/(24*60);
		System.out.println(minute+" 分钟是"+year+"年"+day+"天");
	}

	public static void main(String[] args) {
		int mul = multiply(3,4);
		System.out.println(mul);
        System.out.println();
       
        java.util.Scanner sc = new java.util.Scanner(System.in);
		long minute = sc.nextLong();
		convert(minute);
	}
}