package club.banyuan;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;

public class BufferedReceive {

  public static void receive(InputStream inputStream, BufferedWriter bufferedWriter)
      throws IOException {
    byte[] fileLengthBytes = new byte[256];
    inputStream.read(fileLengthBytes);
    String fileLength = new String(fileLengthBytes, "UTF-8").trim();
    long fileLen = Long.parseLong(fileLength);

    byte[] bytes = new byte[1024];
    String write;
    long receiveSchedule = 0;
    double element = 1;
    double denominator = 10;
    while (true) {
      receiveSchedule += inputStream.read(bytes);
      write = new String(bytes, "UTF-8");
      bufferedWriter.write(write);

      if (receiveSchedule > (element / denominator) * fileLen) {
        System.out.printf("接收进度完成%.2f" + "%%\n", (double) receiveSchedule * 100 / fileLen);
        element++;
        if (receiveSchedule == fileLen) {
          break;
        }
      }
    }

    bufferedWriter.flush();
    bufferedWriter.close();
    System.out.println("接收成功");
  }
}

