package view;

import controller.UserController;
import dto.SignInDTO;

import java.util.Scanner;

public class LoginView {
    Scanner scanner =new Scanner(System.in);
    UserController userController = new UserController();
    public LoginView(){
        System.out.println( "▁ ▂ ▃ ▄ ▅ ▆ ▇ █ ĐĂNG NHẬP █ ▇ ▆ ▅ ▄ ▃ ▂ ▁  ");
        System.out.println();
        System.out.print("✿ Nhập đăng nhập :✏️ ");
        String username = scanner.nextLine();

        System.out.print("✿ Nhập mật khẩu :✏️ ");

        String password = scanner.nextLine();
        SignInDTO signInDTO = new SignInDTO(username,password);
        if (userController.login(signInDTO)){
            new ProfileView();
        }else {
            System.err.println("Đăng nhập thất bại! vui lòng kiểm tra tên người dùng hoặc mật khẩu! ⚠️  ");
          new RegisterAndLoginView();
        }
    }
}
