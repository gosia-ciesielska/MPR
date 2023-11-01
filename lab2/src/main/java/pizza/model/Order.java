package pizza.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private static int allOrders = 0;
    private int orderNumber;
    private Pizza orderedPizza;
    private double price;

    public Order(Pizza pizza) {
        orderNumber = ++allOrders;
        orderedPizza = pizza;
        price = orderedPizza.getPrice();
    }

    @Override
    public String toString() {
        return "Order no." + orderNumber +
                ": " + orderedPizza.getName() +
                ", " + price;
    }
}
