package view;

import controller.CategoryController;
import controller.OrderController;
import controller.ProductController;
import model.Category;
import model.Order;
import model.Product;
import service.order.OrderService;
import service.product.ProductService;

import java.util.List;
import java.util.Scanner;

public class OrderView {
    Scanner scanner = new Scanner(System.in);
    OrderController orderController = new OrderController();
    Order order = new Order();

    CategoryController categoryController = new CategoryController();
    List<Order> orderList = OrderService.orderList;

    public void  createOrder(){
        while (true){
            int count;
            if (OrderService.orderList.size() == 0){
                count = 1;
            }else {
                count = orderList.get(orderList.size()-1).getCount()+1;
            }
            System.out.println("Nhập số lượng mua :");
            int amount = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập tên người mua : ");
            String orderDay = scanner.nextLine();

            System.out.println("Nhập id sản phẩm : ");
            int idProduct = Integer.parseInt(scanner.nextLine());
            Product product = new ProductController().findById(idProduct);
            order = new Order(count,orderDay,amount,product);

            orderController.createOder(order);
            System.out.println(orderController.showList());
            System.out.println("Nhập phím bất kỳ để tiếp tục mua Sản phẩm hoặc Nhập QUIT để quay lại menu: ");
            String backMenu = scanner.nextLine();
            if(backMenu.equalsIgnoreCase("quit")){
                new Main();
            }
        }
    }
    public void  bestProduct(){
        System.out.println("Sản phẩm bán chạy nhất  :");
        orderController.bestProduct();
        System.out.println(orderController.showList());
        System.out.println(" Nhập QUIT để quay lại menu: ");
        String backMenu = scanner.nextLine();
        if(backMenu.equalsIgnoreCase("quit")){
            new Main();
        }
    }
    public void showListOder(){
        System.out.println(orderController.showList());
        System.out.println("Nhập QUIT để quay lại menu: ");
        String backMenu = scanner.nextLine();
        if(backMenu.equalsIgnoreCase("quit")){
            new Main();
        }
    }
}
