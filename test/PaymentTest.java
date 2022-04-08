package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import posSystem.Money;
import posSystem.Payment;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Payment Specification")
class PaymentTest {


    private Money _amount;
    private Payment payBill;
    @BeforeEach
    void  setUp(){
        _amount = new Money(100.00);
        payBill = new Payment(_amount);
    }

    @Test
    @DisplayName("Constructor Payment Cash Tendered")
    void constructorPaymentMoney(){
        assertEquals("Payment", payBill.getClass().getSimpleName()," should be constructor of class "+ payBill.getClass().getSimpleName());
    }

    @Test
    @DisplayName("Amount  be the same as Cash Tendered")
    void amountShouldBeTheSameAsCashTendered() {
        assertEquals(100.00, payBill.getAmount().getMoney().doubleValue()," Should be the same amount :"+_amount.getMoney());
    }

    @Test
    @DisplayName("Cash Tendered Cannot be Zero")
    protected void cashTenderedCannotBeZeroThrowsException() {

        payBill = new Payment(new Money(0.00));
        if (payBill.getAmount() == new Money(0.00)) {
            Throwable exception;

            exception = assertThrows(IllegalArgumentException.class, () -> {
                Money cashTendered = new Money(0.00);
            });
            assertEquals("Cash tendered cannot be zero or less", exception.getMessage());

        }
    }
}