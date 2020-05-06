package club.banyuan;

public class Test {
    public static Cake[] BuildCake()
    {
        Cake[] cakes = new Cake[10];
        cakes[0] = new OrderCake(1, 10, 2);
        cakes[1] = new OrderCake(2, 12, 1);
        cakes[2] = new OrderCake(3, 20, 3);
        cakes[3] = new OrderCake(4, 6, 4);
        cakes[4] = new OrderCake(5, 14, 7);
        cakes[5] = new ReadyMadeCake(6, 12, 6);
        cakes[6] = new ReadyMadeCake(7, 13, 13);
        cakes[7] = new ReadyMadeCake(8, 13, 21);
        cakes[8] = new ReadyMadeCake(9, 16, 12);
        cakes[9] = new ReadyMadeCake(10, 17, 15);
        return cakes;
    }
    public static void AllCakesPrice(Cake[] cakes){
        double AllCakesPrice = 0;
        for (int i = 0; i <cakes.length ; i++) {
            AllCakesPrice += cakes[i].calcPrice();
        }
        System.out.println("所有蛋糕的总价为"+AllCakesPrice);
    }

    public static void showReadyMadeCakePriceAndQuantity(Cake[] cakes){
        double AllReadyMadeCakePrice = 0;
        int AllReadyMadeCakeQuantity = 0;
        for (int i = 0; i <cakes.length ; i++) {
            if(cakes[i] instanceof OrderCake)
                continue;
            AllReadyMadeCakePrice += cakes[i].calcPrice();
            AllReadyMadeCakeQuantity += ((ReadyMadeCake)cakes[i]).getQuantity();
        }
        System.out.println("ReadyMadeCake蛋糕的总价是"+AllReadyMadeCakePrice+",总数是"+AllReadyMadeCakeQuantity);
    }

    public static void showExpensiveCakeInformation(Cake[] cakes){
        int temp = 0;
        for (int i = 0; i < cakes.length ; i++) {
            if(cakes[temp].calcPrice() <= cakes[i].calcPrice())
            {temp = i;}
        }
        if(cakes[temp] instanceof OrderCake){
            System.out.println("id:"+((OrderCake)cakes[temp]).id);

            System.out.println("price:"+((OrderCake)cakes[temp]).price);

            System.out.println("weightInKG:"+((OrderCake)cakes[temp]).getWeightInKG());
        }else{
            System.out.println("id:"+((ReadyMadeCake)cakes[temp]).id);

            System.out.println("price:"+((ReadyMadeCake)cakes[temp]).price);

            System.out.println("quantity:"+((ReadyMadeCake)cakes[temp]).getQuantity());
        }
    }

    public static void main(String[] args) {
        Cake[]cakes = BuildCake();
        AllCakesPrice(cakes);
        showReadyMadeCakePriceAndQuantity(cakes);
        showExpensiveCakeInformation(cakes);
    }

}
