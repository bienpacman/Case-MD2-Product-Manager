package view;

import controller.CategoryController;
import controller.ProductController;
import model.Category;
import model.Product;
import service.product.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductView {
    Scanner scanner = new Scanner(System.in);
    ProductController productController = new ProductController();
    CategoryController categoryController = new CategoryController();
    List<Product> productList = ProductService.productList;


    public void addProduct() {
        while (true) {
            int id;
            if (ProductService.productList.size() == 0) {
                id = 1;
            } else {
                id = productList.get(productList.size() - 1).getId() + 1;
            }
            System.out.println("Nhập tên sản phẩm : ");
            String name = scanner.nextLine();
            System.out.println("Nhập xuất xứ :");
            String origin = scanner.nextLine();
            System.out.println("Nhập số lượng sản phẩm :");
            int quantity = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập giá :");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.println("Nhập Id danh mục :");
            int idCategory = Integer.parseInt(scanner.nextLine());

            Category category = new CategoryController().findById(idCategory);
            Product product = new Product(id, name, origin, quantity, price, category) {
                @Override
                public void setQuantity(Product quantity) {

                }
            };
            productController.creatProduct(product);
            System.out.println("Nhập bất kì phím nào để tiếp tục tạo sản phẩm hoặc Quit để về MENU :");
            String backMenu = scanner.nextLine();
            if (backMenu.equalsIgnoreCase("quit")) {
                new Main();
            }
        }

    }


    public void deleteProduct() {
        System.out.println(productController.showListProduct());
        System.out.println("Nhập ID muốn xóa :");
        if (productList.size() != 0) {
            int id = Integer.parseInt(scanner.nextLine());
            productController.deleteById(id);
        } else {
            System.out.println("Không có gì để xóa");
            new Main();
        }
        System.out.println(productController.showListProduct());
        System.out.println("Nhập bất kì phím nào để tiếp tục tạo sản phẩm hoặc Quit để về MENU :");
        scanner.nextLine();
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) ;
        new Main();
    }

    public void editProduct() {
        while (true) {
            System.out.println(productController.showListProduct());
            System.out.println("Nhập Id muốn sửa : ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("Sửa sản phẩm  :");
            String name = scanner.nextLine();
            System.out.println("Sửa xuất xứ :");
            String origin = scanner.nextLine();
            System.out.println("Sửa số lượng :");
            int quantity = Integer.parseInt(scanner.nextLine());
            System.out.println("Sửa giá :");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.println("Sửa danh mục :");
            String nameCategory = scanner.nextLine();
            Category category = new Category(nameCategory);
            Product product = new Product(id, name, origin, quantity, price, category) {
                @Override
                public void setQuantity(Product quantity) {

                }
            };
            productController.editById(product);
            System.out.println(productController.showListProduct());
            System.out.println("Nhập phím bất kỳ để tiếp tục tạo Sản phẩm hoặc Nhập QUIT để quay lại menu: ");
            String backMenu = scanner.nextLine();
            if (backMenu.equalsIgnoreCase("quit")) {
                new Main();
            }
        }
    }

    public void showProduct() {
        System.out.println(ProductController.showListProduct());
        System.out.println("Nhập quit để trở về Menu ");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new Main();
        }
    }

    public void findProductByPrice() {
        while (true) {
            System.out.println("1. Tìm giá từ 0 ~ 5000");
            System.out.println("2. Tìm giá từ 5000 ~ 20000");
            System.out.println("3. Tìm giá từ 20000 ~ 100000");
            System.out.println("Nhập một lựa chọn :");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    productController.findProductByPrice1();
                    System.out.println("Nhập Quit để về MENU :");
                    scanner.nextLine();
                    String backMenu = scanner.nextLine();
                    if (backMenu.equalsIgnoreCase("quit")) {
                        new Main();
                    }
                    break;
                case 2:
                    productController.findProductByPrice2();
                    System.out.println("Nhập bất kì phím nào để tiếp tục tạo sản phẩm hoặc Quit để về MENU ");
                    scanner.nextLine();
                    String backMenu2 = scanner.nextLine();
                    if (backMenu2.equalsIgnoreCase("quit")) {
                        new Main();
                    }
                    break;
                case 3:
                    productController.findProductByPrice3();
                    System.out.println("Nhập bất kì phím nào để tiếp tục tạo sản phẩm hoặc Quit để về MENU :");
                    scanner.nextLine();
                    String backMenu3 = scanner.nextLine();
                    if (backMenu3.equalsIgnoreCase("quit")) ;
                    new Main();
            }
            break;

        }
    }

    public void sortByName() {
        System.out.println("List trước khi sửa :");
        System.out.println(productController.showListProduct());
        productController.sortByName();
        System.out.println("List sau khi sửa :");
        System.out.println(productController.showListProduct());
        System.out.println("Nhập bất kì phím nào để tiếp tục tạo sản phẩm hoặc Quit để về MENU :");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) ;
        new Main();
    }

    public void sortByPrice() {
        System.out.println("List trước khi sửa :");
        System.out.println(productController.showListProduct());
        productController.sortByPrice();
        System.out.println("List sau khi sửa ");
        System.out.println(productController.showListProduct());
        System.out.println("Nhập bất kì phím nào để tiếp tục tạo sản phẩm hoặc Quit để về MENU :");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) ;
        new Main();
    }

    public void findProductByName() {
        System.out.println("Nhập tên cần tìm : ");
        String name = scanner.nextLine();
        if (productController.findProductByName(name) != null) {
            System.out.println(productController.findProductByName(name));
        } else {
            System.out.println("Không tồn tại sản phẩm ");
            System.out.println("Nhập bất kì phím nào để tiếp tục tạo sản phẩm hoặc Quit để về MENU :");
            String backMenu = scanner.nextLine();
            if (backMenu.equalsIgnoreCase("quit")) {
                new Main();
            }
        }
    }
}


