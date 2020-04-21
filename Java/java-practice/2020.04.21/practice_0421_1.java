//请思考验证当float类型变量中保存了超出了int所能表示的范围的数字，将这个变量强制转换为int数据类型后，int数据类型变量中保存的值是多少
//编写示例证明||会出现短路而|是不会短路的


class Val{
	public static void main(String[] args) {
		//float是用浮点表示法存储实数 如果其要保存int型的整数
	    //尾数为23位 加上小数点前一位 所以可以表示的精确的最大整数为2的24次方减1为1677 7215
		//int表示的最大整数为21 4748 3647 所以强转会导致精度丢失
		float a = 21474836470000l;
        float c = 214748364;
		int b = (int) a;
		int d = (int) c;
		System.out.println(b);
		//输出的值为2147483647 可以表示的最大整数是此
		System.out.println(d);
		//输出的值为214748368 可以看出精度丢失

		int f = 1;
		boolean or = true || (++f >1);
		System.out.println(or);
		System.out.println(f);
		//输出的f值为1 发生短路

		boolean or_ = true | (++f >1);
		System.out.println(f);
		//输出的f的值为2,未发生短路
	}
}
