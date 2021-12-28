package ua.univer.lesson05;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

//@FunctionalInterface
//interface IOperation{
//    int oper(int x, int y);
//}

public class Program {
//    public static int sum( int x, int y){
//        return x+y;
//    }
//    public static int multi( int x, int y){
//        return x*y;
//    }
    public static int sub( int x, int y){
        return x-y;
    }
    public static void main(String[] args) {
        int a =10;
        int b =20;

        BiFunction<Integer,Integer,Integer> sumOp = (Integer x, Integer y) -> x + y;
        BiFunction<Integer,Integer,Integer> multiOp = (x, y) -> x*y;
    //    BiFunction<Integer,Integer,Integer> subOp = (x, y) -> x-y;
        BiFunction<Integer,Integer,Integer> subOp = Program::sub;

        System.out.println(sumOp.apply(a, b));
        System.out.println(multiOp.apply(a, b));
        System.out.println(subOp.apply(a, b));

        System.out.println(sumOp.apply(1, 2));
        System.out.println(sumOp.apply(multiOp.apply(a, b), subOp.apply(a, b)));

        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pear");
        list.add("orange");
        list.add("strawberries");
        list.forEach(
                (n)->System.out.println(n)
        );

    }
}
