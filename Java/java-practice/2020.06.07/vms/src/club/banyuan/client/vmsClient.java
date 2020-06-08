package club.banyuan.client;

import club.banyuan.menu.MenuNode;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
import jdk.swing.interop.SwingInterOpUtils;

public class vmsClient {

  private static volatile boolean endVms = false;

  public static void setEndVms(boolean endVms) {
    vmsClient.endVms = endVms;
  }

  public static String scanUserInput() {
    Scanner scanner = new Scanner(System.in);
    String input = "";
    while (true){
    System.out.print("Your choice: ");
     input = scanner.nextLine();
     try {
       Integer.parseInt(input);
       break;
     }catch (IllegalArgumentException e){
       System.out.println("Invalid choice!");
     }
    }
    return input;
  }

  public static void main(String[] args) {

    try (Socket socket = new Socket("192.168.10.248", 10000)) {
      System.out.println("客户端启动");

      OutputStream outputStream = socket.getOutputStream();
      InputStream inputStream = socket.getInputStream();


      while (!endVms){
        byte[] isOrNotGetBytes = new byte[4];
        inputStream.read(isOrNotGetBytes);
        String isOrNot = String.valueOf(parse(isOrNotGetBytes)) ;

        String menu = getMenu(inputStream);
        System.out.println(menu);

        if("0".equals(isOrNot)){
          continue;
        }
        if("2".equals(isOrNot)){
          break;
        }
        if("3".equals(isOrNot)){
           Scanner sc = new Scanner(System.in);
           String changeName = sc.nextLine();
           writeMenu(outputStream,changeName);

//           getMenu(inputStream);
//          String price = sc.nextLine();
//          writeMenu(outputStream,price);
//          getMenu(inputStream);
          continue;
        }

        String choose = scanUserInput();

        int input = Integer.parseInt(choose);

        byte[] chooseForByte = parse(input);

        outputStream.write(chooseForByte);
        outputStream.flush();
      }


    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  private static String getMenu(InputStream inputStream) throws IOException {
    byte[] menuByteLength = new byte[4];
    inputStream.read(menuByteLength);
    int menuLength = parse(menuByteLength);

    byte[] bytes = new byte[menuLength];
    String menu;

    inputStream.read(bytes);
    menu = new String(bytes);
    return menu;
  }

  private static void writeMenu(OutputStream outputStream, String menuDisplay) throws IOException {
    byte[] menuLength;
    menuLength = parse(menuDisplay.getBytes().length);
    outputStream.write(menuLength);
    outputStream.write(menuDisplay.getBytes());
    outputStream.flush();
  }

  public static int parse(byte[] bytes) {
    int rlt = 0;
    for (byte aByte : bytes) {
      rlt <<= 8;
      rlt |= (0xFF & aByte);
    }
    return rlt;
  }

  public static byte[] parse(int target) {
    byte[] bytes = new byte[4];
    for (int i = bytes.length - 1; i >= 0; i--) {
      bytes[i] = (byte) (target & 0xFF);
      target >>= 8;
    }

    return bytes;
  }


}
