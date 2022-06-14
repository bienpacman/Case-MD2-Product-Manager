

package view;

import model.Manager;
import model.Role;
import model.RoleName;
import model.User;
import service.manager.ManagerService;
import service.user.UserService;

import java.util.*;

public class Main {

    public Main() {
        if (ManagerService.managerList.size() == 0) {
            new RegisterAndLoginView();
        }
        List<Manager> managerList = ManagerService.managerList;
        List<User> userList = UserService.userList;
        boolean checklogin;
        Set<Role> roleSet = managerList.get(0).getRoleSet();
        List<Role> roleList = new ArrayList<>(roleSet);

        boolean checkManager = roleList.get(0).getName() == (RoleName.MANAGER);
        boolean checkUser = roleList.get(0).getName() == (RoleName.USER);
        CategoryView categoryView = new CategoryView();

        if (managerList.size() != 0) {
            checklogin = true;
        } else if (userList.size() != 0) {
            checklogin = true;
        } else
            checklogin = false;

        while (true) {

            try {

            if (checkManager) {

                System.out.println("▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆ QUẢN LÝ SẢN PHẨM  ▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆");
                System.out.println("█                                                                               █");
                System.out.println("█               1.  DANH SÁCH NGƯỜI DÙNG XEM                                    █");
                System.out.println("█               2.  HIỂN THỊ DANH MỤC                                           █");
                System.out.println("█               3.  THÊM DANH MỤC                                               █");
                System.out.println("█               4.  XÓA DANH MỤC THEO ID                                        █");
                System.out.println("█               5.  SỬA DANH MỤC THEO ID                                        █");
                System.out.println("█               6.  HIỂN THỊ DANH SÁCH SẢN PHẨM                                 █");
                System.out.println("█               7.  THÊM SẢN PHẨM                                               █");
                System.out.println("█               8.  XÓA SẢN PHẨM                                                █");
                System.out.println("█               9.  SỬA SẢN PHẨM THEO ID                                        █");
                System.out.println("█               10. HỒ SƠ                                                       █");
                System.out.println("█               11. THOÁT                                                       █");
                System.out.println("▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆");
            } else if (checkUser) {
                System.out.println("▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆  NGƯỜI DÙNG ĐĂNG NHẬP  ▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆ ");
                System.out.println("█                                                                               █");
                System.out.println("█               1.  TÌM SẢN PHẨM THEO GIÁ                                       █");
                System.out.println("█               2.   TÌM SẢN PHẨM THEO TÊN                                      █");
                System.out.println("█               3.  SẮP XẾP SẢN PHẨM THEO GIÁ                                   █");
                System.out.println("█               4.  MUA SẢN PHẨM                                                █");
                System.out.println("█               5.  DANH SÁCH SẢN PHẨM BÁN CHẠY                                 █");
                System.out.println("█               6. DANH SÁCH SẢN PHẨM                                           █");
                System.out.println("█               7.  SẢN PHẨM ĐÃ MUA                                             █");
                System.out.println("█               8.  THOÁT                                                       █");
                System.out.println("▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆");

                //  System.out.println("8. THỐNG KÊ SỐ LƯỢNG SẢN PHẨM THEO THƯ MỤC ");

            }


            System.out.print("\uD83C\uDF4E Chọn số đi bạn :");
            int choice;
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();


                if (checkManager) {
                    switch (choice) {
                        case 1:
                            new RoleView().showListRole();
                            break;
                        case 2:
                            categoryView.showCategory();
                            break;
                        case 3:
                            categoryView.addCategory();
                            break;
                        case 4:
                            categoryView.deleteCategory();
                            break;
                        case 5:
                            categoryView.editById();
                            break;
                        case 6:
                            new ProductView().showProduct();
                            break;
                        case 7:
                            new ProductView().addProduct();
                            break;
                        case 8:
                            new ProductView().deleteProduct();
                            break;
                        case 9:
                            new ProductView().editProduct();
                            break;
                        case 10:
                            new ProfileView();
                            break;
                        case 11:
                            new RegisterAndLoginView();
                            break;

                    }

                } else if (checkUser) {
                    switch (choice) {
                        case 1:
                            new ProductView().findProductByPrice();
                            break;
                        case 2:
                            new ProductView().findProductByName();
                            break;
                        case 3:
                            new ProductView().sortByPrice();
                            break;
                        case 4:
                            new OrderView().createOrder();
                            break;
                        case 5:
                            new OrderView().bestProduct();
                            break;
                        case 6:
                            new ProductView().showProduct();
                            break;
                        case 7:
                            new OrderView().showListOder();
                            break;
                        case 8:
                            new RegisterAndLoginView();
                            break;
                        default:
                            break;
                    }
                }
            } catch (InputMismatchException e) {
                System.err.println(" nhập sai rồi em êii !! Nhập lại đê :");
            } catch (Exception e) {
                e.getMessage();
            }


        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
