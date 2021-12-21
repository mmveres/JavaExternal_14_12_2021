package ua.univer.lesson03.kmda;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProgramKMDA {
    public static void main(String[] args) throws IOException {
        String filename ="resources"+ File.separator+"lipen-2019.csv";
        List<User> userList = UserController.getUserListFromCSV(filename);
        System.out.println(userList);
        List<User> maxSalaryUsers = UserService.getMaxSalaryUsers(userList);
        System.out.println(maxSalaryUsers);
    }




}
