# Gift Basket Order System

## Introduction
This gift basket application implements an order management system, allowing users to order different types of gift baskets, update their order, and display their order. Handles invalid user input and illogical menu selections.

+ Gift class is the super class that provides the ID and size variables, as well as the calculate price and display methods that are the foundation of gift objects.

+ FruitBasket class extends Gift class and contains 2 specific instance attributes:
    1. indicates whether the basket has citrus fruits
    2. indicates the number of fruits the basket contains

    * FruitBasket subclass only inherits the ID and size variables from the Gift superclass.
    * The FruitBasket has its own calculate price method that overrides the superclass'.

+ SweetsBasket class extends Gift class and contains 1 instance attribute that is specific to a Sweets basket, indicating whether the basket has nuts.
    + SweetsBasket subclass inherits the calculate price method from the superclass so there is no override method included.
    + SweetsBasket contains its own display method that overrides the superclass'.

+ OrderSystem class is the driver class, which contains methods with the following functionality: 
    1. Order a gift
    2. Change a gift
    3. Display gift
    4. Exit program
    * The main method implements this functionality using the menu and input processing system.

---
## Technologies
Java  version 2020-09 (4.17.0)

---
## Install & Setup
To run this project, install the following files locally, as you would normally install a new Java project.
1. Gift.java
2. FruitBasket.java
3. SweetsBasket.java
4. OrderSystem.java

---
## Guidelines
1. Install the four files (listed in install section) locally
2. Compile all files from the command line
3. Run OrderSystem.java from the command line and proceed as user, following on-screen prompts

---
## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

---
## To-Do
1. Create method to get basket size from user (currently hard-coded)
2. Add functionality to be able to handle multiple gift orders

---
## Roadmap
1. Build out custom checkout

---
## Project Status
Active development paused

