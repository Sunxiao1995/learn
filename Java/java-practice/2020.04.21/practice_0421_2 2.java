//1、编写一个sortArr方法
/**
* 根据传入的参数来将数组升序或降序排列
*
* @param isAsc true 升序， false 降序
* @param arr
*/
class Sort{
    //根据布尔类型选择何种排序方式
static void sort(int arr[], boolean isAsc) {
	if (isAsc == true)
	    bubbleSort_Asc(arr); // :17
    if (isAsc == false)
        bubbleSort_Des(arr); // :32
}
//冒泡排序-升序
static void bubbleSort_Asc(int a[]) {
	int l = a.length;
	int temp = 0;
    for (int i = 0; i < l - 1; i++) {
        for (int j = 0; j + 1 < l - i; j++) {
            if (a[j] > a[j + 1]){    //如果后面的数比前面的大
            temp = a[j];
            a[j] = a[j+1];           //交换位置
            a[j+1] = temp;	 
            }
        }
    }
}

//冒泡排序-降序
static void bubbleSort_Des(int a[]) {
    int l = a.length;
    int temp = 0;
    for (int i = 0; i < l - 1; i++) {
        for (int j = 0; j + 1 < l - i; j++) {
            if (a[j] < a[j + 1]){    //如果后面的数比前面的大
            temp = a[j];
            a[j] = a[j+1];           //交换位置
            a[j+1] = temp;   
            }
        }
    }
}

//2.重载上述的sortArr方法，用来实现数组升序排列
/**
* 重载方法，将数组升序
*
* @param arr 目标数组
*/
static void sort(int arr[]) {
    bubbleSort_Asc(arr);
}

/*
3.编写一个main方法用来测试上述两个方法，定义一个数组，内容 
{13,26,-3,4,54,26,37,18,69,-10}，编写一个print方法，
使用字符串拼接的方式，将数组内容数组输出为如下格式，每5个换行
*/
public static void main(String[] args) {
	int[] a = {13,26,-3,4,54,26,37,18,69,-10};
	
    sort(a);
    for(int i = 0;i<a.length;i++){
        System.out.print("["+i+"]"+"="+a[i]+" ");
        if ((i+1)%5 == 0)           //每5个输出一个换行符
            System.out.println();
    }
    sort(a,false);
    for(int i = 0;i<a.length;i++){
        System.out.print("["+i+"]"+"="+a[i]+" ");
        if ((i+1)%5 == 0)           //每5个输出一个换行符
            System.out.println();
   }
}
}
