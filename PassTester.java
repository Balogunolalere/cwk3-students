import java.util.*;
/**
 * Write a description of class PassTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

/*
 * A pass is a ticket that allows a person to travel on a ferry. Each pass has a
 * unique id number, a name, a luxury rating, a number of credits and a number of
 * journey points. A pass can be used to travel on a ferry. When this happens, the
 * number of credits is reduced by the luxury rating of the pass. A pass can also
 * be used to convert journey points into credits. Each journey point is worth 10
 * credits. A pass can also be used to add credits to the pass. A pass can also be
 * used to deduct credits from the pass.
 * 
 */
public class PassTester
{
    public static void main(String[] args)
    {
       // create some Pass objects
       Pass pass1 = new Pass(1, "John", 1, 10, 0);
       Pass pass2 = new Pass(2, "Mary", 2, 20, 0);
       Pass pass3 = new Pass(3, "Peter", 3, 30, 0);
       Pass pass4 = new Pass(4, "Paul", 4, 40, 0);

       // call the methods
       pass1.useFerry();
       pass2.useFerry();
       pass3.useFerry();
       pass4.useFerry();
       pass1.convertJourneyPoints();
       pass2.convertJourneyPoints();
       pass3.convertJourneyPoints();
       pass4.convertJourneyPoints();
       pass1.addCredits(10);
       pass2.addCredits(20);
       pass3.addCredits(30);
       pass4.addCredits(40);
       pass1.deductCredits(5);
       pass2.deductCredits(10);
       pass3.deductCredits(15);
       pass4.deductCredits(20);

       // check that the results are as expected
       System.out.println("Actual credits for pass1: " + pass1.getCredits());
       System.out.println("Expected credits for pass1: 5");
       System.out.println("Actual credits for pass2: " + pass2.getCredits());
       System.out.println("Expected credits for pass2: 10");
       System.out.println("Actual credits for pass3: " + pass3.getCredits());
       System.out.println("Expected credits for pass3: 15");
       System.out.println("Actual credits for pass4: " + pass4.getCredits());
       System.out.println("Expected credits for pass4: 20");
   }
}
