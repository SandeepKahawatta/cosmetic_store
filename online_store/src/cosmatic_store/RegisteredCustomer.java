package cosmatic_store;
import java.util.Scanner;

public class RegisteredCustomer extends User {

    public RegisteredCustomer(String username, String password) {
        super(username, password, "RegisteredCustomer");
    }

    @Override
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Registered Customer Menu:");
            System.out.println("1. View Products");
            System.out.println("2. Search Product");
            System.out.println("3. Search Stock");
            System.out.println("4. Buy Product");
            System.out.println("5. Logout");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewProducts();
                    break;
                case 2:
                    searchProduct();
                    break;
                case 3:
                    searchStock();
                    break;
                case 4:
                    buyProduct();
                    break;
                case 5:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void viewProducts() {
        for (Product product : Main.products) {
            System.out.println(product);
        }
    }
}
