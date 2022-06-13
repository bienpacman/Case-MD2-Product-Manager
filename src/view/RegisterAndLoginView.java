package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RegisterAndLoginView {
    public RegisterAndLoginView() {
        Scanner scanner = new Scanner(System.in);
        RegisterView  registerView = new RegisterView();


        while (true) {
            try {
                System.out.println("                        ▁ ▂ ▃ ▄ ▅ ▆ ▇ █ REGISTER AND LOGIN █ ▇ ▆ ▅ ▄ ▃ ▂ ▁ ");
                System.out.println("_______________________");
                System.out.println("✿ 1. TẠO TÀI KHOẢN :✏️ ");
                System.out.println("_______________________");
                System.out.println("✿ 2. ĐĂNG NHẬP  :✏️");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        registerView.register();
                        break;
                    case 2:
                        new LoginView();
                        break;
                }
            } catch (NumberFormatException e) {
                System.err.println("Nhập lại đê ông cháu ☹ !!");
            }

        }

    }
}
