package club.banyuan.saveMessage;

import club.banyuan.machine.VendingMachine;
import club.banyuan.machine.VendingMachineWithMenu;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.imageio.IIOException;

public class SaveMessage {
  public static void  saveMessage(VendingMachineWithMenu vendingMachineWithMenu) throws IOException {
    File file = new File("./machineMessage.txt");

    ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
    objectOutputStream.writeObject(vendingMachineWithMenu);
    objectOutputStream.flush();
    objectOutputStream.close();

  }

  public static VendingMachineWithMenu readMessage(File file) throws IOException, ClassNotFoundException {

    ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));


      Object object = objectInputStream.readObject();
      VendingMachineWithMenu vendingMachineWithMenu = (VendingMachineWithMenu) object;
      return vendingMachineWithMenu;


  }




}
