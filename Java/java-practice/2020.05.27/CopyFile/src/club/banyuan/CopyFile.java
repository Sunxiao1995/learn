package club.banyuan;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {

  public static void main(String[] args) {

    String sourceFilePath = "/Users/sunxiao/Desktop/1.md";
    String targetFilePath = "/Users/sunxiao/Desktop/123.md";
    int BYTE_ARRAY_LENGTH = 100;

    File sourceFile = new File(sourceFilePath);
    File targetFile = new File(targetFilePath);
    long sourceFileLength = sourceFile.length();

    int copySchedule = 0;

    try {
      try(FileInputStream fileInputStream = new FileInputStream(sourceFile);
          FileOutputStream fileOutputStream = new FileOutputStream(targetFile)) {

            byte[] temp = new byte[BYTE_ARRAY_LENGTH];
            int count;
            double element = 1;
            double denominator =10;
        System.out.println("开始复制");
        while ((count = fileInputStream.read(temp)) != -1){
             fileOutputStream.write(temp,0,count);
             copySchedule += count;

             if(copySchedule > (element/denominator)*sourceFileLength ){
               System.out.printf("进度完成%.2f"+"%%\n",(double)copySchedule*100/sourceFileLength);
               element++;
             }
           }
        System.out.println("拷贝完成");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    
  }






}
