package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import posSystem.ItemID;
import posSystem.Money;
import posSystem.ProductDescription;
import posSystem.SalesLineItem;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Sales Line Item Specification")
public class SalesLineItemTest {
private SalesLineItem _lineItem;
private ProductDescription _product;
private Money _cost, _subtotal;
private ItemID _item;

    @BeforeEach
    void setUp(){
        _cost = new Money(5);
        _item = new ItemID( 100 );
        _product = new ProductDescription(_item, _cost,"Apples");
        _lineItem = new SalesLineItem( _product, 6);
    }

    @Test
    @DisplayName("Constructor Sales Line Item with ProductDescription and Quantity")
    void checkConstructorSalesLineItemProductQuantity(){
        assertEquals("SalesLineItem", _lineItem.getClass().getSimpleName(), "Should be Constructor "+_lineItem.getClass().getSimpleName());
    }



    @Test
    @DisplayName("Should Get Subtotal After Each Line Item")
    void shouldGetSubtotalAfterEachLineItem() {
      _subtotal = new Money(30);
      // get the subtotal and
      assertEquals(_subtotal.getMoney(), _lineItem.getSubtotal().getMoney()," sales line item should equals "+ _subtotal);

    }

}