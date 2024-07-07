package cosmatic_store;
import java.util.Scanner;

public class Manager extends User {

    public Manager(String username, String password) {
        super(username, password, "Manager");
    }

    @Override
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Manager Menu:");
            System.out.println("1. View Products");
            System.out.println("2. Add Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Search Product");
            System.out.println("5. Search Stock");
            System.out.println("6. Create Account");
            System.out.println("7. Delete Account");
            System.out.println("8. Buy Product");
            System.out.println("9. Logout");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewProducts();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    searchProduct();
                    break;
                case 5:
                    searchStock();
                    break;
                case 6:
                    createAccount();
                    break;
                case 7:
                    deleteAccount();
                    break;
                case 8:
                    buyProduct();
                    break;
                case 9:
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

    private void addProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product category: ");
        String category = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter product stock: ");
        int stock = scanner.nextInt();

        Product product = new Product(name, category, price, stock);
        Main.products.add(product);
        System.out.println("Product added successfully!");
    }

    private void deleteProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product name to delete: ");
        String name = scanner.nextLine();
        Product productToRemove = null;
        for (Product product : Main.products) {
            if (product.getName().equalsIgnoreCase(name)) {
                productToRemove = product;
                break;
            }
        }
        if (productToRemove != null) {
            Main.products.remove(productToRemove);
            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("Product not found");
        }
    }

    private void createAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter role (Manager/Cashier/GuestCustomer/RegisteredCustomer): ");
        String role = scanner.nextLine();

        switch (role) {
            case "Manager":
                Main.users.add(new Manager(username, password));
                break;
            case "Cashier":
                Main.users.add(new Cashier(username, password));
                break;
            case "GuestCustomer":
                Main.users.add(new GuestCustomer(username, password));
                break;
            case "RegisteredCustomer":
                Main.users.add(new RegisteredCustomer(username, password));
                break;
            default:
                System.out.println("Invalid role");
                return;
        }
        System.out.println("Account created successfully!");
    }

    private void deleteAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username to delete: ");
        String username = scanner.nextLine();
        User userToRemove = null;
        for (User user : Main.users) {
            if (user.username.equalsIgnoreCase(username)) {
                userToRemove = user;
                break;
            }
        }
        if (userToRemove != null) {
            Main.users.remove(userToRemove);
            System.out.println("Account deleted successfully!");
        } else {
            System.out.println("User not found");
        }
    }
}
