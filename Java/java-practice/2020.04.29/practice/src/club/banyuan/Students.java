package club.banyuan;
public class Students{
   protected String name;

    public Students(String name){
        this.name = name;
    }

    public final String getName() {
        return name;
    }


    public final void setName(String name) {
        this.name = name;
    }
    public void learn(){
        System.out.println(name+"学习！");
    }
}
