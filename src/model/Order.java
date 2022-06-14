package model;

import java.io.Serializable;

public class Order extends Product implements Serializable {
    private int count;
    private String customer;
    private int amount;

    private Product product;
    public Order(int amount) {
        this.amount = amount;
    }

    public Order() {
    }

    public Order(int id, String name, String origin, int quantity, double price, Category category, int count, String customer, int amount, Product product) {
        super(id, name, origin, quantity, price, category);
        this.count = count;
        this.customer = customer;
        this.amount = amount;
        this.product = product;
    }

    public Order(int id, String name, String origin, int quantity, double price, int idCategory, int count, String customer, int amount, Product product) {
        super(id, name, origin, quantity, price, idCategory);
        this.count = count;
        this.customer = customer;
        this.amount = amount;
        this.product = product;
    }

    public Order(int count, String customer, int amount, Product product) {
        this.count = count;
        this.customer = customer;
        this.amount = amount;
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public  double total(){
        return this.amount * product.getPrice();
    }
    @Override
    public String toString() {
        return "Order => " +
                " STT " + count +"   " +
                " Tên khách hàng : " + customer + "  " +
                " Số lượng : " + amount + "\n" +
                 product + "\t" +"Tổng tiền " + total() +"\n"
               + "________________________________________________________________________________________________________________________-" + "\n"
                ;
    }
}
