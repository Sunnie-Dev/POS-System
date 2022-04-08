package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import posSystem.ItemID;
import posSystem.Money;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName(" Item Specification")
class ItemIDTest {
    private int _item;
    private int _item0;
    private int _manufacturer;
    private int _country ;
    private ItemID _itemId;
    private Money _cash;
    private String _description;

    @BeforeEach
    void setup(){
        _item = 100;
        _manufacturer = 1000;
        _country = 250;
        _item0 = 0;
     }

    @Test
    @DisplayName("Constructor Class Test itemId")
    void constructorClassItemID(){
        _itemId = new ItemID(_item);
        assertEquals(100,_itemId.getItemId(),"should Return Item Id "+_itemId);
    }

    @Test
    @DisplayName("Constructor Class Test ItemId and Manufacturer Code")
    void constructorClassItemIDManufacturer(){
        _itemId= new ItemID(_item,_manufacturer);
        assertEquals(100, _itemId.getItemId()," should return Item Id "+_itemId);
        assertEquals(1000, _itemId.getManufacturerCode()," should return Item Id "+ _manufacturer);
    }
    @Test
    @DisplayName("Constructor Class Test ItemId and Manufacturer Code and Country Code")
    void constructorClassItemIDManufacturerCountryCode(){
        _itemId= new ItemID(_item,_manufacturer,_country);
        assertEquals(100, _itemId.getItemId()," should return Item Id "+_itemId);
        assertEquals(1000, _itemId.getManufacturerCode()," should return Item Id "+ _manufacturer);
        assertEquals(250,_itemId.getCountryCode(),"Should return Country Code");
    }

    @Test
    @DisplayName("Throws Exception when Item ID is Zero or less")
    void shouldThrowExceptionWhenItemIDisZeroOrLess()  {

        if (_item <= 0) {
            Throwable exception;
            exception = assertThrows(IllegalArgumentException.class, () -> {
                ItemID item = new ItemID(_item0);
            });
            assertEquals("Item ID cannot be zero or less", exception.getMessage());
        }
    }


    @Test
    @DisplayName(" Should Get Manufactured Code given the ItemID")
    void getManufacturerCodeGivenItemID() {
        ItemID item = new ItemID(_item,_manufacturer);
        assertEquals(_manufacturer,item.getManufacturerCode(),"Should get manufactures code "+_manufacturer);
    }

    @Test
    @DisplayName("Throws Exception When Manufacture Code is Zero or less")
    void shouldThrowExceptionWhenManufactureIsZeroOrLess() {

        if (_manufacturer <= 0) {
            Throwable exception;
            exception = assertThrows(IllegalArgumentException.class, () -> {
                ItemID item = new ItemID(_item0,_manufacturer);
            });
            assertEquals("Manufacture code cannot be zero or less", exception.getMessage());
        }
    }



    @Test
    @DisplayName("Should set the Manufacturer Code Given Item ID")
    void setManufacturerCodeGivenItemID() {
        ItemID item = new ItemID(_item);
        item.setManufacturerCode(_manufacturer);
        assertEquals(_manufacturer,item.getManufacturerCode(),"should equal "+ _manufacturer);
    }

    @DisplayName ("Should get the Country Code given Item ID")
    @Test
    void getCountryCodeGivenItemID() {
        ItemID item = new ItemID(_item,_manufacturer,_country);
        assertEquals(_country,item.getCountryCode(),"Should equal "+ _country);

    }

    @Test
    @DisplayName("Throws Exception when Item ID is Zero or less")
    void shouldThrowExceptionWhenCountryCodeisZeroOrLess() throws IllegalArgumentException{

        if (_country <= 0) {
            Throwable exception;
            exception = assertThrows(IllegalArgumentException.class, () -> {
                ItemID item = new ItemID(_item0,_manufacturer,_country);
            });
            assertEquals("Item ID cannot be zero or less", exception.getMessage());
        }
    }

}