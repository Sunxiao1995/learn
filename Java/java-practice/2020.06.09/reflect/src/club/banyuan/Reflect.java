package club.banyuan;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

public class Reflect {


  public static void printInfo(Object object){
    Class  aClass =  object.getClass();
    Method[] methods = aClass.getMethods();
    bubbleSort(methods, methods.length);

    Field[] field = aClass.getFields();
    bubbleSort(field,field.length);

    for (Method m:methods) {
      System.out.println(m);
    }
    for (Field m:field) {
      System.out.println(m);
    }

  }

  private static <T extends Member> T[] bubbleSort(T[] methods, int n) {
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j + 1 < n - i; j++) {
        char [] temp1 = methods[j].getName().toCharArray();
        char [] temp2 = methods[j+1].getName().toCharArray();
        if (String.valueOf(temp1[0]).compareTo(String.valueOf(temp2[0])) > 0) {
          T temp;
          temp = methods[j];
          methods[j] = methods[j+1];
          methods[j+1] = temp;
        }
      }
    }
    return methods;
  }





  public static void main(String[] args) {
    printInfo(0);
  }


}
