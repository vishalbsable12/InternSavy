package org.example;


import java.util.Scanner;

class LogicConverter {
    public static double convertToFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }

    public static double convertToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Temperature Conversion Tool");

        while (true) {
            System.out.println("1. Fahrenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1/2/3): ");
            int choice = scanner.nextInt();

            if (choice == 3) {
                System.out.println("Exiting the program.");
                break;
            }

            System.out.print("Enter temperature: ");
            double temperature = scanner.nextDouble();

            double convertedTemperature;
            if (choice == 1) {
                convertedTemperature = LogicConverter.convertToCelsius(temperature);
                System.out.println("Temperature in Celsius: " + convertedTemperature);
            } else if (choice == 2) {
                convertedTemperature = LogicConverter.convertToFahrenheit(temperature);
                System.out.println("Temperature in Fahrenheit: " + convertedTemperature);
            } else {
                System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
