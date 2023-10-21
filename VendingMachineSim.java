/** Academic Honesty Statement:
 * Assignment: Assignment 2:vending machine
 * Date: September 29, 2023
 * @author Elene sturua
 *I verify that I completed all of the codes myself and did not get help from anyone.
 */


import java.io.FileNotFoundException;

import java.util.Scanner;

/**
 * 
 * example of a vending machine including specific items and interacting with the user
 *
 */
public class VendingMachineSim {
/**
 * 
 * @param args
 * @throws FileNotFoundException
 */
    public static void main(String[] args) throws FileNotFoundException {
        boolean runSim = true;
        VendingMachine vendingMachine = new VendingMachine();
        Display display = new Display();
        

        // Remember to give some introduction to the simulation
        display.show("Welcome to the Soda Shack!!");
        display.show("Hang on while I get set up.");

        Scanner sc = new Scanner(System.in);
        String response = null;

        while (runSim) {
            display.show("Do you want to buy a beverage? (yes or no)");

            if (sc.hasNext())
                response = sc.nextLine();

            if (response.toLowerCase().equals("yes")) {
                vendingMachine.printChoices();
                display.show("Please enter the ID of your chosen beverage");
                String inputID = sc.nextLine();
                if (vendingMachine.isAvailable(inputID)) {
                    display.show("The price of your item is $" + vendingMachine.purchasePrice(inputID));

                    boolean paying = true;
                    double inserted = 0.0;

                    while (paying) {
                        display.show("Insert bill, quarter, dime, or nickel:");
                        response = sc.nextLine();

                        if (response.toLowerCase().equals("quarter")) {
                            vendingMachine.acceptQuarter();
                            inserted += 0.25;
                        } else if (response.toLowerCase().equals("dime")) {
                            vendingMachine.acceptDime();
                            inserted += 0.1;
                        } else if (response.toLowerCase().equals("nickel")) {
                            vendingMachine.acceptNickle();
                            inserted += 0.05;
                        } else if (response.toLowerCase().equals("bill")) {
                            vendingMachine.acceptBill();
                            inserted++;
                        } else {
                            display.error("Invalid payment method. Please enter quarter, dime, nickel, or bill.");
                        }

                        if (inserted >= vendingMachine.purchasePrice(inputID)) {
                            display.sold();
                            if (inserted > vendingMachine.purchasePrice(inputID)) {
                                display.show("Your change is: " + (inserted - vendingMachine.purchasePrice(inputID)));
                                vendingMachine.makeChange(inserted - vendingMachine.purchasePrice(inputID));
                            }
                            paying = false;
                        }
                    }
                } else {
                    display.soldOut();
                }
            } else {
                runSim = false;
                display.show("Thank you for visiting the Soda Shack!");
            }
        }
        sc.close();
    }//main
}//end class



