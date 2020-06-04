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

    boolean deCode = false;
    byte[] code = new byte[1];
    inputStream.read(code);
    bufferedWriter.write(new String(code));

    if("0".equals(new String(code))){
      deCode = true;
    }


    byte[] bytes = new byte[1024];
    String write;
    long receiveSchedule = 0;
    double element = 1;
    double denominator = 10;
    while (true) {

      if (receiveSchedule > fileLen - 1024) {
        bytes = new byte[(int)(fileLen - receiveSchedule)];
        receiveSchedule  = receiveSchedule + 2;
      }

      receiveSchedule += inputStream.read(bytes);
      write = new String(bytes, "UTF-8").trim();

      if(deCode){
        char[] temp = write.toCharArray();
        for (int i = 0; i < temp.length ; i++) {
          temp[i] = Decode.caesarDecode(temp[i]);
        }
        write = String.valueOf(temp);
      }
      bufferedWriter.write(write);
      bufferedWriter.flush();

      if (receiveSchedule > (element / denominator) * fileLen) {
        System.out.printf("接收进度完成%.2f" + "%%\n", (double) receiveSchedule * 100 / fileLen);
        element++;
      }
      if(receiveSchedule >= fileLen) {
        break;
      }
      }

    bufferedWriter.close();
    System.out.println("接收成功");
  }
}

