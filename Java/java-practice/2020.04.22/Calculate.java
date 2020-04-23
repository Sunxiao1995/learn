 class Company{
	Staff[] a = new Staff[21];
    static int i = -1;      //用来保存公司的人数
    static int j = 0;      //用来保存删除的下标
	
	void add(Staff staff){  //增加的函数
       a[++i] = staff;
       System.out.print(i);
	}
    /**
    *
    *
    */
	void delete(String name){  //删除的函数
		for( ;j <= i;j++){
			if(this.a[j].name.equals(name)){
                System.out.print(j);
               	for(;j < i;j++){
                  a[j] = a[j+1];	
                   a[i] = null;
                }
                i--;
                System.out.print(i);
                break;
                
				
			
			}
		}
        j=0;
    }
    
	

	void salary(String name){
		for( ;j <= i;j++){ 
            if(this.a[j].name == name ){
            System.out.print(a[j].name+"的工资为"+a[j].salary_calculate(a[j]));
            j = 0;	
            }
		else if (j==i);{
		    j = 0; 
            System.out.print("查无此\n");}
	}
}

	void sum_salary(){
        int temp = 0;

        //注释掉的应该更合理一点，下面用的计算总工资感觉有bug,但是没发现
       for(int q=0;q<i;q++){
        	//a[q].teme_calculate(a[q]);
            //a[q].salary_calculate(a[q]);
        	temp += a[q].salary_calculate(a[q]);
         
         /*for (; i > 0;i-- ){
        	a[i-1].teme_calculate(a[i-1]);
            a[i-1].salary_calculate(a[i-1]);
        	temp = temp+a[i-1].salary_calculate;
        }*/
    }
        System.out.println("所有员工的工资和为："+temp);
	}


}

 class Staff{
	int time_h;   //员工的工作时长
	int salary = 3000;   //员工的基本工资
    String name;  //员工的姓名
    int temp;     //用来保存超出部分的时间
    //int salary_calculate; //用来保存总工资
    int teme_calculate(Staff staff){
    	if (staff.time_h > 196)
    		staff.temp = staff.time_h - 196;
    	else
    		staff.temp = 0;
    	return temp;
    }
	int salary_calculate(Staff staff){
		if (staff.time_h > 196)
    		staff.temp = staff.time_h - 196;
    	else
    		staff.temp = 0;

		//int temp2 = teme_calculate(staff);
    return staff.salary + staff.temp * 200;
	}
}

 class Main{
	public static void main(String[] args) {
		//static Company AddCompany(Staff staff) {
		Company jewelry = new Company();
        //jewelry.add(Staff staff);
		
		Staff a = new Staff();
		
		a.time_h = 205;
		a.name = "a";
		Staff b = new Staff();
		a.time_h = 220;
		a.name = "b";
		Staff c = new Staff();
		a.time_h = 180;
		a.name = "c";
		Staff d = new Staff();
		a.time_h = 196;
		a.name = "d";
        jewelry.add(a);
        jewelry.add(b);
        jewelry.add(c);
        jewelry.add(d);
        //jewelry.salary("a");
        jewelry.delete("d");
        
        jewelry.sum_salary();

	}
}