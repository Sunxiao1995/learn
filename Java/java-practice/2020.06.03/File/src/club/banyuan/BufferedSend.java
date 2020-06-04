package club.banyuan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class BufferedSend {

  public static void send(OutputStream outputStream, File file) throws IOException {

    // 发送文件时前256 代表文件名 之后的256代表文件大小 后面读文件读1位确定是否需要加密
    byte[] fileName = file.getName().getBytes();
    fileName = Arrays.copyOf(fileName, 256);
    outputStream.write(fileName);

    byte[] fileLength = String.valueOf(file.length()).getBytes();
    fileLength = Arrays.copyOf(fileLength, 256);
    outputStream.write(fileLength);

    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
    char[] theCharsRead = new char[1024];
    char[] code = new char[1];
    int charsRead;
    long sendSchedule = 0;
    double element = 1;
    double denominator = 10;

    boolean enCode = false;

    bufferedReader.read(code);
    if("1".equals(String.valueOf(code))){
      enCode = true;
//      code[0] = '0';
      outputStream.write(String.valueOf(code[0]).getBytes());
      outputStream.flush();
    }

    while ((charsRead = bufferedReader.read(theCharsRead)) != -1) {
      if(enCode){
        for (int i = 0; i < theCharsRead.length ; i++) {
          theCharsRead[i] = Encode.caesarEncode(theCharsRead[i]);
        }
      }
      outputStream.write(String.valueOf(theCharsRead, 0, charsRead).getBytes());
      sendSchedule += charsRead;
      if (sendSchedule > (element / denominator) * file.length()) {
        System.out.printf("发送进度完成%.2f" + "%%\n", (double) sendSchedule * 100 / file.length());
        element++;
      }
    }
    bufferedReader.close();
    System.out.println("发送成功");
  }
}

