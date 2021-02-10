/**
 * OrderSystem class contains methods with the following functionality: 
 * Order a gift
 * Change a gift
 * Display gift
 * The main method implements this functionality using the menu and input processing system.
 * 
 * File: OrderSystem.java
 * Course: CMIS 242/6382
 * @author  Olivia-Mei McDowell
 * @version 2020-09 (4.17.0)
 * Date: 2-08-2021
 * IDE: Eclipse
 */

// import required Java classes
import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderSystem {
	
	private Gift currentGift; // instance of gift
	private FruitBasket currentFruitBasket; // variable to hold current fruit basket object
	private SweetsBasket currentSweetsBasket; // variable to hold current sweets basket object
	
	// Constructor
	public OrderSystem() {
		currentGift = new Gift();
	}
	
	// Getter method
	public Gift getCurrentGift() {
		return currentGift;
	}
	
	/** Method that displays the menu of functionality options. */
	public void displayMenu() {
		System.out.println("\n MENU");
		System.out.println("1: Order a Gift Basket ");
		System.out.println("2: Change Gift Basket ");
		System.out.println("3: Display Gift ");
		System.out.println("9: Exit program");
	}
	
	/** Method that creates a gift object. User input determines which sub-class the object is a member of. */
	public void orderGift() {
		
		Scanner stdin = new Scanner(System.in); // declare standard input variable
		boolean invalidInput; // variable that stores indicator of invalid user input
		int basketSelection; 
		char size;
		
		do { // prompt user for basket type selection
			basketSelection = 0; // initialize and reset user's basket selection
			invalidInput = false; // reset valid input indicator
			
			System.out.print("\nDo you want Fruit Basket (1) or Sweets Basket (2)?: ");
			
			try {
				basketSelection = stdin.nextInt(); // assign user input value to basket selection variable
			} catch(InputMismatchException e) { // handle non-integer user input
				System.out.println("\n*INVALID INPUT* Selection must be integer 1 or 2.\n"
									+ "Returning to main menu...");
				invalidInput = true;
				return; // done so return from method
			}
			
			if(basketSelection !=1 && basketSelection !=2) { // handle user input that is outside option range
				System.out.println("\n*INVALID INPUT* Basket selection must match one of the integer options.");
				invalidInput = true;
				return; // done so return from method
			}
	
		} while(invalidInput !=false && (basketSelection !=1 && basketSelection !=2));
			
		do { // prompt user for basket size
			
			invalidInput = false; // reset valid input indicator
			System.out.print("What size do you want? S, M, or L: ");
			String sizeSelection = stdin.next(); // assign user input value to size selection variable
			
			try {
				size = sizeSelection.toLowerCase().trim().charAt(0);
			} catch(InputMismatchException e) { // handle non-char input
				System.out.println("\n*INVALID INPUT* Selection must be S, M or L.\n"
									+ "Returning to main menu...");
				invalidInput = true;
				return; // done so return from method
			}
			switch(size) { // set size based on user input
				case 's':
					currentGift.setSize('S');
					break;	
				case 'm':
					currentGift.setSize('M');
					break;
				case 'l':
					currentGift.setSize('L');
					break;
				default:
					System.out.println("\n*INVALID INPUT* Input must be one of the options (S, M, or L)\n");
					invalidInput = true;
			}
		} while(invalidInput !=false);
		

		if (basketSelection == 1) { // begin fruit basket scenario
			String currentId = currentGift.generateId(8); // generate random ID
			FruitBasket myFruitBasket = new FruitBasket(currentId, size);
			myFruitBasket.calculateNumFruits(size);
			
			do { // prompt user for citrus selection
				invalidInput = false; // reset valid input indicator
				System.out.print("Do you want citrus fruits included (true/false)?: ");
			
				String citrusSelection = stdin.next();
				citrusSelection = citrusSelection.toLowerCase().trim();
				
				switch(citrusSelection) { // set has citrus fruits status based on user input
					case "true":
						myFruitBasket.setHasCitrusFruits(true);
						break;	
					case "false":
						myFruitBasket.setHasCitrusFruits(false);
						break;
					default:
						System.out.println("\n*INVALID INPUT* Input must be 'true' or 'false'\n");
						invalidInput = true;
				}
			} while(invalidInput !=false);
			
				currentGift = myFruitBasket; // set current gift object to reference current fruit basket object
				
		} // end fruit basket scenario
			
		else if (basketSelection == 2) { // begin sweets basket scenario
			String currentId = currentGift.generateId(8); // generate random ID
			SweetsBasket mySweetsBasket = new SweetsBasket(currentId, size); // constructs SweetsBasket
			
			do { // prompt user for nut selection
				System.out.print("Do you want nuts included (true/false)?: ");
				
				String nutSelection = stdin.next();
				nutSelection = nutSelection.toLowerCase().trim();
				
				switch(nutSelection) { // set has nuts based on user input
					case "true":
						mySweetsBasket.setHasNuts(true);
						break;	
					case "false":
						mySweetsBasket.setHasNuts(false);
						break;
					default:
						invalidInput = true;
						System.out.println("\n*INVALID INPUT* Input must be 'true' or 'false'");
				}
			} while(invalidInput !=false);
			
			currentGift = mySweetsBasket; // set current gift object to reference current sweets basket object 
			
		} // end sweets basket scenario
		
		
		else { // display error message if input is anything other than 1 or 2
			System.out.println("\n*INVALID INPUT* Basket selection must match one of the integer options.");
			invalidInput = true;
		}
		
		currentGift.calculatePrice(size); // calculate price of current gift basket

		System.out.println("\nThe following gift has been created: \n" + currentGift);	// confirms gift object created
	} // end order gift method
	
	/** Method that updates the current gift object. User input determines the updated size and basket content values. */
	public void changeGift() {
		
		Scanner stdin = new Scanner(System.in);
		boolean invalidInput; // variable that indicates if user input was invalid
		int basketSelection; // declare standard input variable
		char size;
		
		if(currentGift.getSize() == '\u0000') // if size char is null, display error message
			System.out.println("\n*REQUEST FAILED* No gift has been ordered yet...");
		else {
			do { // prompt user for desired change in basket size
				
				invalidInput = false; // reset validation checker
				System.out.print("Current gift size is: " + Character.toUpperCase(currentGift.getSize()) 
									+ " ... What size do you want? S, M, or L: ");
				String sizeSelection = stdin.next();
				
				try {
					size = sizeSelection.toLowerCase().trim().charAt(0);
				} catch(InputMismatchException e) { // handle non char input
					System.out.println("\n*INVALID INPUT* Selection must be S, M or L.\n"
										+ "Returning to main menu...");
					invalidInput = true;
					return; // done so return from method
				}
				switch(size) { // update size based on new user input
					case 's':
						currentGift.setSize('S');
						break;	
					case 'm':
						currentGift.setSize('M');
						break;
					case 'l':
						currentGift.setSize('L');
						break;
					default:
						System.out.println("\n*INVALID INPUT* Input must be one of the options (S, M, or L)");
						invalidInput = true;
				}
			} while(invalidInput !=false);
		
		
			if (currentGift instanceof FruitBasket) { // begin change fruit basket scenario
				currentFruitBasket = (FruitBasket)currentGift;
				currentFruitBasket.calculateNumFruits(size);
				
				do { // prompt user for citrus selection
					invalidInput = false; // reset validation checker
					System.out.print("Current basket citrus = " + currentFruitBasket.getHasCitrusFruits() 
										+ " ... Do you want citrus fruits included? true/false: ");;
				
					String citrusSelection = stdin.next();
					citrusSelection = citrusSelection.toLowerCase().trim();
					
					switch(citrusSelection) {
						case "true":
							currentFruitBasket.setHasCitrusFruits(true);
							break;	
						case "false":
							currentFruitBasket.setHasCitrusFruits(false);
							break;
						default:
							System.out.println("\n*INVALID INPUT* Input must be 'true' or 'false'");
							invalidInput = true;
					}
				} while(invalidInput !=false);
				currentGift = currentFruitBasket;
				currentGift.calculatePrice(size);
		} // end change fruit basket scenario
		
		
		if (currentGift instanceof SweetsBasket) { // begin change sweets basket scenario
			currentSweetsBasket = (SweetsBasket)currentGift;
			
			do { // prompt user for nut selection
				System.out.print("Current basket nuts = " + currentSweetsBasket.getHasNuts()
									+ " ... Do you want nuts included (true/false)?: ");
				
				String nutSelection = stdin.next();
				nutSelection = nutSelection.toLowerCase().trim();
				
				switch(nutSelection) {
					case "true":
						currentSweetsBasket.setHasNuts(true);
						break;	
					case "false":
						currentSweetsBasket.setHasNuts(false);
						break;
					default:
						invalidInput = true;
						System.out.println("\n*INVALID INPUT* Input must be 'true' or 'false'");
				}
			} while(invalidInput !=false);
			
			currentGift = currentSweetsBasket;
			currentGift.calculatePrice(size);
		} // end change sweets basket scenario
		
		System.out.println("Updated Gift: " + currentGift);
		
		}
	} // end changeGift method
	
	/** Method that displays the current gift object, contingent upon gift object being complete with values. */
	public void displayGift() {
		// display error message if user tries to display gift info before a complete gift object has been created
		if(currentGift.getSize() == '\u0000') // if size char is null, display error message
			System.out.println("\n*REQUEST FAILED* No gift has been ordered yet...");
		else
			System.out.println(currentGift.toString()); // reference toString method of appropriate instance
	}
	
	
	/** Exits program and displays goodbye message. */
	public void exitProgram() {
		System.out.println("\n**** Thank you for using the Order System Program *****\n" +
										"\t\t**** GOODBYE *****");
		System.exit(1);
	}
				
	/**
	 * Method that processes user's menu selection and executes corresponding method.
	 * @param selection	the menu selection entered by user
	 */
	public void processMenuSelection(int selection) {
		
		switch(selection) {
			case 1:
				this.orderGift();
				break;
			case 2:
				this.changeGift();
				break;
			case 3:
				this.displayGift();
				break;
			case 9:
				this.exitProgram();
			default:
				System.out.println("\nMenu selection not found - Returning to main menu...");
		} // end switch
	} // end menu selection method
	
	/** Main method that demos the order system class, which references the Gift super class and its subclasses. */
	public static void main(String[] args) {
		
		System.out.println("* Author: Olivia-Mei McDowell\n"
				+ "* Course: CMIS 242/6382\n"
				+ "* Date: 2-08-2021\n");
		System.out.println("\n**** WELCOME TO THE GIFT BASKET ORDER SYSTEM *****");
		
		OrderSystem testOrderSystem = new OrderSystem(); // new instance
		Scanner stdin = new Scanner(System.in);
		int selection= 0;
		
		do{ // continuously displays menu and prompts user for desired selection until 9 is entered
			testOrderSystem.displayMenu();
			
			System.out.print("\nEnter your selection (ex. 1, 2, etc.): ");
			String selectionString = stdin.nextLine();
			
			try { // use try-catch to throw exception and handle non-integer user input
				selection = Integer.parseInt(selectionString);
			} catch(NumberFormatException e) {
				System.out.print("\n*INVALID INPUT* Input must be one of the integer options.");
			}
			
			testOrderSystem.processMenuSelection(selection);
			
		} while(selection!= 9); // do-while condition, loop until 9 is entered
		
		stdin.close(); // close scanner
	}
}
