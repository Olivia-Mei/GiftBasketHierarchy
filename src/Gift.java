/**
 * Gift class is the super class that provides the ID and size variables, as well as
 * the calculate price and display methods that are the foundation of gift objects.
 * 
 * File: Gift.java
 * Course: CMIS 242/6382
 * @author  Olivia-Mei McDowell
 * @version 2020-09 (4.17.0)
 * Date: 2-08-2021
 * IDE: Eclipse
 */

// import required Java classes
import java.security.SecureRandom;
import java.text.DecimalFormat;

public class Gift {
	
	// Member attributes
	private String id;
	private String randomId;
	private char size;
	private double price;
	// decimal format info source - https://www.codota.com/code/java/methods/java.text.DecimalFormat/format
	private static DecimalFormat df = new DecimalFormat("#.##"); // use DecimalFormat class to customize print format
	static final String validSymbols = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static SecureRandom rnd = new SecureRandom();

	// Constructor
	public Gift(String id, char size) {
		this.id = id;
		this.size = size;
	}
	
	// Default constructor
	public Gift() {
		this.id = generateId(8);
		this.size = '\u0000'; // the null character
	}
	
	// Getter methods
	public String getId() {
		return id;
	}
	
	public char getSize() {
		return size;
	}
	
	public double getPrice() {
		return price;
	}
	
	// Set method - size is the only attribute that can change in the Gift superclass
	public void setSize(char size) {
		this.size = size;
	}
	
	/**
	 * Method that generates a random alpha-numerical string of the given length.
	 * 
	 * @param length	the desired character length of random string to be generated.
	 * @return randomId the alpha-numerical string that represents the gift ID.
	 */
	public String generateId(int length) {
		// source for random string generation info - https://www.geeksforgeeks.org/generate-random-string-of-given-size-in-java/
		StringBuilder sb = new StringBuilder(length);
		for(int i = 0; i < length; i++)
			sb.append(validSymbols.charAt(rnd.nextInt(validSymbols.length()))); // append number of alphanumeric characters defined by parameter length
		randomId = sb.toString();
		return randomId;
	}
	
	/**
	 * Method that calculates basket price based on basket size passed.
	 * 
	 * @param size	the basket size translated from user input.
	 * @return price the price that corresponds with the current basket's size.
	 */
	public double calculatePrice(char size) {
		switch(size) {
			case 's': 
				price = 19.99;
				break;
			case 'm': 
				price = 29.99;
				break;
			case 'l': 
				price = 39.99;
				break;
		}
		return price;
	}
	
	/** Displays all gift basket information that corresponds with that instance. */
	public String toString() {
		return "GiftBasket [size = " + Character.toUpperCase(getSize()) + "\tid = " + getId() + "\tprice = $" + df.format(calculatePrice(size)) + "]";
	}
}
