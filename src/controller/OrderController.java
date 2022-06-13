package controller;

import model.Order;
import service.order.OrderService;

import java.util.List;

public class OrderController {
    OrderService orderService = new OrderService();
    public List<Order> showList(){
        return orderService.findAll();

    }
    public void bestProduct(){
        orderService.sortByPrice();
    }
    public void createOder(Order order){
        orderService.save(order);
    }
}
