package decorator.pizza;

import java.math.BigDecimal;

public abstract class AbstractPizzaDecorator implements BasicPizza{

    private final BasicPizza basicPizza;

    protected AbstractPizzaDecorator(BasicPizza basicPizza) {
        this.basicPizza = basicPizza;
    }

    @Override
    public BigDecimal getPrice(){
        return basicPizza.getPrice();
    }

    @Override
    public String getDescription(){
        return basicPizza.getDescription();
    }
}
