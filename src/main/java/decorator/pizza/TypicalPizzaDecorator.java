package decorator.pizza;

import java.math.BigDecimal;

public class TypicalPizzaDecorator extends AbstractPizzaDecorator {

    public TypicalPizzaDecorator(BasicPizza basicPizza) {
        super(basicPizza);
    }

    @Override
    public BigDecimal getPrice(){
        return super.getPrice().add(new BigDecimal(17));
    }

    @Override
    public String getDescription(){
        return super.getDescription() + " z dodatkowym serem i oliwkami";
    }
}
