//TODO: Make a shopping program which shows the bill of the customer

import java.util.Scanner;

public class ShoppingProgram {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] itemNames = {"Pen", "Pencil", "Eraser", "Notebook", "Milk", "Chess Board", "UNO Set", "Bottle", "Cheesecake"};
        int[] itemPrices = {2, 1, 1, 5, 3, 15, 10, 8, 12};
        int totalBill = 0;
        int choice;

        System.out.println("Welcome to the Shopping Program!");

        do {
            System.out.println("\nChoose what you want to buy by entering the number:");
            for (int i = 0; i < itemNames.length; i++) {
                System.out.println((i + 1) + ". " + itemNames[i] + " - $" + itemPrices[i]);
            }
            System.out.println("0. Checkout");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            if (choice > 0 && choice <= itemNames.length) {
                int itemIndex = choice - 1;
                System.out.print("How many " + itemNames[itemIndex] + "s do you want? ");
                int quantity = scanner.nextInt();

                if (quantity > 0) {
                    int itemCost = itemPrices[itemIndex] * quantity;
                    totalBill += itemCost;
                    System.out.println("Added " + quantity + " " + itemNames[itemIndex] + "s to your cart. Cost: $" + itemCost);
                } else {
                    System.out.println("Invalid quantity. Please enter a positive number.");
                }
            } else if (choice == 0) {
                System.out.println("Thank you for shopping with us!");
            } else {
                System.out.println("Invalid choice! Please select a valid item.");
            }
        } while (choice != 0);

        System.out.println("Your final bill is: $" + totalBill);
        scanner.close();
    }
}
