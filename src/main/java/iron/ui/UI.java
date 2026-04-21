package iron.ui;

import java.sql.SQLOutput;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class UI {
    private final Scanner scanner;

    public UI() {
        scanner = new Scanner(System.in);
    }

    public int showMainMenu() {
        System.out.println("\n====== MAIN MENU ======");
        System.out.println("1. View Available Races");
        System.out.println("2. View License Information");
        System.out.println("3. View Race History");
        System.out.println("4. Settings Menu");
        System.out.println("0. Exit");
        return getValidChoice(0, 4);
    }

    public int showAvailableRaces() {
        System.out.println("\n====== AVAILABLE RACES ======");
        System.out.println("1. Race 1");
        System.out.println("2. Race 2");
        System.out.println("3. Race 3");
        System.out.println("0. Back");
        return getValidChoice(0, 3);
    }

    public int showRegistrationClosed(String raceName) {
        System.out.println("\n ====== " + raceName.toUpperCase() + " ======");
        System.out.println("Status: Registration CLOSED");
        System.out.println("1. Choose another race");
        System.out.println("0. Back");
        return getValidChoice(0, 1);
    }

    public int showRegistrationOpen(String raceName) {
        System.out.println("\n====== " + raceName.toUpperCase() + "======");
        System.out.println("Status: Registration OPEN");
        System.out.println("1. Check License Validity");
        System.out.println("0. Back");
        return getValidChoice(0, 1);
    }

    public int showLicenseInvalid() {
        System.out.println("\n====== LICENSE CHECK ======");
        System.out.println("License is INVALID or expired");
        System.out.println("0. Back");
        return getValidChoice(0, 0);
    }

    public int showLicenseValid() {
        System.out.println("\n====== LICENSE CHECK ======");
        System.out.println("License is VALID");
        System.out.println("1. Check Category");
        System.out.println("0. Back");
        return getValidChoice(0, 1);
    }

    public int showCategoryNotAllowed() {
        System.out.println("\n====== CATEGORY CHECK ======");
        System.out.println("Category NOT allowed");
        System.out.println("1. Choose another race");
        System.out.println("0. Back");
        return getValidChoice(0, 1);
    }

    public int showCategoryAllowed() {
        System.out.println("\n====== CATEGORY CHECK ======");
        System.out.println("Category allowed");
        System.out.println("1. Check Available Slots");
        System.out.println("0. Back");
        return getValidChoice(0, 1);
    }

    public int showSlotsUnavailable() {
        System.out.println("\n====== SLOT CHECK ======");
        System.out.println("No slots available");
        System.out.println("1. Choose another race");
        System.out.println("0. Back");
        return getValidChoice(0, 1);
    }

    public int showSlotsAvailable() {
        System.out.println("\n====== SLOT CHECK ======");
        System.out.println("Slot is available");
        System.out.println("1. Register");
        System.out.println("0. Back");
        return getValidChoice(0, 1);
    }

    public int registrationSuccessful(String raceName){
        System.out.println("\n====== REGISTRATION SUCCESS ======");
        System.out.println("User is registered for " + raceName);
        System.out.println("Participant list updated");
        System.out.println("Confirmation notification is sent");
        System.out.println("0. Back to Main Menu");
        return getValidChoice(0, 0);
    }



    private int getValidChoice(int min, int max) {
        while (true) {
            System.out.print("\nEnter choice > ");
            String input = scanner.nextLine();

            try {
                int choice = Integer.parseInt(input);
                if (choice >= min && choice <= max) {
                    return choice;
                } else {
                    System.out.println("Invalid choice. Enter " + min + " to " + max);
                }
            } catch (NoSuchElementException e) {
                System.out.println("Invalid input. Enter a number");
            }
        }
    }



}
