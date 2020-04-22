class Elephant {

  int heightInCM;
}

class Lion {
  int heightInCM;
}


class Fridge {

  int heightInCM;
  Elephant storageOne;
  Lion storageTwo;

  void store(Elephant elephant) {
    //判断冰箱是否已经装入大象或者狮子
    if(storageOne != null || storageTwo != null)
        System.out.printf("冰箱已经满了\n");
    else
    storageOne = elephant;
  }

  void store(Lion lion){
      if(storageOne != null || storageTwo != null)
        System.out.printf("冰箱已经满了\n");
      else
    storageTwo = lion;
  }

  Elephant remove(Elephant elephant){
    storageOne = null;
    return elephant;
  }

}



class ObjectDemo {
  static Elephant createElephant(int heightInCM) {
    System.out.printf("创建一个大象，高度%d厘米\n", heightInCM);
    // 使用定义的类作为数据类型
    // 使用new 创建一个对象（实例）
    Elephant elephant = new Elephant();
    // 使用. 访问对象的属性，可以对属性赋值或使用
    elephant.heightInCM = heightInCM;
    return elephant;
  }

  
  static Lion createLion(int heightInCM) {
    System.out.printf("创建一个狮子，高度%d厘米\n", heightInCM);
    // 使用定义的类作为数据类型
    // 使用new 创建一个对象（实例）
    Lion lion = new Lion();
    // 使用. 访问对象的属性，可以对属性赋值或使用
    lion.heightInCM = heightInCM;
    return lion;
  }


  static Fridge createFridge(int heightInCM) {
    System.out.printf("创建一个冰箱，高度%d厘米\n", heightInCM);
    Fridge fridge = new Fridge();
    fridge.heightInCM = heightInCM;
    return fridge;
  }

  static void putInElephant(Elephant elephant, Fridge fridge) {
    System.out.printf("把%d厘米高的大象装进%d厘米高的冰箱\n", elephant.heightInCM, fridge.heightInCM);
    if(elephant.heightInCM < fridge.heightInCM) {

      // 使用对象方法
      fridge.store(elephant);
      System.out.printf("冰箱里面的大象高度是%d厘米\n", fridge.storageOne.heightInCM);
    } else {
      System.out.printf("冰箱装不下!\n");
    }
    
  }

  static void outElephant(Elephant elephant,Fridge fridge){
    System.out.print("把冰箱里的大象拿出来\n");
    fridge.remove(elephant);
    if(fridge.storageOne == null)
      System.out.print("成功拿出");
  }

  public static void main(String[] args) {
    Elephant elephant = createElephant(300);
    Lion lion = createLion(100);
    Fridge fridge = createFridge(500);
    putInElephant(elephant, fridge);
    fridge.store(lion); 
    outElephant(elephant,fridge);
  }
}
