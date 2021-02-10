/**
 * SweetsBasket class extends Gift class and contains 1 instance attribute that
 * is specific to a Sweets basket, indicating whether the basket has nuts.
 * SweetsBasket subclass inherits the calculate price method from the superclass
 * so there is no override method included.
 * SweetsBasket contains its own display method that overrides the superclass'.
 *  
 * File: SweetsBasket.java
 * Course: CMIS 242/6382
 * @author Olivia-Mei McDowell
 * @version 2020-09 (4.17.0)
 * Date: 2-08-2021
 * IDE: Eclipse
 */

// import required Java classes
import java.text.DecimalFormat;

public class SweetsBasket extends Gift {
	
	// Instance variables
	private boolean hasNuts;
	// decimal format info source - https://www.codota.com/code/java/methods/java.text.DecimalFormat/format
	private static DecimalFormat df = new DecimalFormat("#.##"); // use DecimalFormat class to customize print format

	// Constructor
	public SweetsBasket(String id, char size, boolean hasNuts) {
		super(id, size);
		this.hasNuts = hasNuts;
	}
	
	// Default constructor
	public SweetsBasket(String id, char size) {
		super(id, size);
		this.hasNuts = false;
	}
	
	// Getter method
	public boolean getHasNuts() {
		return hasNuts;
	}
	
	// Setter method
	public void setHasNuts(boolean hasNuts) {
		this.hasNuts = hasNuts;
	}
	
	// Inherits calculate price method and calculation is not different so should not override
	
	/** Displays all gift basket information that is specific to sweets basket instances. */
	@Override
	public String toString() { // override display method declared in Gift superclass
		return "SweetsBasket [hasNuts = " + getHasNuts() + "\tsize = " + Character.toUpperCase(getSize()) 
				+ "\tid = " + getId() + "\tprice = $" + df.format(calculatePrice(getSize())) + "]";
	}

}
