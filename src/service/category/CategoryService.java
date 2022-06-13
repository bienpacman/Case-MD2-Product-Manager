package service.category;

import config.ConfigReadAndWriteFIle;
import controller.CategoryController;
import model.Category;
import model.Product;
import service.product.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CategoryService implements ICategoryService {
    Scanner scanner = new Scanner(System.in);

    public static String PathCategory = ConfigReadAndWriteFIle.Path + "category.txt";

    public static List<Category> categoryList = new ConfigReadAndWriteFIle<Category>().readFile(PathCategory);

    @Override
    public List<Category> findAll() {

        new ConfigReadAndWriteFIle<Category>().writeFile(PathCategory, categoryList);
        return categoryList;
    }

    @Override
    public void save(Category category) {
        categoryList.add(category);
    }


    @Override
    public Category findById(int id) {
        for (int i = 0; i < categoryList.size(); i++) {
            if (id == categoryList.get(i).getId()) {
                return categoryList.get(i);
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        for (int i = 0; i < categoryList.size(); i++) {
            if (id == categoryList.get(i).getId()) {
                categoryList.remove(categoryList.get(i));
            }
        }
    }

    @Override
    public void editById(Category category) {
        for (int i = 0; i < categoryList.size(); i++) {
            if (category.getId() == categoryList.get(i).getId()) {
                categoryList.get(i).setName(category.getName());
            }
        }
    }

    @Override
    public void editById(Product product) {

    }

    @Override
    public  void sortByName() {

    }

    @Override
    public void sortByPrice() {

    }

    @Override
    public Category findProductByName(String name) {

        return null;
    }

    @Override
    public Category findByCategoryName(String name) {
        for (int i = 0; i < categoryList.size(); i++) {
            if (categoryList.get(i).getName().equalsIgnoreCase(name)) {
                return categoryList.get(i);
            }

        }
        return null;
    }

    @Override
    public List<Product> findByNameCategory(String name) {
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < new ProductService().findAll().size(); i++) {
            if (name.equals(new ProductService().findAll().get(i).getCategory().getName())) {
                productList.add(new ProductService().findAll().get(i));
            }
        }
        return productList;
    }
}


