package pizza;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pizza.model.Order;
import pizza.model.Pizza;

import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Pizza pizza1 = new Pizza("Margherita", 12.99);
        Pizza pizza2 = new Pizza("Capricciosa", 15.00);
        PizzaService pizzaService = new PizzaService(List.of(pizza1, pizza2));
        for (Pizza pizza : pizzaService.getAvailablePizzas()) {
            System.out.println(pizza);
        }
        try {
            Order order1 = pizzaService.makeOrder(pizza1);
            System.out.println(order1);
            Order order2 = pizzaService.makeOrder(pizza2);
            System.out.println(order2);
            Order order3 = pizzaService.makeOrder(new Pizza("Pepperoni", 16.00));
            System.out.println(order3);
        } catch (PizzaNotFoundException e) {
            logger.error(e.getMessage());
        }
    }
}