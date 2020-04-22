class Fraction {
    int a,b;
    Fraction(int a,int b){//构造函数
        this.a=a;
        this.b=b;
    }
    void print() {//打印分数
        int x = a,y = b;
        if(a == b) {
            System.out.println(1);
            return;
        }
        System.out.println(a + "/" + b);
    }
    double toDouble() {//分数转化为double类型
        return a/b;
    }
    Fraction plus(Fraction r) {//分数加法
        Fraction result = new Fraction(0,0);
        result.b=this.b*r.b;
        result.a=this.a*r.b+r.a*this.b;
        return result;
    }
    Fraction multiply(Fraction r) {//分数乘法
        Fraction result=new Fraction(0,0);
        result.a=this.a*r.a;
        result.b=this.b*r.b;
        return result;
    }

}

 class Main {

    public static void main(String[] args) {
        java.util.Scanner in = new java.util.Scanner(System.in);

        Fraction a = new Fraction(in.nextInt(), in.nextInt());

        Fraction b = new Fraction(in.nextInt(),in.nextInt());

        a.print();

        b.print();

        a.plus(b).print();

        a.multiply(b).print();

        in.close();

    }

    }