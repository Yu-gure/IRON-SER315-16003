package iron;

import iron.ui.UI;

public class Main {
    public static void main(String[] args) {
        UI ui = new UI();

        ui.showMainMenu();
        ui.showAvailableRaces();
        ui.showRegistrationOpen("race 1");
        ui.showRegistrationClosed("race 2");
        ui.showLicenseValid();
        ui.showLicenseInvalid();
        ui.showCategoryAllowed();
        ui.showCategoryNotAllowed();
        ui.showSlotsAvailable();
        ui.showSlotsUnavailable();
        ui.registrationSuccessful("race 1");


    }
}








/*
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
}
 */