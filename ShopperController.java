
public class ShopperController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//create store -generates a product catalog -> new itemID, New Money, description
		Store s573 = new Store();  // create store
		Register CarlieReg_32 = s573.getRegister(); //get a register
		CarlieReg_32.makeNewSale(); // Make a new sale
		CarlieReg_32.enterItem(new ItemID(200), 6); // scan shopper items
		CarlieReg_32.enterItem(new ItemID(400), 1);
		CarlieReg_32.endSale(); // last item so sale is completed
		Money CashOwed = new Money(); // 
		CashOwed = CarlieReg_32.getTotal();  // get the total amount owed
		CarlieReg_32.makePayment(new Money(100)); // shopper gives payment
		CarlieReg_32.getBalance();
	}

}
