import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<String> myArrList = new ArrayList<>();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        boolean options = true;


        while (options) {
            displayOptions();
            String option = SafeInput.getRegExString(in, "Please enter your menu choice", "[AaDdIiPpQq]").toUpperCase();

            switch (option) {
               case "A" -> addItem();
               case "D" -> deleteItem();
               case "I" -> insertItem();
               // case "P" -> printList();
                case "Q" -> {
                    if (SafeInput.getYNConfirm(in, "Are you sure you wish to quit the program? (Y/N): ")) {
                        options = false;
                        System.out.println("Thanks for checking the program out. Have a nice day!");
                    }
                }
            }
        }

    }

    public static void displayOptions() {
        System.out.print ("\nHere is your current list: ");
        if (myArrList.isEmpty()) {
            System.out.println("[Empty]");
        } else {
            for (int i = 0; i < myArrList.size(); i++) {
                System.out.println((i + 1) + ". " + myArrList.get(i));
            }
        }
        System.out.println("\nCommand Options: ");
        System.out.println("A - Add an item to the list");
        System.out.println("D - Delete an item from the list");
        System.out.println("I - Insert an item from the list");
        System.out.println("P - Print the item list");
        System.out.println("Q - Quit the program");
    }

    public static void addItem() {
        String item = SafeInput.getRegExString(in, "Enter an item you wish to add to the list.", ".*");
        myArrList.add(item);
        System.out.println("Your item has been added to the list.");
    }

    public static void deleteItem() {
        if (myArrList.isEmpty()) {
            System.out.println("Your list is already empty.");
            return;
        }
        // displayList();
        int itemNumber = SafeInput.getRangedInt(in, "Enter the number of the item in the list you would like to delete.", 1, myArrList.size());
        myArrList.remove(itemNumber - 1);
        System.out.println("Item #" + itemNumber + " has been removed.");
    }

    public static void insertItem() {
        String item = SafeInput.getRegExString(in, "Enter an item you wish to add to the list.", ".*");
        int position = SafeInput.getRangedInt(in, "Enter the position in which you would like to add an item", 1, myArrList.size() + 1);
        myArrList.add(position - 1, item);
        System.out.println("Your item has been inserted into position #" + (position));
    }

}