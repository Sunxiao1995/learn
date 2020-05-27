package club.banyuan.main;

import club.banyuan.machine.VendingMachine;
import club.banyuan.machine.VendingMachineWithMenu;
import club.banyuan.saveMessage.SaveMessage;
import java.io.File;
import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    // VendingMachine vendingMachine = new VendingMachine();
    // vendingMachine.start();
    VendingMachineWithMenu vendingMachineWithMenu = new VendingMachineWithMenu();
    File file = new File("./machineMessage.txt");
    if(file.exists()){
      vendingMachineWithMenu = SaveMessage.readMessage(file);
    }
    vendingMachineWithMenu.start();
    try {
      SaveMessage.saveMessage(vendingMachineWithMenu);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
