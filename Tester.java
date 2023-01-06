
import java.util.*;
/**
 * Write a description of class Tester here.
 * 
 * @author 
 * @version 
 */
public class Tester {
    private void doTest() {
        FIRE fortunate = new Resort("Fortunate Islands");
        Scanner enter = new Scanner(System.in);

        // Write all of your tests here
        // Test 1: Check toString() method
        System.out.println("Test 1: Check toString() method\n");
        System.out.println(fortunate.toString());

        // Test 2: Check getAllPassesOnAllIslands() method
        System.out.println("\nTest 2: Check getAllPassesOnAllIslands() method\n");
        System.out.println(fortunate.getAllPassesOnAllIslands());

        // Test 3: Check findPassLocation() method
        System.out.println("\nTest 3: Check findPassLocation() method\n");
        System.out.println("Enter pass id: ");
        int passId = enter.nextInt();
        String passLocation = fortunate.findPassLocation(passId);
        System.out.println("Pass with id " + passId + " is located on " + passLocation);

        // Test 4: Check viewAPass() method
        System.out.println("\nTest 4: Check viewAPass() method\n");
        System.out.println("Enter pass id: ");
        int viewId = enter.nextInt();
        String passDetails = fortunate.viewAPass(viewId);
        System.out.println("Details for pass with id " + viewId + ": " + passDetails);

        // Test 5: Check getIslandNumber() method
        System.out.println("\nTest 5: Check getIslandNumber() method\n");
        System.out.println("Enter island name: ");
        String islandName = enter.next();
        int islandNumber = fortunate.getIslandNumber(islandName);
        System.out.println("Island " + islandName + " has island number " + islandNumber);

        // Test 6: Check getAllPassesOnIsland() method
        System.out.println("\nTest 6: Check getAllPassesOnIsland() method\n");
        System.out.println("Enter island name: ");
        String islandName2 = enter.next();
        String allPasses = fortunate.getAllPassesOnIsland(islandName2);
        System.out.println("All passes on island " + islandName2 + ": " + allPasses);

        // Test 7: Check canTravel() method
        System.out.println("\nTest 7: Check canTravel() method\n");
        System.out.println("Enter pass id: ");
        int passId2 = enter.nextInt();
        System.out.println("Enter island Id: ");
        String islandName3 = enter.next();
        boolean canTravel = fortunate.canTravel(passId2, islandName3);
        System.out.println("Pass with id " + passId2 + " can travel to island " + islandName3 + ": " + canTravel);

        // Test 8: Check travel() method
        System.out.println("\nTest 8: Check travel() method\n");
        System.out.println("Enter pass id: ");
        int passId3 = enter.nextInt();
        System.out.println("Enter island Id: ");
        String islandName4 = enter.next();
        String travel = fortunate.travel(passId3, islandName4);
        System.out.println("Pass with id " + passId3 + " has travelled to island " + islandName4 + ": " + travel);

        // Test 9: Check topUpCredits() method
        System.out.println("\nTest 9: Check topUpCredits() method\n");
        System.out.println("Enter pass id: ");
        int passId4 = enter.nextInt();
        System.out.println("Enter amount to top up: ");
        int amount = enter.nextInt();
        fortunate.topUpCredits(passId4, amount); 
        System.out.println("Pass with id " + passId4 + " has been topped up by " + amount + " credits");


        // Test 10: Check getAllPassesOnIsland() method
        System.out.println("\nTest 10: Check getAllPassesOnIsland() method\n");
        System.out.println("Enter island name: ");
        String islandName5 = enter.next();
        String allPasses2 = fortunate.getAllPassesOnIsland(islandName5);
        System.out.println("All passes on island " + islandName5 + ": " + allPasses2);

        // close the scanner
        enter.close();

    }

    // No need to change this
    public static void main(String[] args) {
        Tester xx = new Tester();
        xx.doTest();
    }
}

