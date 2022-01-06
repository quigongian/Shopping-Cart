/**
  * This program will display my ability to work within classes, cases, array lists, and loops. The purpose
 * of the program will be to create a shopping cart for the user providing the user with the ability to navigate through
 * menus, see total costs, item descriptions, etc.
 */
import java.util.Scanner;

public class ShoppingCartManager {


    /*
    In our main method we will be declaring and initializing variables such as customer names and the date of the
    shopping list. The purpose of this is to set up the beginning and introduction of the customer menu. The two string
    variables will then initialize into our ShoppingCart class as customerName and todaysDate, the same way it is written
    in our main method.
     */
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String customerName;
        String todaysDate;
        char menuChoice = ' ';

        System.out.println("Enter Customer's Name:");
        customerName = scnr.nextLine();

        System.out.println("Enter Today's Date:");
        todaysDate = scnr.nextLine();

        System.out.println("\nCustomer Name: " + customerName);
        System.out.println("Today's Date: " + todaysDate);
        System.out.println("");

        ShoppingCart myCart = new ShoppingCart(customerName, todaysDate);

        printMenu();

        while (menuChoice != 'q') {
            System.out.println("Choose an option:");
            menuChoice = scnr.next().charAt(0);
            executeMenu(menuChoice, myCart, scnr);
            printMenu();
        }
        System.out.println("Thanks for shopping with us.  Please come again.");

    }

    /*
    Our printMenu class will set up the visuals of how the menu will be printed on screen.
     */
    public static void printMenu() {
        System.out.println("MENU");
        System.out.println("a - Add item to cart");
        System.out.println("d - Remove item from cart");
        System.out.println("c - Change item quantity");
        System.out.println("i - Output items' descriptions");
        System.out.println("o - Output shopping cart");
        System.out.println( "q - Quit");
        System.out.println("");
    }

    /*
    Our executeMenu class will use cases to help the user navigate to different options within the menu. Shortly after,
    the user will be able to reply with input that will be scanned and initialized into local variable's setup within
    the method that will furthermore be initialized into class variables from the ItemToPurchase class.
     */
    public static void executeMenu(char option, ShoppingCart theCart, Scanner scnr) {
        String productName;
        String productDescription;
        double productPrice = 0;
        int productQuantity = 0;

        switch (option) {
            case 'a':
                scnr.nextLine();
                System.out.println("ADD ITEM TO CART");
                System.out.println("Enter the item name:");
                productName = scnr.nextLine();

                System.out.println("Enter the item description:");
                productDescription = scnr.nextLine();

                System.out.println("Enter the item price:");
                productPrice= scnr.nextDouble();

                System.out.println("Enter the item quantity:");
                productQuantity = scnr.nextInt();

                ItemToPurchase newItem = new ItemToPurchase(productName, productPrice, productQuantity, productDescription);
                theCart.addItem(newItem);

                System.out.println("");
                break;

            case 'd':
                scnr.nextLine();

                System.out.println("REMOVE ITEM FROM CART");
                System.out.println("Enter name of item to remove:");
                productName = scnr.nextLine();

                theCart.removeItem(productName);
                System.out.println("");
                break;

            case 'c':
                scnr.nextLine();

                System.out.println("CHANGE ITEM QUANTITY");
                System.out.println("Enter the item name:");
                productName = scnr.nextLine();

                System.out.println("Enter the new quantity:");
                productQuantity = scnr.nextInt();

                ItemToPurchase modItem = new ItemToPurchase();
                modItem.setItemName(productName);
                modItem.setItemQuantity(productQuantity);

                theCart.modifyItem(modItem);
                System.out.println("");
                break;

            case 'i':
                System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
                theCart.printDescriptions();
                System.out.println("");
                break;

            case 'o':
                System.out.println("OUTPUT SHOPPING CART");
                theCart.printTotal();
                System.out.println("");
                break;
        }

    }



}