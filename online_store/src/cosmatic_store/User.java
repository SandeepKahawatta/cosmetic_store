package cosmatic_store;
import java.io.Serializable;
import java.util.Scanner;

public abstract class User implements Serializable {
    protected String username;
    protected String password;
    protected String role;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public abstract void displayMenu();

    protected void searchProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Search by: 1. Category 2. Name 3. Price");
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1:
                System.out.print("Enter category: ");
                String category = scanner.nextLine();
                for (Product product : Main.products) {
                    if (product.getCategory().equalsIgnoreCase(category)) {
                        System.out.println(product);
                    }
                }
                break;
            case 2:
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                for (Product product : Main.products) {
                    if (product.getName().equalsIgnoreCase(name)) {
                        System.out.println(product);
                    }
                }
                break;
            case 3:
                System.out.print("Enter price: ");
                double price = scanner.nextDouble();
                for (Product product : Main.products) {
                    if (product.getPrice() == price) {
                        System.out.println(product);
                    }
                }
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    protected void searchStock() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        for (Product product : Main.products) {
            if (product.getName().equalsIgnoreCase(name)) {
                System.out.println("Stock count: " + product.getStock());
                return;
            }
        }
        System.out.println("Product not found");
    }

    protected void buyProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        for (Product product : Main.products) {
            if (product.getName().equalsIgnoreCase(name)) {
                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();
                if (quantity <= product.getStock()) {
                    product.setStock(product.getStock() - quantity);
                    double totalPrice = quantity * product.getPrice();
                    System.out.println("Invoice:");
                    System.out.println("Product: " + product.getName());
                    System.out.println("Quantity: " + quantity);
                    System.out.println("Total Price: $" + totalPrice);
                } else {
                    System.out.println("Insufficient stock");
                }
                return;
            }
        }
        System.out.println("Product not found");
    }
}
