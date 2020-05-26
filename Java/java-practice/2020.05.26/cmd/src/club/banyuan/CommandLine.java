import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;

public class CommandLine {


  public static void main(String[] args) throws IOException {
    switch (args.length) {
      //不输入参数 抛出参数不正确异常
      case 0:
        throw new IllegalArgumentException("参数不正确");

        //一个参数时 如果不是ls 抛参数不正确异常
      case 1:
        File file = new File("./");
        if (!args[0].equals("ls")) {
          throw new IllegalArgumentException("参数不正确");
        } else {
          //当前路径下可能没有文件
          if (file.listFiles() == null) {
            System.out.println("没有文件");
          }
          for (File current : file.listFiles()) {
            System.out.println(current.getName());
          }
        }
        break;

      // 两个参数时 先判断第一个参数是否正确 在判断第二个路径是否正确
      // 如果是文件夹 则可以执行 ls rm 如果是文件 则可以执行 rm cat 调用executeTwoArgumentCommand方法
      case 2:
        if (args[0].equals("ls") || args[0].equals("rm") || args[0].equals("cat")) {
          File fileTwo = new File(args[1]);

          if (!fileTwo.exists()) {
            throw new IllegalArgumentException("路径不正确");
          } else {
            executeTwoArgumentCommand(args[0], args[1]);
          }

        } else {
          //如果不是"ls" "rm" "cat" 当中的一个参数不正确
          throw new IllegalArgumentException("参数不正确");
        }
        break;

      //三个参数执行的是cp 和 ls -l 命令 如果不是这些命令 则抛异常
      //第一个命令正确 需要保证第二个第三个命令符合要求才能正确执行 ls命令 第二个路径存在且为文件夹 第三个为-l 打印调用printFile方法
      // cp 命令第二个参数为文件路径 第三个参数为文件夹路径 copy调用executeThreeArgumentCommand方法
      case 3:
        if (args[0].equals("ls") || args[0].equals("cp")) {
          File originalPath = new File(args[1]);
          File targetPath = new File(args[2]);
          if (args[0].equals("ls") && args[2].equals("-l") && originalPath.exists() && originalPath
              .isDirectory()) {
            for (File files : originalPath.listFiles()) {
              printFile(files);
            }
          } else if (args[0].equals("cp") && originalPath.isFile() && targetPath.isDirectory()) {
            File targetPathFile = new File(targetPath, originalPath.getName());
            if (!targetPathFile.exists()) {
              targetPath.createNewFile();
              executeThreeArgumentCommand(originalPath, targetPathFile);
            } else {
              System.out.println("存在重名文件");
            }
          }

        } else {
          throw new IllegalArgumentException("参数不正确");
        }
        break;

      default:
        throw new IllegalArgumentException("参数不正确");

    }
  }


  /**
   * 如果是文件夹 则可以执行 ls rm 如果是文件 则可以执行 rm cat 删除一个文件或文件夹调用 deleteFile（File file）方法
   *
   * @param command 输入的第一个命令行
   * @param path    输入的路径 前面已经判断 这里一定存在此路径
   */
  public static void executeTwoArgumentCommand(String command, String path) {
    File file = new File(path);
    if (file.isDirectory()) {
      switch (command) {
        case "ls":
          if (file.listFiles() == null) {
            System.out.println("没有文件");
          }
          for (File current : file.listFiles()) {
            System.out.println(current.getName());
          }
          break;
        case "rm":
          deleteFile(file);
          break;
        default:
          throw new IllegalArgumentException("参数不正确");
      }
    } else {
      switch (command) {
        case "rm":
          deleteFile(file);
          break;
        case "cat":
          try (InputStream inputStream = new FileInputStream(file)) {
            System.out.println(inputStream.readAllBytes().toString());
          } catch (IOException e) {
            e.printStackTrace();
          }
      }
    }
  }

  /**
   * 由于前面已经判断 这里一定满足条件
   * @param original 原文件
   * @param target  目标文件夹
   */
  public static void executeThreeArgumentCommand(File original, File target) {
    try (InputStream inputStream = new FileInputStream(original);
        OutputStream outputStream = new FileOutputStream(target)) {

      outputStream.write(inputStream.readAllBytes());

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public static void printFile(File file) {
    String fileIsDictionary = "d";
    long dictionaryLength = 0;
    if (!file.isDirectory()) {
      fileIsDictionary = "-";
      dictionaryLength = file.length();
    }
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    System.out.printf(fileIsDictionary + "    %4d" + "        "
        + dateFormat.format(new Date(file.lastModified()))
        + "        " + file.getName() + "\n", dictionaryLength);
  }

  /**
   * 删除传入路径下的文件或文件夹 递归 如果是文件或空文件夹 可直接删除 如果非空文件夹 则进入子文件夹调用该方法
   * @param file 传入的文件
   */
  public static void deleteFile(File file) {
    if (file.isDirectory()) {
      if (file.listFiles() == null) {
        file.delete();
      }
      for (File deleted : file.listFiles()) {
        deleteFile(deleted);
      }
    } else {
      file.delete();
    }
  }

  @Test
  public void test() throws IOException {
    System.out.println("------ls--------");
    String[] args1 = {"ls"};
    main(args1);
    System.out.println("------ls ../ -l--------");
    String[] args2 = {"ls", "../", "-l"};
    main(args2);
    System.out.println("------ls ../ --------");
    String[] args3 = {"ls", "../"};
    main(args3);

  }


}
