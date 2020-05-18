package club.banyuan;

import java.util.Iterator;


public class PrintIterable {

    public static <T> void PrintIterable(Iterable<T> aIterable ){
        for (T t : aIterable) {
            System.out.print(t + ", ");
        }
    }
}