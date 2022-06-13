package view;

import service.user.UserService;

import java.util.Scanner;

public class ListUserView {
    Scanner scanner = new Scanner(System.in);
    public ListUserView(){
        System.out.println(UserService.userList);
        System.out.println("Nhập QUIT để trở về menu");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")){
            new Main();
        }
    }
}
