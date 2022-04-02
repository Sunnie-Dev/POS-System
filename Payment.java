public class Payment
{
	private Money amount;
	
	public Payment( Money cashTendered )
	{
		// TODO cash tendered  cannot be negative or 0.00
		amount = cashTendered;
	}
	
	public Money getAmount() { 

		// TODO amount  cannot be negative or 0.00
	
		return amount; 
	}

}