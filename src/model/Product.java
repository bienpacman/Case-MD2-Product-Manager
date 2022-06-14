package model;

import java.io.Serializable;

public  class Product implements Serializable {
    private  int id;

    public int getQuantity() {
        return quantity;
    }

    private String name;
    private  String origin;
    private int quantity;
    private double price;

    private  Category category;

    public Product(int id, String name, String origin, int quantity, double price, Category category) {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
    }
    public Product(int id, String name, String origin, int quantity, double price, int idCategory){
        this.name = name;
    }



    public Product() {
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }



    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    public void setQuantity(Product quantity) {

    }

    @Override
    public String toString() {
        return "Id : " + id + "|" +
                " Sản phẩm :" + name + "|" +
                " Xuất xứ :" + origin + "|" +
                " số lượng :" + quantity + "|" +
                " Giá :" + price + "||" +
                  category
                + "________________________________________________________________________________________________________________________"+ "\n"
             ;
    }
}
