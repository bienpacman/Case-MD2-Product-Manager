package controller;

import model.Category;
import model.Product;
import service.category.CategoryService;


import java.util.List;

public class CategoryController {
    CategoryService categoryService = new CategoryService();

    public List<Category> showListCategory() {
        return categoryService.findAll();
    }
    public List<Product> findProductByName(String name) {
        return categoryService.findByNameCategory(name);
    }

    public void createCategory(Category category) {
        categoryService.save(category);
    }

    public Category findById(int id) {
        return categoryService.findById(id);
    }
    public void deleteById(int id){
        categoryService.deleteById(id);
    }
    public Category findCategoryName(String name){
        return categoryService.findByCategoryName(name);
    }
    public void editById(Category category){
        categoryService.editById(category);
    }
    public void sortCategory(){
        categoryService.sortByName();
    }

}
