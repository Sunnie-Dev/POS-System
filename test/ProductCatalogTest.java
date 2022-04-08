package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import posSystem.ItemID;
import posSystem.Money;
import posSystem.ProductCatalog;
import posSystem.ProductDescription;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Product Catalog Specification")
class ProductCatalogTest {
    private Map<ItemID, ProductDescription> _descriptions;
    private ItemID _id1, _id2, _id3, _id4;
    private int _item1 = 100, _item2 = 200, _item3 = 300, _item4 = 400;
    private Money _price, _priceInt, _priceDouble, _priceBig, _priceNeg;
    private ProductDescription _itemDesc;
    private String _desc;
    private ProductCatalog _catalog;

    @BeforeEach
    void setUp() {
        _descriptions = new HashMap<ItemID, ProductDescription>();
        _id1 = new ItemID(_item1);
        _id2 = new ItemID(_item2);
        _id3 = new ItemID(_item3);
        _id4 = new ItemID(_item4);
        _price = new Money(0);
        _desc = "French Bread - 1 loaf";
        _priceDouble = new Money(1.60);
        _priceBig = new Money(6.6894);
        _priceInt = new Money(5);
        _descriptions.put(_id1, new ProductDescription(_id1, _priceDouble ,"Bananas - 1 lb"));
        _descriptions.put(_id2, new ProductDescription(_id2, _priceInt ,"French Bread - 1 loaf"));
        _descriptions.put(_id3, new ProductDescription(_id3, _priceBig ,"Apple Juice - 500 ml"));
        _descriptions.put(_id4, new ProductDescription(_id4, _priceDouble ,"Fried Chicken -  8 pc"));
        _catalog = new ProductCatalog();
       // _priceNeg = new Money(cash -0.25); ItemId Class will not allow a negative price as there is an abs() function

    }

        @Test
        @DisplayName(" Should Get Products Description By Item ID")
        void  shouldGetProductDescriptionByItemID() {

          //  assertEquals(_descriptions.get(_id2).getItemID(), _catalog.getProductDescription(_id2).getItemID(),"Item ID Should equals "+_descriptions.get(_id2).getItemID());
            assertEquals( _item1, _catalog.getProductDescription(_id1).getItemID().getItemId(),"Item ID should be " +_item1);
            assertEquals(_priceDouble, _catalog.getProductDescription(_id1).getPrice(), "Price should be "+_priceDouble);
            assertEquals(_desc,_catalog.getProductDescription(_id1).getDescription(),"Description Should be ");
            assertNull(_catalog.getProductDescription(_id1), "Should be null Product Description");

        }

}