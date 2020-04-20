class Practice{
	public static void main(String[] args) {
		int save_MS_Sevenday;
		save_MS_Sevenday = 604800000;
		long save_MS_Thirtyday;
		save_MS_Thirtyday = 2592000000L;
		// 不加f编译的时候会显示错误: 不兼容的类型: 从double转换到float可能会有损失
		float dec = 0.15F;
        System.out.println(save_MS_Sevenday);
        System.out.println(save_MS_Thirtyday);
		System.out.println(dec);
        
        //声明一个长度为10的数组
		//int[] a = new int [10];
        //假设对数组的长度进行赋值，编译时报错，无法为最终变量length分配值
		//a.length = 11;

		//假设声明一个数组，大小为刚刚的long,编译会报错，从long转换到int可能会有损失
		//int [] b = new int [save_MS_Thirtyday];

        String[][] twoDimensionalArr = new String[3][];


        twoDimensionalArr[0] = new String[]{"你","我","他"};
        twoDimensionalArr[1] = new String[]{"金","木","水","火","土"};
        twoDimensionalArr[2] = new String[]{"天","地"};
        for(int i=0;i<twoDimensionalArr.length;i++) {//s.length表示行数
			System.out.print("{");
			for(int j=0;j<twoDimensionalArr[i].length;j++) {//s[i].length表示列数
				System.out.print(" "+twoDimensionalArr[i][j]+" ");
			}
			System.out.print("}");
			System.out.println();
		}
	}
 	
}