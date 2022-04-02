
import java.math.BigDecimal;
import java.math.MathContext;
// Author : Casey Munga : 03/29/2022
// Reason: Project required money but there was no given class POS SYSTEM

public class Money {

	private BigDecimal money;
	private final String currency = "USD";
	
	// Precision
	MathContext precision = new MathContext(8);
	
	public Money() {
		
		this.money=null;
		
	}
	
	public Money(BigDecimal multiply, MathContext precision2) {
		// TODO Auto-generated constructor stub
	}

	public Money(int cash) {
		// TODO  cash cannot be zero 
		// TODO cashe cannot be negative
		this.money = BigDecimal.valueOf((double)cash );
		this.money.abs(precision);
	}

	public Money(double cash){
		//TODO _money money cannot be 0.00
		//TODO _money cannot be negative
		this.money = BigDecimal.valueOf(cash);
		this.money.abs(precision);
		
	}

	public Money times(int _quantity) {
		// TODO Auto-generated method stub
		//TODO _money money cannot be 0.00
		//TODO _money cannot be negative
		return new Money(this.money.multiply(BigDecimal.valueOf(_quantity)),precision);
	}

	public Money add(Money _subtotal) {
		// TODO Auto-generated method stub
		//TODO _money money cannot be 0.00
				//TODO _money cannot be negative
		return new Money(this.money.add(_subtotal.money), precision);
}

	public Money minus(Money total) {
		// TODO Auto-generated method stub
		//TODO _money money cannot be 0.00
		//TODO _money cannot be negative
		return new Money(this.money.subtract(total.money), precision);
	}


}
