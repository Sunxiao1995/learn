package StringBuffer;


public class StringBuffer{
	static String string;
	static private String c;
	static private String temp = "";
    
    //将输入的字符串保存
	static void append(String str){
        string = toString(str);
	}
    
    //将输入的字符转换成字符串，在保存
	static void append(char str){
		 c = str+"";
		 string = toString(c);
	}
    
    //拼接字符串
    static String toString(String str){

        temp = temp.concat(str);
        return temp;
    }
    //清空输入的字符串
    static void clear(){
    	string = "";
    }

    //反转字符串
    static String reverse(){
    	char[] chars = string.toCharArray();
    	String reverse = "";
    	for (int i = chars.length - 1 ; i >= 0;i--){
    		reverse += chars[i];
    	}
        return reverse;
    } 

    //根据区间反转字符串
    static String reverse(int from ,int to){
    	//将区间内的子字符串保存
       String tempone = string.substring(from, to);
       String temptwo = string.substring(0,from);
       String tempthree = string.substring(to,string.length());
        //反转子字符串
       char[] chars = tempone.toCharArray();
       String reverse = "";
    	for (int i = chars.length - 1 ; i >= 0;i--){
    		reverse += chars[i];
    	}
    	reverse = temptwo.concat(reverse);
    	reverse = reverse.concat(tempthree);
    	return reverse;

       
    }

}