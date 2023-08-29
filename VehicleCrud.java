package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Vehicle {
    /*Data Members*/
    private int id;
    private String number;
    private String ownername;
    private int year;

    /*COnstructor to initialize */
    public Vehicle(int id, String number, String ownername, int year) {
        this.id = id;
        this.number = number;
        this.ownername = ownername;
        this.year = year;
    }

    /*Getter Setter*/
    /*Because this class in encapsulation that why we are using Getter Setter*/
    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String make) {
        this.number = make;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String model) {
        this.ownername = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Vehicle Number: " + number + ", ownername: " + ownername + ", Year: " + year;
    }
}

public class VehicleCrud {
    public static void main(String[] args) {
        /*Create Scanner Object*/
        Scanner scanner = new Scanner(System.in);
         /*Create a List to store Vehicle objects*/
        List<Vehicle> vehicles = new ArrayList<>();

        //Initialize an ID counter
        int idCounter = 1;

        // Initialize a flag for the application loop
        boolean running = true;

        // Main loop for the CRUD application
        while (running) {
            System.out.println("1. Add Vehicle");
            System.out.println("2. View Vehicles");
            System.out.println("3. Update Vehicle");
            System.out.println("4. Delete Vehicle");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Vehicle Number  : ");
                    String number = scanner.next();
                    System.out.print("Enter Vehicle Owner Name  : ");
                    String ownername = scanner.next();
                    System.out.print("Enter Model year: ");
                    int year = scanner.nextInt();
                    vehicles.add(new Vehicle(idCounter++, number, ownername, year));
                    System.out.println("Vehicle added successfully.");
                    break;
                case 2:
                    if (vehicles.isEmpty()) {
                        System.out.println("No vehicles to display.");
                    } else {
                        System.out.println("Vehicles:");
                        for (Vehicle vehicle : vehicles) {
                            System.out.println(vehicle);
                        }
                    }
                    break;
                case 3:
                    if (vehicles.isEmpty()) {
                        System.out.println("No vehicles to update.");
                    } else {
                        System.out.print("Enter ID of the vehicle to update: ");
                        int updateId = scanner.nextInt();
                        for (Vehicle vehicle : vehicles) {
                            if (vehicle.getId() == updateId) {
                                System.out.print("Vehicle Number: "+ vehicle.getNumber ());
                                System.out.print("\nEnter new model: ");
                                vehicle.setOwnername (scanner.next());
                                System.out.print("Enter new year: ");
                                vehicle.setYear(scanner.nextInt());
                                System.out.println("Vehicle updated successfully.");
                                break;
                            }
                        }
                    }
                    break;
                case 4:
                    if (vehicles.isEmpty()) {
                        System.out.println("No vehicles to delete.");
                    } else {
                        System.out.print("Enter ID of the vehicle to delete: ");
                        int deleteId = scanner.nextInt();
                        vehicles.removeIf(vehicle -> vehicle.getId() == deleteId);
                        System.out.println("Vehicle deleted successfully.");
                    }
                    break;
                case 5:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
