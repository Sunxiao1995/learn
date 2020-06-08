package udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {


  public static void main(String[] arDatagramSocket ds = new Datags) throws IOException {
    gramSocket();
    System.out.println("键入发送数据 输入1111结束：");
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String line = null;
    while ((line = bufferedReader.readLine()) != null){
      System.out.println("键入发送数据 输入1111结束：");
      byte[] buf = line.getBytes();
      DatagramPacket dp = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.10.248"),
          10000);
      ds.send(dp);
      if("1111".equals(line)){
        System.out.println("发送数据停止");
        break;
      }

    }
    bufferedReader.close();
    ds.close();
  }
}
