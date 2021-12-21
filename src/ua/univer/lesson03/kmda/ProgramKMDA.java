package ua.univer.lesson03.kmda;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProgramKMDA {
    public static void main(String[] args) throws IOException {

      //  List<User> userList = UserController.getUserListFromCSV(filename);
        List<User> userList = UserController.getUserListFromURL(UserPath.URL_KMDA_LIPEN);
        System.out.println(userList);
        List<User> maxSalaryUsers = UserService.getMaxSalaryUsers(userList);
        System.out.println(maxSalaryUsers);
    }




}
