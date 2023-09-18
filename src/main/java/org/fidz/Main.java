package org.fidz;

import java.util.Scanner;

public class Main {
    public static final double UNLEADED_PRICE = 44.00;
    public static final double DIESEL_PRICE = 38.00;
    public static final double PREMIUM_PRICE = 50.00;

    public static final String UNLEADED = "unleaded";
    public static final String DIESEL = "diesel";
    public static final String PREMIUM = "premium"; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isValid;
        String fuelType;
        double liters;
        char answer;
        do {
            do {
                System.out.print("Enter gasoline type (unleaded/diesel/premium): ");
                fuelType = sc.nextLine();
                isValid = isValidFuelType(fuelType);
            } while (!isValid);
            do {
                System.out.print("Enter number of liters: ");
                liters = sc.nextDouble();
                sc.nextLine();
                if (liters > 0) {
                    break;
                }
                System.out.println("Invalid input. Liters must be a positive number.");
            } while (true);
            double totalPrice = computeTotalPrice(fuelType, liters);
            System.out.println("Receipt :");
            System.out.println("Fuel Type: " + fuelType);
            switch (fuelType) {
                case UNLEADED:
                    System.out.println("Price per liter: " + UNLEADED_PRICE);
                    break;
                case DIESEL:
                    System.out.println("Price per liter: " + DIESEL_PRICE);
                    break;
                case PREMIUM:
                    System.out.println("Price per liter: " + PREMIUM_PRICE);
                    break;
                default:
                    System.out.println("Invalid input. Liters must be a positive number.");
                    break;
            }
            System.out.println("Purchase amount: " + totalPrice);
            System.out.println("VAT: " + computeVat(totalPrice));
            System.out.println("TOTAL AMOUNT: " + computeTotalAmount(totalPrice));
            System.out.print("\nDo you want to continue? [Y/N]? ");
            answer = sc.next().charAt(0);
            sc.nextLine();
        } while (answer == 'Y' || answer == 'y');
        sc.close();
        System.out.println("Program terminated.");
    }

    public static boolean isValidFuelType(String fuelType) {
        String lowerCase = fuelType.toLowerCase();
        if (lowerCase.equals("unleaded") || lowerCase.equals("diesel") || lowerCase.equals("premium")) {
            return true;
        }
        return false;
    }

    public static String getPricePerLiter(String fuelType) {
        String lowerCase = fuelType.toLowerCase();
        if (lowerCase.equals("unleaded")) {
            return String.valueOf(UNLEADED_PRICE);
        } else if (lowerCase.equals("diesel")) {
            return String.valueOf(DIESEL_PRICE);
        } else if (lowerCase.equals("premium")) {
            return String.valueOf(PREMIUM_PRICE);
        }
        return "";
    }

    public static double computeTotalPrice(String fuelType, double liters) {
        String lowerCase = fuelType.toLowerCase();
        if (lowerCase.equals("unleaded")) {
            return liters * UNLEADED_PRICE;
        } else if (lowerCase.equals("diesel")) {
            return liters * DIESEL_PRICE;
        } else if (lowerCase.equals("premium")) {
            return liters * PREMIUM_PRICE;
        }
        return 0;
    }

    // generate total amount including vat
    public static double computeTotalAmount(double totalPrice) {
        return totalPrice + computeVat(totalPrice);
    }

    // calculate the vat from fuel totalprice
    public static double computeVat(double totalPrice) {
        return totalPrice * 0.12;
    }
}