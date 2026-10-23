import java.util.ArrayList;
import java.util.Scanner;

class Customer {
    String id, name, phone, email;

    Customer(String id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Phone: " + phone + ", Email: " + email);
    }
}

public class CRMSystem {
    static ArrayList<Customer> customers = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addCustomer() {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        customers.add(new Customer(id, name, phone, email));
        System.out.println("Customer added successfully!\n");
    }

    public static void viewCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers found.\n");
        } else {
            for (Customer c : customers) {
                c.display();
            }
            System.out.println();
        }
    }

    public static void updateCustomer() {
        System.out.print("Enter Customer ID to update: ");
        String id = sc.nextLine();
        for (Customer c : customers) {
            if (c.id.equals(id)) {
                System.out.print("Enter new Name: ");
                c.name = sc.nextLine();
                System.out.print("Enter new Phone: ");
                c.phone = sc.nextLine();
                System.out.print("Enter new Email: ");
                c.email = sc.nextLine();
                System.out.println("Customer updated successfully!\n");
                return;
            }
        }
        System.out.println("Customer not found.\n");
    }

    public static void deleteCustomer() {
        System.out.print("Enter Customer ID to delete: ");
        String id = sc.nextLine();
        boolean removed = customers.removeIf(c -> c.id.equals(id));
        if (removed) {
            System.out.println("Customer deleted successfully!\n");
        } else {
            System.out.println("Customer not found.\n");
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("---- CRM MENU ----");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1": addCustomer(); break;
                case "2": viewCustomers(); break;
                case "3": updateCustomer(); break;
                case "4": deleteCustomer(); break;
                case "5": System.out.println("Exiting CRM System..."); return;
                default: System.out.println("Invalid choice! Try again.\n");
            }
        }
    }
}