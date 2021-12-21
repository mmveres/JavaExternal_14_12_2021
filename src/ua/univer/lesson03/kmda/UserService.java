package ua.univer.lesson03.kmda;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    public static List<User> getMaxSalaryUsers(List<User> userList) {
        List<User> maxSalaryUsers = new ArrayList<>();
        User maxSalaryUser = userList.get(0);
        for (User user: userList) {
            if(maxSalaryUser.getSalary() < user.getSalary())
                maxSalaryUser = user;
        }
        for (var user : userList) {
            if (maxSalaryUser.getSalary() == user.getSalary())
                maxSalaryUsers.add(user);
        }
        return maxSalaryUsers;
    }
}
