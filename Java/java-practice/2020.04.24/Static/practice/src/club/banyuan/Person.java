package club.banyuan;

public class Person {

  private String name;
  private int age;
  static int count1 = 0;   //参数命名需要直观。personObjwithNAmeAndAgeCount
  static int count2 = 0; 
  static int count3 = 0;
  
  
  public Person(String name, int age) {
    this.name = name;
    this.age = age;
    count1++;

  }
  
  public Person(String name) {
    this.name = name;
    count2++;
  }

  public Person() {
    count3++;
  }

  static int getCount(){
    return count1+count2+count3;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

}
