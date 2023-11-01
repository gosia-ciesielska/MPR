package pizza;

import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pizza.model.*;

import java.util.List;

@AllArgsConstructor
public class PizzaService {
    private List<Pizza> availablePizzas;
    private static final Logger logger = LogManager.getLogger(PizzaService.class);

    public Order makeOrder(Pizza pizza) {
        if (!availablePizzas.contains(pizza)) {
            throw new PizzaNotFoundException("This pizza is not available");
        }
        logger.info("Making order...");
        return new Order(pizza);
    }

    public List<Pizza> getAvailablePizzas() {
        logger.info("Getting available pizzas...");
        return availablePizzas;
    }
}
