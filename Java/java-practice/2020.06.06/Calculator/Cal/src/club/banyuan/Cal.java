package club.banyuan;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Cal {

  public static void main(String[] args) {
    System.out.println("请按 num <oper> num 的格式输入，quit 停止计算");
    Scanner scanner =new Scanner(System.in);

    while (true){
      String s = scanner.nextLine();
      if("quit".equals(s))
        break;
      try {
        System.out.println(cal(s));
      }catch (IllegalArgumentException e){
        System.out.println("输入不合法");
      }
    }

  }


  public static double cal(String string) {
    double result;
    String[] strings = string.split(" +");
    if(strings.length < 2){
      throw new IllegalArgumentException("输入不合法");
    }
    if(!(isNumber(strings[0]) && isNumber(strings[2]))){
      throw new IllegalArgumentException("输入不合法");
    }else {
      BigDecimal one = BigDecimal.valueOf(Double.parseDouble(strings[0]));
      BigDecimal two = BigDecimal.valueOf(Double.parseDouble(strings[2]));
      switch (strings[1]){
        case "+":
          result = one.add(two).doubleValue();
          break;
        case "-":
          result = one.subtract(two).doubleValue();
          break;
        case "*":
          result = one.multiply(two).doubleValue();
          break;
        case "/":
          result = one.divide(two,6,RoundingMode.HALF_UP).doubleValue();
          break;
        default:
          throw new IllegalArgumentException("输入不合法");

      }
    }


    return result;
  }

  private static boolean isNumber(String str) {
    if(str.isBlank()){
      return false;
    }
    Pattern pattern = Pattern.compile("^([-+])?\\d+(\\.\\d+)?$");
    return pattern.matcher(str).matches();
  }


}
