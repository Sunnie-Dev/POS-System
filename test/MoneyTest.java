package test;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import posSystem.Money;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Money Specification")
class MoneyTest {

    private  int _moneyInt;
    private double _moneyDouble;
    private BigDecimal _moneyBigDecimal;

    @BeforeEach
    void setUp(){
        _moneyInt = 5;
        _moneyDouble = 0.25;
        _moneyBigDecimal = BigDecimal.valueOf(6.25);

    }

    @Test
    @DisplayName("Constructor Money No Parameter")
    void constructorMoneyNoParameter(){
        Money _money = new Money();
        assertEquals("Money", _money.getClass().getSimpleName(),"Should have the default constructor");

    }


    @Test
    @DisplayName(" Constructor Money with Integer ")
    void constructorMoneyInteger(){
        Money _money = new Money(_moneyInt);
        assertEquals("Money",_money.getClass().getSimpleName(), "Should have default constructor Money");

    }

    @Test
    @DisplayName("Constructor Money with Double")
    void constructorMoneyDouble(){
        Money _money = new Money(_moneyDouble);
        assertEquals("Money", _money.getClass().getSimpleName(), "Should have default constructor Money");

    }

    @Test
    @DisplayName("Constructor Money with Big Decimal")
    void constructorMoneyBigDecimal(){

    }
    @Test
    @DisplayName("Should Multiply The Money by Quantity")
    void multiplyMoneyByQuantity() {
        Money _money = new Money(_moneyDouble);
        Money total =  _money.times(16);

        assertEquals(4.00, total.getMoney().doubleValue(),"Should be Equals to "+ total.getMoney());
    }

    @Test
    @DisplayName("Should Add the Money to the SubTotal")
    void addMoneyToSubtotal() {
        Money _money = new Money(_moneyInt);
        Money subtotal = _money.add(new Money(20));

        assertEquals(25.00, subtotal.getMoney().doubleValue(), "Should be Equals to "+subtotal.getMoney());
    }

    @Test
    @DisplayName("Should Subtract Total From Money")
    void minusTotalFromMoney() {
        Money _money = new Money(15.25);
        Money cashBack = _money.minus(new Money(2.59));

        assertEquals(12.66, cashBack.getMoney().doubleValue(),"Should be Equals to "+ cashBack.getMoney());

    }
}