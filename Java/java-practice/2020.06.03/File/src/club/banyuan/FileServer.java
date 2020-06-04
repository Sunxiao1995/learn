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

      // 发送的文件 前256byte 代表文件名
      byte[] fileNameBytes = new byte[256];
      inputStream.read(fileNameBytes);
      String fileName = new String(fileNameBytes, "UTF-8").trim();
      BufferedWriter bufferedWriter = new BufferedWriter(
          new FileWriter("/Users/sunxiao/Desktop/" + fileName));

      //调用方法接收文件
      BufferedReceive.receive(inputStream, bufferedWriter);

      OutputStream outputStream = socket.getOutputStream();

      //如果客户端传来请求下载文件 即为1 执行后面代码 如果没有 则退出
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


        //读客户端需要下载的文件名
        byte[] copyFileName = new byte[256];
        inputStream.read(copyFileName);
        String copyFilename = new String(copyFileName).trim();
        File copyFile = new File("/Users/sunxiao/Desktop/" + copyFilename);

        //根据文件名向客户端发送文件
        BufferedSend.send(outputStream, copyFile);

      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
