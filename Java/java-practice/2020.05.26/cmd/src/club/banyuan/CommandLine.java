import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommandLine {

  public static void main(String[] args) throws IOException {
    switch (args.length){
      //不输入参数 抛出参数不正确异常
      case 0:
        throw new IllegalArgumentException("参数不正确");

      //一个参数时 如果不是ls 抛参数不正确异常
      case 1:
        File file = new File("./");
        if(!args[0].equals("ls")){
          throw new IllegalArgumentException("参数不正确");
        }else {
          if(file.listFiles() == null){
            System.out.println("没有文件");}
          for (File current :file.listFiles()) {
            System.out.println(current.getName());
          }
        }
        break;

      // 两个参数时 先判断第一个参数是否正确 在判断第二个路径是否正确
        // 如果是文件夹 则可以执行 ls rm 如果是文件 则可以执行 rm cat
      case 2:
        if(args[0].equals("ls") || args[0].equals("rm") || args[0].equals("cat")){
          File fileTwo = new File(args[1]);

          if(!fileTwo.exists()){
            throw new IllegalArgumentException("路径不正确");
          }else {
            executeTwoArgumentCommand(args[0],args[1]);
          }

        }else {
          throw new IllegalArgumentException("参数不正确");
        }
        break;
      case 3:
        if(args[0].equals("ls") || args[0].equals("cp")){
          File originalPath = new File(args[1]);
          File targetPath = new File(args[2]);
          if(args[0].equals("ls") && args[2].equals("-l") && originalPath.exists() && originalPath.isDirectory() ){
            for (File files: originalPath.listFiles()) {
              printFile(files);
            }
          }else if(args[0].equals("cp") && originalPath.isFile() && targetPath.isDirectory()){
              File targetPathFile =  new File(targetPath,originalPath.getName());
              if(!targetPathFile.exists()){
                targetPath.createNewFile();
                executeThreeArgumentCommand(originalPath,targetPathFile);
              }else {
                System.out.println("存在重名文件");
              }
          }

        }else {
          throw new IllegalArgumentException("参数不正确");
        }
        break;

      default:
        throw new IllegalArgumentException("参数不正确");

    }
  }



  public static void executeTwoArgumentCommand (String command ,String path)  {
    File file = new File(path);
    if(file.isDirectory()){
      switch (command){
        case "ls" :
          if(file.listFiles() == null){
            System.out.println("没有文件");}
          for (File current :file.listFiles()) {
            System.out.println(current.getName());
          }
          break;
        case "rm":
           deleteFile(file);
           break;
        default:
          throw new IllegalArgumentException("参数不正确");
      }
    }else {
      switch (command){
        case "rm":
          deleteFile(file);
          break;
        case "cat":
          try(InputStream inputStream = new FileInputStream(file)) {
            System.out.println(inputStream.readAllBytes().toString());
          }catch (IOException e){
            e.printStackTrace();
          }
      }
    }
  }

  public static void executeThreeArgumentCommand (File original  ,File target){
    try(InputStream inputStream = new FileInputStream(original);
        OutputStream outputStream = new FileOutputStream(target)){

      outputStream.write(inputStream.readAllBytes());

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public static void printFile(File file){
    String fileIsDictionary = "d";
    long dictionaryLength = 0;
    if(!file.isDirectory()){
      fileIsDictionary = "-";
      dictionaryLength = file.length();
    }
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    System.out.printf(fileIsDictionary+"    %4d"+"        "
                        + dateFormat.format(new Date(file.lastModified()))
                       +"        "+file.getName()+"\n",dictionaryLength);
  }

  /**
   * 删除传入路径下的文件或文件夹
   */
  public static void deleteFile(File file){
    if(file.isDirectory()){
      if(file.listFiles() == null){
        file.delete();
      }
      for (File deleted: file.listFiles()) {
        deleteFile(deleted);
      }
    }else{
      file.delete();
    }
  }

  

}
