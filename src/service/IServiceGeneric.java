package service;

import model.Category;
import model.Product;

import java.util.List;

public interface IServiceGeneric<T> {
    List<T> findAll();
    void save(T t);
    T findById(int id);
    void deleteById(int id );
    void editById(Category category);
    void editById(Product product);
    void sortByName();
    void sortByPrice();
    T findProductByName (String name);
}
