package pizza.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Pizza {
    private String name;
    private double price;

    @Override
    public String toString() {
        return name + ", price: " + price;
    }
}
