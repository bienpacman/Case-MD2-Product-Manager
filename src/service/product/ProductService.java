package service.product;

import config.ConfigReadAndWriteFIle;
import model.Category;
import model.Product;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductService implements IProductService{
    public static String Path = ConfigReadAndWriteFIle.Path + "product.txt";
    public static List<Product> productList = new ConfigReadAndWriteFIle<Product>().readFile(Path);

    public List<Product> findAll() {

        new ConfigReadAndWriteFIle<Product>().writeFile(Path, productList);
        return productList;
    }

    public void save(Product product) {
        productList.add(product);
    }

    public Product findById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (id == productList.get(i).getId()) {
                return productList.get(i);
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (id == productList.get(i).getId()){
                productList.remove(productList.get(i));
            }
        }
    }


    public void editById(Category category) {

    }

    public Product findProductByName(String name) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().equalsIgnoreCase(name)) {
                return productList.get(i);
            }
        }
        return null;
    }

    public void sortPrice() {
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() > o1.getPrice()) {
                    return -1;
                }
                return 1;
            }
        });
    }

    public void sortByName() {
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
    }

    @Override
    public void sortByPrice() {

    }

    public void editById(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (product.getId() == productList.get(i).getId()) {
                productList.get(i).setName(product.getName());
                productList.get(i).setOrigin(product.getOrigin());
                productList.get(i).setPrice(product.getPrice());
            }

        }
    }

    public Product findByCategory(String name) {
        for (int i = 0; i < productList.size(); i++) {
            if (name.equals(productList.get(i).getCategory().getName())) {
                System.out.println(productList.get(i));

            }
        }
        return null;
    }
    public Product findProductByPrice1(){
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getPrice() < 5000 && productList.get(i).getPrice() > 0){
                System.out.println(productList.get(i));
            }
        }
        return null;
    }
    public Product findProductByPrice2(){
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getPrice() > 5000 && productList.get(i).getPrice() < 20000){
                
                System.out.println(productList.get(i));            
            }
        }
        return null;
    }
public Product findProductByPrice3(){
    for (int i = 0; i < productList.size(); i++) {
        if (productList.get(i).getPrice() >20000){
            System.out.println(productList.get(i));
        }
    }
    return null;
}


}