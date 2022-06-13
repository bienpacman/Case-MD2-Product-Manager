package service.category;

import model.Category;
import model.Product;
import service.IServiceGeneric;

import java.util.List;

public interface ICategoryService extends IServiceGeneric<Category> {

    void sortByName();

    Category findByCategoryName(String name );
    List<Product> findByNameCategory(String name);
}
