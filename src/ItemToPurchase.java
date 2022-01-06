public class ItemToPurchase {
        private String itemName;
        private double itemPrice;
        private int itemQuantity;
        private String itemDescription;

        public ItemToPurchase(String itemName, double itemPrice, int itemQuantity, String itemDescription) {
            this.itemName = itemName;
            this.itemPrice = itemPrice;
            this.itemQuantity = itemQuantity;
            this.itemDescription = itemDescription;
        }

        public ItemToPurchase() {
            this.itemName = "";
            this.itemPrice = 0.00;
            this.itemQuantity = 0;
            this.itemDescription = "";
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public double getItemPrice() {
            return itemPrice;
        }

        public void setItemPrice(double itemPrice) {
            this.itemPrice = itemPrice;
        }

        public int getItemQuantity() {
            return itemQuantity;
        }

        public void setItemQuantity(int itemQuantity) {
            this.itemQuantity = itemQuantity;
        }

        public String getItemDescription() {
            return itemDescription;
        }

        public void setItemDescription(String itemDescription) {
            this.itemDescription = itemDescription;
        }

        public String printItemCost(){
            return this.getItemName() + " " + this.getItemQuantity() + " " + "@" + " " +
                    "$" + String.format("%.2f",this.getItemPrice()) + " " + "= $" +
                    String.format("%.2f",(this.getItemPrice() * this.getItemQuantity()));
        }

        public String printItemDescription(){
            return this.getItemName() + ": " + this.getItemDescription();
        }
    }

