package club.banyuan;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class FileServer {

  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket(10000)) {
      System.out.println("服务端启动，等待客户端连接");
      Socket socket = serverSocket.accept();

      String hostAddress = socket.getInetAddress().getHostAddress();
      System.out.println(hostAddress + " 客户端接入。。");

      InputStream inputStream = socket.getInputStream();
      byte[] fileNameBytes = new byte[256];
      inputStream.read(fileNameBytes);
      String fileName = new String(fileNameBytes, "UTF-8").trim();
      BufferedWriter bufferedWriter = new BufferedWriter(
          new FileWriter("/Users/sunxiao/Desktop/" + fileName));

      BufferedReceive.receive(inputStream, bufferedWriter);

      OutputStream outputStream = socket.getOutputStream();
      byte[] aByte = new byte[1];
      inputStream.read(aByte);
      String s = new String(aByte);
      if ("1".equals(s)) {
        File file = new File("/Users/sunxiao/Desktop/");
        String[] strings = file.list();
        StringBuilder b = new StringBuilder();
        for (String s1 : strings) {
          b.append(s1);
          b.append("  ");
        }
        byte[] bytes1 = b.toString().getBytes();
        Arrays.copyOf(bytes1, 2048);
        outputStream.write(bytes1);

        byte[] copyFile = new byte[256];
        inputStream.read(copyFile);
        String copyFilename = new String(copyFile).trim();
        File copyFile1 = new File("/Users/sunxiao/Desktop/" + copyFilename);

        BufferedSend.send(outputStream, copyFile1);

      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
