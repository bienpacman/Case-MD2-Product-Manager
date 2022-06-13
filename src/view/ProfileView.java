package view;

import model.Manager;
import model.User;
import service.manager.ManagerService;
import service.user.UserService;

import java.util.List;
import java.util.Scanner;

public class ProfileView {
    Scanner scanner = new Scanner(System.in);
    List<Manager> managerList = ManagerService.managerList;
    List<User> userList = UserService.userList;

    ManagerService managerService = new ManagerService();

    public ProfileView() {
        if (managerList.size() != 0) {
            System.out.println("Xin chào ✌️  " + managerList.get(0).getName() + " đẹp zai ❤️ !!!");
            System.out.println();
        } else if (userList.size() != 0){
            System.out.println("Xin chào ✌️  " + userList.get(0).getName() + " đẹp zai ❤️ !!!");
            System.out.println();
        }
        else {
            System.out.println("Đăng nhập lại đê !! bro");
        }
        System.out.println();
        System.out.println("❄ 1. Đăng xuất ");
        System.out.println("_______________");
        System.out.println("❄ 2.Vào MENU  ");
        int choiceProfile = scanner.nextInt();
        switch (choiceProfile){
            case 1 :
                logOut();
                new  RegisterAndLoginView();
            case 2:
                new  Main();

        }
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")){
            new Main();
        }
    }
    public void logOut(){
        ManagerService.managerList.clear();
        managerService.findAll();
    }
}
