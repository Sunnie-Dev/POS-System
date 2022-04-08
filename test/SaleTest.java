package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import posSystem.*;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Sales Specification")
class SaleTest {
   private  Payment _payBill;
   private Sale _sale;
   private boolean _yes;
   private List<SalesLineItem> _lineItems = new ArrayList<SalesLineItem>();
   private ProductDescription _product01, _product02;


    @BeforeEach
    void setUp(){
        _yes = false;
        _payBill = new Payment(new Money(100));
        _sale = new Sale();
        _yes = true;

        _product01 = new ProductDescription(new ItemID(500),new Money(2.75),"cookies");
        _product02 = new ProductDescription(new ItemID(501),new Money(1.99), "cane Sugar");
      //  _lineItems.add(new SalesLineItem(_product01,3));
        _payBill.getAmount().minus(new Money(3.7));
    }

    @Test
    @DisplayName(" Should Get Balance")

    void getBalance() {

        assertEquals(80.00,_payBill.getAmount().minus(new Money(20)).getMoney().doubleValue(),"Should be 80");
    }

    @Test
    @DisplayName("isComplete Field Boolean Initial Assignment")
    void isCompleteFieldBooleanInitialAssignment() throws Exception{
         Field obj;
        obj = _sale.getClass().getDeclaredField("isComplete");
        obj.setAccessible(true);
        assertFalse(obj.getBoolean(_sale));
    }


    @Test
    @DisplayName("Should Become True When Sales Is Completed")
    void shouldBecomeTrueWhenSaleIsComplete(){
       _sale.becomeComplete();
       assertEquals(true , _sale.isComplete(), "Should be True as Sale is Completed");

    }

    @Test
    @DisplayName("Should Stay False When Sale Is Not Completed")
    void shouldStayFalseWhenSaleIsNotComplete(){

        assertEquals(false , _sale.isComplete(), "Should be False as Sales is not Completed");

    }

    @Test
    @DisplayName("shouldMakeALineItem")
    void shouldMakeLineItem() {

    }

    @Test
    void getTotal() {
        _sale.makeLineItem(_product01,1);
        _sale.makeLineItem(_product02,1);
        _sale.becomeComplete();
        _sale.isComplete();
       assertEquals(4.74, _sale.getTotal().getMoney().doubleValue(),"Should equals 4.74");
    }

    @Test
    @DisplayName("Should Make Payment with Cash Tendered")
    void shouldMakePaymentWithCashTendered() {

        assertEquals(100.00, _payBill.getAmount().getMoney().doubleValue(),"Should be 100");
    }
}