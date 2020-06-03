package club.banyuan;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class FileClient {

  public static void main(String[] args) {
    try (Socket socket = new Socket("192.168.2.102", 10000)) {
      System.out.println("客户端启动");

      OutputStream outputStream = socket.getOutputStream();

      System.out.println("请输入需要上传的文件夹位置");
      Scanner sc = new Scanner(System.in);
      String fileLocation = sc.nextLine();
      File file = new File(fileLocation);
      if (file.exists()) {

        BufferedSend.send(outputStream, file);

      }

      System.out.println("请输入1下载服务器文件,其他退出");
      Scanner scanner = new Scanner(System.in);
      String choose = scanner.nextLine();
      if ("1".equals(choose)) {
        outputStream.write("1".getBytes());

        byte[] filesName = new byte[2048];
        InputStream inputStream = socket.getInputStream();
        inputStream.read(filesName);
        String a = new String(filesName).trim();
        System.out.println("请选择一个文件下载");
        System.out.println(a);

        Scanner scanner2 = new Scanner(System.in);
        String copyFilename = scanner2.nextLine();

        byte[] fileName = copyFilename.getBytes();
        fileName = Arrays.copyOf(fileName, 256);
        outputStream.write(fileName);

        byte[] fileNameBytes = new byte[256];
        inputStream.read(fileNameBytes);
        String fileName2 = new String(fileNameBytes, "UTF-8").trim();

        BufferedWriter bufferedWriter = new BufferedWriter(
            new FileWriter("/Users/sunxiao/Desktop/12/" + fileName2));
        BufferedReceive.receive(inputStream, bufferedWriter);

      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
