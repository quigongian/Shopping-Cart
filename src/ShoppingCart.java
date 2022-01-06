import java.util.ArrayList;

    public class ShoppingCart {
        private String customerName;
        private String currentDate;
        private ArrayList<ItemToPurchase> cartItems;

        public ShoppingCart() {
            this.customerName = "none";
            this.currentDate = "January 1, 2022";
            this.cartItems = new ArrayList<ItemToPurchase>();
        }

        public ShoppingCart(String customerName, String currentDate) {
            this.customerName = customerName;
            this.currentDate = currentDate;
            this.cartItems = new ArrayList<ItemToPurchase>();
        }

        String getCustomerName() {
            return this.customerName;
        }

        public String getDate() {
            return this.currentDate;
        }

        public double getCostOfCart() {
            double totalCost = 0.00;
            for (int i = 0; i < cartItems.size(); i++) {
                totalCost += cartItems.get(i).getItemPrice() * cartItems.get(i).getItemQuantity();
            }
            return totalCost;
        }

        public void addItem(ItemToPurchase anItem) {
            cartItems.add(anItem);
        }

        public void removeItem(String itemName) {
            for (ItemToPurchase item : cartItems) {
                if (itemName.equals(item.getItemName())) {
                    cartItems.remove(item);
                    System.out.println();
                    System.out.println(itemName + " was removed from your cart.");
                    return;
                }
            }

            /*
            Here we are prompting the user of our program that the item does not exist in the cart therefore nothing
            was removed. This statement would be happening of course if the user reply is not logically correct with our
            for statement.
             */
            System.out.println("This item was not found in your cart. Nothing was removed.");
            return;
        }

        public void modifyItem(ItemToPurchase anItem) {
            for (ItemToPurchase item : cartItems) {
                if (anItem.getItemName().equals(item.getItemName())) {
                    item.setItemQuantity(anItem.getItemQuantity());
                    return;
                }
            }

            /* This statement is doing the same as the last printing statement in the removeItem method. If the user
            reply is not logically correct and on point with the programs demands, it will print this statement to the
            user.
             */
            System.out.println("This item was not found in your cart. Nothing was removed.");
            return;
        }

        public void printTotal() {
            int size = cartItems.size();
            System.out.println(this.customerName + " - " + this.currentDate);
            System.out.println("Number of Items: " + size);
            System.out.println();
            for (int i = 0; i < size; i++) {
                System.out.println(cartItems.get(i).printItemCost());
            }
            if (size == 0){
                System.out.println("SHOPPING CART IS EMPTY");
            }
            else {
                System.out.println("Total cost of cart: $" + String.format("%.2f", this.getCostOfCart()));
            }

        }

        public void printDescriptions() {
            System.out.println("Name: " + this.customerName + " - " + this.currentDate);
            System.out.println();
            for (int i = 0; i < cartItems.size(); i++) {
                System.out.println(cartItems.get(i).printItemDescription());
                System.out.println();
            }
        }
    }

