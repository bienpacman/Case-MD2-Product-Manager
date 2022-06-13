package service.product;

import model.Product;
import service.IServiceGeneric;

public interface IProductService extends IServiceGeneric<Product> {
    Product findByCategory(String name);
    Product findProductByPrice1();
    Product findProductByPrice2();
    Product findProductByPrice3();
}
