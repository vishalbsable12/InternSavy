package org.example;
import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Exchange rates (for demonstration purposes)
        double usdToInrRate = 73.50; // INR exchange rate
        double usdToAedRate = 3.67;  // AED exchange rate
        double usdToCnyRate = 6.44;  // CNY exchange rate
        double usdToEurRate = 0.85;  // EUR exchange rate
        double usdToGbpRate = 0.73;  // GBP exchange rate
        /*Add more country Currencies */

        boolean running = true;

        while (running) {
            //Menu Driven For Currency Exchange Rate
            System.out.println("1. INR to USD");
            System.out.println("2. USD to INR");
            System.out.println("3. INR to AED");
            System.out.println("4. AED to INR");
            System.out.println("5. CNY to INR");
            System.out.println("6. INR to EUR");
            System.out.println("7. EUR to INR");
            System.out.println("8. INR to GBP");
            System.out.println("9. GBP to INR");
            System.out.println("10. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            //Option select of the above mention list

            switch (choice) {
                //object to Redirect method To
                case 1:

                    convertFromINR(scanner, usdToInrRate);
                    break;
                case 2:
                    convertToINR(scanner, usdToInrRate);
                    break;
                case 3:
                    convertFromINR(scanner, usdToAedRate);
                    break;
                case 4:
                    convertToINR(scanner, usdToAedRate);
                    break;
                case 5:
                    convertToINR(scanner, usdToCnyRate);
                    break;
                case 6:
                    convertFromINR(scanner, usdToEurRate);
                    break;
                case 7:
                    convertToINR(scanner, usdToEurRate);
                    break;
                case 8:
                    convertFromINR(scanner, usdToGbpRate);
                    break;
                case 9:
                    convertToINR(scanner, usdToGbpRate);
                    break;
                case 10:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }

    /*Convert From INR to Other Country Currencies */
    public static void convertFromINR(Scanner scanner, double exchangeRate) {
        System.out.print("Enter the amount in INR: ");
        double amount = scanner.nextDouble();

        double convertedAmount = amount / exchangeRate;
        /*OutPut Print */
        System.out.println("Converted amount: " + convertedAmount);
    }
/*Convert From Other To INR  Currency */
    public static void convertToINR(Scanner scanner, double exchangeRate) {
        System.out.print("Enter the amount : ");
        double amount = scanner.nextDouble();

        double convertedAmount = amount * exchangeRate;
        /*OutPut print*/
        System.out.println("Converted amount: " + convertedAmount);
    }
}
