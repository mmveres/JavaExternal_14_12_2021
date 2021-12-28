package ua.univer.lesson05;

import ua.univer.lesson03.kmda.User;

import java.util.*;
import java.util.stream.Collectors;

public class ProgramSort {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
             //   null,
                new User("A1", "manager14", 130),
                new User("A1", "manager10", 110),
                new User("A2", "manager12", 140),
                new User("A4", "manager13", 100)
        );

        List<User> usersSort = users.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(User::getPosition))
                .collect(Collectors.toList());

        System.out.println(usersSort);

        List<String> usersName = users.stream()
                .filter(Objects::nonNull)
                .map(User::getName)
                .collect(Collectors.toList());

        System.out.println(usersName);

        Collections.sort(users, Comparator.comparing(User::getName).thenComparing(User::getPosition).reversed());
        System.out.println(users);

        Collections.sort(users, Comparator.comparingDouble(User::getSalary));
        System.out.println(users);
        System.out.println("*************************************");



        users.stream()
                .filter(Objects::nonNull)
                .filter(user -> user.getSalary()>120)
                .filter(user -> !user.getName().equals("A1"))
                .forEach(System.out::print);

        List<User> usersBigSalary = users.stream()
                .filter(user -> user.getSalary()>120)
                .collect(Collectors.toList());

        System.out.println(usersBigSalary);
    }
}
