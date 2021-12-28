package ua.univer.lesson05;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProgramStream {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1,2,3,4,5,6,7,8,9);
        List<Integer> intsList = integerList.parallelStream()
                .filter(x -> x > 3)
                .map(x -> x * 2)
                .collect(Collectors.toList());
        System.out.println(intsList);
    }
}
