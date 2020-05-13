package club.banyuan.animal;

public enum AnimalType {

  TIGER("老虎",1),LION("狮子",2),ELEPHANT("大象",3);


  private final String typeName;
  // TODO 对code进行初始化，1 表示老虎，2表示狮子，3表示大象
  private final int code;

  private AnimalType(String typeName ,int code) {
    this.typeName = typeName;
    this.code = code;
  }

  public String getTypeName() {
    return typeName;
  }

  public int getCode() {
    return code;
  }

  // TODO
  public static AnimalType valueOf(int code){
    for (AnimalType animalType: AnimalType.values()) {
      if(animalType.code == code)
        return animalType;
    }
    return null;
  }

   //TODO
  public static AnimalType valueOf2(String typeName) {
    for (AnimalType animalType: AnimalType.values()) {
      if(animalType.typeName.equals(typeName))
        return animalType;
    }
    return null;
  }

  @Override
  public String toString() {
    return this.typeName;
  }
}
