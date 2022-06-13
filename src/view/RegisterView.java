package view;

import controller.UserController;
import dto.SignUpDTO;
import model.User;
import service.role.RoleService;
import service.user.UserService;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class RegisterView {
    Scanner scanner = new Scanner(System.in);
    UserController userController = new UserController();
    UserService userService = new UserService();

    public void register() {
        new RoleService().findAll();
        System.out.println();
        System.out.print("Nhập tên của bạn : ✏️ ");
        boolean checkName;
        String name;
        while (true) {
            name = scanner.nextLine();
            checkName = Pattern.matches("[A-Za-z0-9]{3,10}",name);
            if (!checkName){
                System.err.println("Nhập đúng tên đi ông cháu ☹ !!  :");
            }else
                break;
        }
        System.out.print("Nhập tên đăng nhập : ✏️");
        boolean checkUsername;
        String username;
        while (true) {
            username = scanner.nextLine();
            checkUsername = Pattern.matches("[A-Za-z0-9]{4,}", username);
            if (!checkUsername) {
                System.err.println("Nhập sai rồi !Tạo lại tài khoản đi bro ☹ !");
                new RegisterAndLoginView();
            } else if (userService.existedUsername(username)) {
                System.err.println("Trùng tên rồi chọn tên khác đi bạn êii ☹  !!");
            } else
                break;
        }

        System.out.print("Nhập mật khẩu :✏️");
        boolean checkPass;
        String password;
        while (true) {
            password = scanner.nextLine();
            checkPass = Pattern.matches("[A-Za-z0-9]+", password);
            if (!checkPass) {
                System.err.println("Nhập sai rồi ! Tạo lại mật khẩu đi bro ☹ !!");
            } else
                break;
        }


        System.out.print("Chọn quyền truy cập (MANAGER/USER) ✏️");
        boolean checkRole;
        String role;
        while (true) {
            role = scanner.nextLine();
            checkRole = Pattern.matches("[MNSGEARU]{4,7}", role);
            if (!checkRole) {
                System.err.println("Nhập sai rồi !Chọn lại quyền truy cập đi bro ☹  !");
            } else
                break;
        }
        Set<String> strRole = new HashSet<>();
        strRole.add(role);
        SignUpDTO signUpDTO = new SignUpDTO(name, username, password, strRole);
        userController.register(signUpDTO);
        System.out.println();
        System.out.println("Tạo tài khoản thành công ☻ !! ");
        System.out.println("_______________________________________________________");
        new LoginView();


    }
}


