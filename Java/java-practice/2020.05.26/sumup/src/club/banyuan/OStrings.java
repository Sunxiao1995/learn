package club.banyuan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class OStrings {
  public static String [] loadArray(InputStream is,int[] n) throws IOException {
    String[] strings = new String[n.length];
    for (int i = 0; i < n.length ; i++) {
      byte[] b = new byte[n[i]];
       if(is.read(b) != -1) {
         strings[i] = new String(b);
       }else {
         if(i != n.length-1){
           throw new RuntimeException("读取失败");
         }
       }
    }
    return strings;
  }

 public static void saveArray(OutputStream os,String [] sa){
    try(os) {
      for (String temp: sa) {
        os.write(temp.getBytes());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
 }

 public static void mulTable(String path,int n) {
   File file = new File(path);
   if(file.exists() && file.isFile()){
     try(OutputStream outputStream = new FileOutputStream(file)) {

       for (int i = 0;i < n;i++){
         for(int j = 0;j < n;j++){
           String string = Integer.toString((i+1)*(j+1))+"  ";
           outputStream.write(string.getBytes());
           if(j == n-1){
             outputStream.write("\n".getBytes());
           }
         }
       }
     } catch (IOException e) {
       e.printStackTrace();
     }
   }else {
     throw new IllegalArgumentException("path不正确");
   }
 }

  public static void main(String[] args) {
    mulTable("./1.txt",3);
  }
}



