package service.order;

import config.ConfigReadAndWriteFIle;
import model.Category;
import model.Order;
import model.Product;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrderService implements IOrderService {
    public static String PathOrder = ConfigReadAndWriteFIle.Path + "order.txt";
    public static List<Order> orderList = new ConfigReadAndWriteFIle<Order>().readFile(PathOrder);

    @Override
    public List<Order> findAll() {
        new ConfigReadAndWriteFIle<Order>().writeFile(PathOrder, orderList);
        return orderList;
    }

    @Override
    public void save(Order order) {
        orderList.add(order);
    }

    @Override
    public Order findById(int id) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void editById(Category category) {

    }

    @Override
    public void editById(Product product) {

    }

    @Override
    public void sortByName() {

    }

    @Override
    public void sortByPrice() {
        Collections.sort(orderList, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                if (o1.getAmount() > o2.getAmount()){
                    return -1;
                }
                return 1;
            }
        });
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getAmount() > 5){
                System.out.println(orderList.get(i));
            }
        }
    }

    @Override
    public Order findProductByName(String name) {
        return null;
    }
}
