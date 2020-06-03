package club.banyuan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class BufferedSend {

  public static void send(OutputStream outputStream, File file) throws IOException {
    byte[] fileName = file.getName().getBytes();
    fileName = Arrays.copyOf(fileName, 256);
    outputStream.write(fileName);

    byte[] fileLength = String.valueOf(file.length()).getBytes();
    fileLength = Arrays.copyOf(fileLength, 256);
    outputStream.write(fileLength);

    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
    char[] theCharsRead = new char[1024];
    int charsRead;
    long sendSchedule = 0;
    double element = 1;
    double denominator = 10;

    while ((charsRead = bufferedReader.read(theCharsRead)) != -1) {
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

