/**
 * FruitBasket class extends Gift class and contains 2 specific instance attributes:
 * (1) indicates whether the basket has citrus fruits
 * (2) indicates the number of fruits the basket contains
 * SweetBasket subclass only inherits the ID and size variables from the Gift superclass.
 * The SweetBasket has its own calculate price method that overrides the superclass'.
 *  
 * File: FruitBasket.java
 * Course: CMIS 242/6382
 * @author Olivia-Mei McDowell
 * @version 2020-09 (4.17.0)
 * Date: 2-08-2021
 * IDE: Eclipse
 */

// import required Java classes
import java.text.DecimalFormat;

public class FruitBasket extends Gift {
	
	// Member attributes
	private int numFruits;
	private boolean hasCitrusFruits;
	// decimal format info source - https://www.codota.com/code/java/methods/java.text.DecimalFormat/format
	private static DecimalFormat df = new DecimalFormat("#.##"); // use DecimalFormat class to customize print format

	// Constructor
	public FruitBasket(String id, char size, boolean hasCitrusFruits) {
		super(id, size);
		this.hasCitrusFruits = hasCitrusFruits;
	}
	
	// Default constructor
	public FruitBasket(String id, char size) {
		super(id, size);
		this.hasCitrusFruits = false;
	}
	
	// no set method for fruit count since it cannot be changed after creation
	
	public int getNumFruits() {
		return numFruits;
	}
	
	public boolean getHasCitrusFruits() {
		return hasCitrusFruits;
	}
	
	public void setHasCitrusFruits(boolean hasCitrusFruits) {
		this.hasCitrusFruits = hasCitrusFruits;
	}
	
	protected int calculateNumFruits(char size) {
		switch(size) {
			case 's':
				numFruits = 6;
				break;	
			case 'm':
				numFruits = 9;
				break;
			case 'l':
				numFruits = 15;
				break;
		}
		return numFruits;
	}
	
	/**
	 * Method that calculates basket price based on basket size passed.
	 * 
	 * @param size	the basket size translated from user input.
	 * @return price the price that corresponds with the current basket's size.
	 */
	@Override
	public double calculatePrice(char size) { // override superclass calculate price method
		double price = super.calculatePrice(size);
		if(hasCitrusFruits == true)
			price = super.calculatePrice(size) + 5.99;  // add $5.99 citrus fruit fee
		return price;
	}
	
	/** Displays all gift basket information that is specific to fruit basket instances. */
	@Override
	public String toString() { // override display method declared in Gift superclass
		return "FruitBasket [numFruits = " + numFruits + "\thasCitrus = " + getHasCitrusFruits() 
				+ "\tsize = " + Character.toUpperCase(getSize()) + "\tid = " + getId() + "\tprice = $" + df.format(calculatePrice(getSize())) + "]";
	}

}
