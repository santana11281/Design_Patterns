package Behavioral;

import java.util.ArrayList;
import java.util.List;


//        Step 1
//        Create a command interface.
interface Order {
    void execute();
}


//        Step 2
//        Create a request class.
class Stock {

    private String name = "ABC";
    private final int quantity = 10;

    public void buy() {
        System.out.println("Stock [ Name: " + name + ", Quantity: " + quantity + " ] bought");
    }

    public void sell() {
        System.out.println("Stock [ Name: " + name + ", Quantity: " + quantity + " ] sold");
    }
}


//        Step 3
//        Create concrete classes implementing the Order interface.
class BuyStock implements Order {
    private Stock abcStock;

    public BuyStock(Stock abcStock) {
        this.abcStock = abcStock;
    }

    public void execute() {
        abcStock.buy();
    }
}


class SellStock implements Order {
    private Stock abcStock;

    public SellStock(Stock abcStock) {
        this.abcStock = abcStock;
    }

    public void execute() {
        abcStock.sell();
    }
}


//        Step 4
//        Create command invoker class.
class Broker {
    private final List<Order> orderList = new ArrayList<>();

    public void takeOrder(Order order) {
        orderList.add(order);
    }

    public void placeOrders() {

        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}


//        Step 5
//        Use the Broker class to take and execute commands.
class CommandPatternDemo {
    public static void main(String[] args) {
        var abcStock = new Stock();

        var buyStockOrder = new BuyStock(abcStock);
        var sellStockOrder = new SellStock(abcStock);

        var broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();
    }
}


//        Step 6
//        Verify the output.
//
//        Stock [ Name: ABC, Quantity: 10 ] bought
//        Stock [ Name: ABC, Quantity: 10 ] sold