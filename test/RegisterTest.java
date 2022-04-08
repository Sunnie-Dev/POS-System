package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import posSystem.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Register Specification")
class RegisterTest {

    private Register _register;
    private ProductCatalog _productCatalog;
    private Sale _currentSale;
    private Money _cash;
    private ItemID _itemId;
    private ProductDescription _desc;
    private SalesLineItem _lineItem;
    private Map<ItemID, ProductDescription> _descriptions;
    private boolean isSaleComplete;
    private ArrayList _lineItems;

    @BeforeEach
    void setUp(){
        _itemId = new ItemID(100);
        _descriptions = new HashMap<ItemID, ProductDescription> ();
        _desc = new ProductDescription(_itemId, new Money(2.99),"Salad Dressing");
        _descriptions.put(_itemId, _desc);
        _productCatalog = new ProductCatalog();
        _register = new Register(_productCatalog);
        _currentSale = new Sale();
        _lineItem = new SalesLineItem(_desc,6);
        _lineItems = new ArrayList <SalesLineItem>();
    }


    @Test
    @DisplayName("Constructor Register With Parameter Catalog")
    void constructorRegisterWithParameterCatalog() throws NoSuchFieldException{
      Register _reg = new Register(new ProductCatalog());
       Field fieldCatalog = _reg.getClass().getDeclaredField("catalog");
       fieldCatalog.setAccessible(true);
       assertEquals("Register" ,_reg.getClass().getSimpleName());
    }

    @Test
    @DisplayName("Should Trigger End of Sale With Completed")
    void shouldTriggerEndOfSaleWithComplete() {
      _register.makeNewSale();
      _register.endSale();
      _currentSale.becomeComplete();
      isSaleComplete= _currentSale.isComplete();
      assertTrue(isSaleComplete,"Sale ended Is Complete should be true");
    }

    @Test
    @DisplayName( "Should Enter a Sales Line Item at the Register ")
    void shouldEnterItemToSaleAtRegister() {
        _register.makeNewSale();
        _register.enterItem(_itemId,6);
    }

    @Test
    @DisplayName("Should Make a New Sales Object")
    void shouldMakeNewSale() {
        _register.makeNewSale();
        assertNotNull(_currentSale, "Sale should not be null");
        assertEquals("Sale", _currentSale.getClass().getSimpleName(),"Class Name should be Sale");
    }

    @Test
    @DisplayName ("Should Make a Payment with money Tendered")
    void makePayment() {
        _cash = new Money(17.50);
        _currentSale.makeLineItem(_desc, 0);
        _currentSale.becomeComplete();
        _currentSale.makePayment(_cash);
        Payment _pay = new Payment(_cash);
        assertNotNull(_pay,"Should not be Null");
        assertEquals(_cash,_pay.getAmount(),"Should be 17.50 payment");
    }

    @Test
    @DisplayName ("Should Get Total")
    void shouldGetTotal() {
        _register.makeNewSale();
        _currentSale.makeLineItem(_desc,6);
         _lineItem.getSubtotal();
        _currentSale.becomeComplete();
        Money _subTotal= new Money(17.25);
        Money _total = new Money(0.00);
        assertEquals(17.25, _total.add(_subTotal).getMoney().doubleValue(),"");
    }

    @Test
    void getBalance() {

    }
}