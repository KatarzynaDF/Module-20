package decorator.pizza;

import java.math.BigDecimal;

public class BasicPizzaOrder implements BasicPizza {
    @Override
    public BigDecimal getPrice() {
        return new BigDecimal(12.00);
    }

    @Override
    public String getDescription() {
        return "Ser, szynka i pieczarki";
    }
}
