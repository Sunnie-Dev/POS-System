
public class ItemID{
  private int id;
  private int manufacturerCode;
  private int countryCode;
  
	public ItemID(int id) {
		// TODO itemID cannot be Zero
		// TODO itemID cannot be negative
		this.id = id;
	}

	public int getManufacturerCode() {
		return manufacturerCode;
	}

	public void setManufacturerCode(int manufacturerCode) {
		// TODO Manufacturing code cannot be negative
		// TODO Manufacturing code cannot be zero
		this.manufacturerCode = manufacturerCode;
	}

	public int getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(int countryCode) {
		// country code cannot be zero
		//country code cannot be negative
		// country code cannot be greater than 250
		this.countryCode = countryCode;
	}

}
