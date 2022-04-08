package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import posSystem.ItemID;
import posSystem.Money;
import posSystem.ProductDescription;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Product Description Specification")
class ProductDescriptionTest {

    private ItemID _id1;
    private int _item1 = 07245;
    private Money _price;
    private String _description;
    private ProductDescription _product;

    @BeforeEach
    void setUp() {

        _id1 = new ItemID( _item1 );
        _description ="GoGi Juice";
        _price = new Money(2.25 );
        _product = new ProductDescription(_id1, _price, _description);
    }

    @Test
    @DisplayName("Constructor Product Description with ItemID Price Description")
    void ConstructorProductDescriptionWithItemIDPriceDescription(){

        assertEquals(_id1, _product.getItemID(),"should be Product Id = "+_id1);
        assertEquals(2.25, _product.getPrice().getMoney().doubleValue(),"Should get Price = 2.25");
        assertEquals("GoGi Juice", _product.getDescription(), "Should be Description : GoGi Juice");
    }

    @DisplayName("Should get Item ID")
    @Test
    void getItemID() {
        assertEquals(_id1, _product.getItemID(), "should equals "+ _item1 );
    }

    @DisplayName("Should get Price")
    @Test
    void getPrice() {
        assertEquals(_price, _product.getPrice(), "should equals "+ _price);
    }

    @DisplayName("Should get Description")
    @Test
    void getDescription() {
        assertEquals(_description, _product.getDescription(),"Should equals "+ _description);
        assertNotNull(_description,"Should not be null");
    }

    @DisplayName("Price greater than 0")
    @Test
    void priceShouldBeGreaterThanZeroThrowException() throws IllegalArgumentException{
        Money none = new Money(0.00);
        if (new Money(0.00).equals(none)) {
            Throwable exception =
            assertThrows(IllegalArgumentException.class, ()->{
                throw new IllegalArgumentException("Money has to be greater than 0");
            });
            assertEquals("Exception message", exception.getMessage());
        }
    }
}