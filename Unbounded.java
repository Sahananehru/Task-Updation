package com.ques;
import java.util.ArrayList;
import java.util.List;


class Customer {
    private String name;
    private String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Customer{name='" + name + "', email='" + email + "'}";
    }
}


class CustomerProcessor {


    public static <T> void printDataStartsWith(List<T> list, String prefix) {
        for (T item : list) {
            if (item instanceof Customer) {
                Customer customer = (Customer) item;
                if (customer.getName().startsWith(prefix)) {
                    System.out.println(customer);
                }
            }
        }
    }

 
    public static <T> void printDataEndsWith(List<T> list, String suffix) {
        for (T item : list) {
            if (item instanceof Customer) {
                Customer customer = (Customer) item;
                if (customer.getName().endsWith(suffix)) {
                    System.out.println(customer);
                }
            }
        }
    }
}


public class Unbounded {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Alice Smith", "alice@example.com"));
        customers.add(new Customer("Bob Johnson", "bob@example.com"));
        customers.add(new Customer("Charlie Brown", "charlie@example.com"));
        customers.add(new Customer("David Smith", "david@example.com"));

        System.out.println("Customers whose name starts with 'A':");
        CustomerProcessor.printDataStartsWith(customers, "A");

        System.out.println("\nCustomers whose name ends with 'Smith':");
        CustomerProcessor.printDataEndsWith(customers, "Smith");
    }
}

