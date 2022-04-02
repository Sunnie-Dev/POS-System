import java.util.HashMap;
import java.util.Map;

public class ProductCatalog {

private Map<ItemID, ProductDescription> descriptions = new HashMap <ItemID, ProductDescription>();
	
	public ProductCatalog() 
	{
		// creates a project calendar
		// TODO Product Description cannot be blank
		//TODO ProductDescription must be unique
		//TODO ProductDescription Item ID must be unique 
		
		// sample data
		ItemID id1 = new ItemID( 100 );
		ItemID id2 = new ItemID( 200 );
		ItemID id3 = new ItemID( 300 );
		ItemID id4 = new ItemID( 400 );
		 Money price = new Money(0 );


		
		ProductDescription desc;
		desc = new ProductDescription( id1, price=new Money(1.60) , "Bananas 8" );
		descriptions.put( id1, desc );
		desc = new ProductDescription( id2, price = new Money(2.00), "Oat Bread" );
		descriptions.put( id2, desc );
		desc = new ProductDescription( id3, price=new Money(1.60) , "Apple Juice" );
		descriptions.put( id3, desc);
		desc = new ProductDescription( id4, price = new Money(6.75), "Fried Chicken" );
		descriptions.put( id4, desc );
	}
	
	public ProductDescription getProductDescription( ItemID id )
	{
		return descriptions.get( id );
	}

}
