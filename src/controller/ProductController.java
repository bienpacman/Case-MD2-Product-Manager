package controller;

import model.Category;
import model.Product;
import service.product.ProductService;

import java.util.List;

public class ProductController {
    static ProductService productService = new ProductService();

    public static List<Product> showListProduct() {

        return productService.findAll();
    }
    public void creatProduct(Product product){
        productService.save(product);
    }
    public void findProductByCategoryName(String name){
        productService.findByCategory(name);
    }
    public void findProductByPrice1(){
        productService.findProductByPrice1();
    }
    public void findProductByPrice2(){
        productService.findProductByPrice2();
    }
    public void  findProductByPrice3(){
        productService.findProductByPrice3();
    }
    public void deleteById(int id){
        productService.deleteById(id);
    }
    public void editById(Product product){
        productService.editById(product);
    }
    public void sortByName(){
        productService.sortByName();
    }
    public void sortByPrice(){
        productService.sortPrice();
    }
    public Product findById(int id){
        return productService.findById(id);
    }
    public Product findProductByName(String name){
        return productService.findProductByName(name);
    }

}
