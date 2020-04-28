package reverse;

public class Reverse{
    

    //反转一个字符数组的指定范围
    public static void reverseChars(char[] chars , int begin , int end){
        while(begin < end){
            char temp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = temp;
            begin++;
            end--;
        }
    }

    
    //找到begin 和 end 的值并使用反转数组的函数进行反转
	public static char[] reverseWords(String str){
         char[] chars = str.toCharArray();
         int begin = -1;
         int end = 0;


         for (int i = 0;i < chars.length;i++){   
         	char c = chars[i];
         	if (c != ' '){   // 选择在每个空格之间的单词
         	    if(begin == -1){
                     begin = i;
                     end = i;
                } else {
                	end = i;
                	if(i == chars.length-1){
                  reverseChars(chars,begin,end);
                }
                	}

         	}else{
         		if(begin != -1){   //判断一个单词结束，进行反转操作 
         		 reverseChars(chars,begin,end);
         		}
         		begin = -1;
         	} 

         }
         return chars;

	}
}