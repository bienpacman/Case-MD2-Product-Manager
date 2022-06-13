package view;

import controller.CategoryController;
import model.Category;
import service.category.CategoryService;

import java.util.List;
import java.util.Scanner;

public class CategoryView {
    CategoryController categoryController = new CategoryController();
    Scanner scanner = new Scanner(System.in);
    List<Category> categoryList = CategoryService.categoryList;

    public void addCategory() {
        while (true) {
            int id;
            if (categoryList.size() == 0) {
                id = 1;
            } else {
                id = categoryList.get(categoryList.size() - 1).getId() + 1;
            }
            System.out.println("Nhập tên thư mục :");
            String name = scanner.nextLine();
            Category category = new Category(id, name);
            categoryController.createCategory(category);
            System.out.println(categoryController.showListCategory());
            System.out.println("Nhập bất kỳ phím nào để tiếp tục tạo Danh mục sản phẩm hoặc Nhập QUIT để quay lại menu: ");
            String backMenu = scanner.nextLine();
            if (backMenu.equalsIgnoreCase("quit")) {
                new Main();
            }
        }
    }

    public void showCategory() {
        categoryController.sortCategory();
        System.out.println(categoryController.showListCategory());
        System.out.println(" Nhập quit để quay lại MENU: ");
        String backMenu = scanner.nextLine();
        if (backMenu.equalsIgnoreCase("quit")) {
            new Main();
        }
    }

    public void deleteCategory() {
        while (true) {
            System.out.println(categoryController.showListCategory());
            System.out.println("Nhập Id Muốn xóa :");
            int id = Integer.parseInt(scanner.nextLine());
            categoryController.deleteById(id);
            categoryController.showListCategory();
            System.out.println("Nhập bất kỳ phím nào để tiếp tục xóa Danh mục sản phẩm hoặc Nhập QUIT để quay lại menu: ");
            String backMenu = scanner.nextLine();
            if (backMenu.equalsIgnoreCase("quit")) {
                new Main();
            }
        }
    }
public void editById(){
        while (true){
            System.out.println(categoryController.showListCategory());
            System.out.println("Nhập ID muốn sửa :");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập tên danh mục :");
            String name = scanner.nextLine();
            Category category = new Category(id,name);
            categoryController.editById(category);
            System.out.println(categoryController.showListCategory());
            System.out.println("Nhập bất kỳ phím nào để tiếp tục chỉnh sửa Danh mục sản phẩm hoặc Nhập QUIT để quay lại menu: ");
            String backMenu = scanner.nextLine();
            if (backMenu.equalsIgnoreCase("quit")){
                new Main();
            }
        }
}


}
