import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

/** 
 * NUMBER GUESSING GAME
 * ----------------------
 * Skills Demonstrated:
 * 1.Random number generation   (java.util.Random)
 * 2.Loops - While loop for multiple attempts
 * 3.Conditional statements (if /else if /else )for feedback    
 * 4. Excetion handling (try/catch) for invalid input
 */


public class NumberGuessingGame{

    public static void main(String[] args){

        //-------Setup

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int randomNumber = random.nextInt(100) +1; //random number:1-100

        int MaxAttempts = 5;
        int Attempts = 0;
        boolean hasWon =  false;        


        //-------Welcome Banner ----------------
        System.out.println("================================");
        System.out.println("    WELCOME TO GUESSING GAME");
        System.out.println("================================");  
        System.out.println("Guess a number between 1 and 100");
        System.out.println("You have "+ MaxAttempts + " attempts.");  
        System.out.println("Good luck!");


        // ------ Main Game Loop----------------
        while(Attempts < MaxAttempts ){
            
            System.out.print("Enter your Guess: ");

            try{

                int userGuess = scanner.nextInt();
                Attempts++;
                
                //-------Check the user's guess 
                if(userGuess == randomNumber){
                    hasWon = true;
               
                
                    System.out.println();
                    System.out.println("Congratulations !");
                    System.out.println("You Guessed the Correct number.");
                    System.out.println("Attempts used :" + Attempts);
                    break; //`Exit the loop immediately if the user wins

                }else if((userGuess < randomNumber)){
                    System.out.println("Too low! Try a Higher Number");
                    //Attemptsleft--;

                }else{
                    System.out.println("Too high! Try a Lower Number");
                    //Attemptsleft--;
                }

                // -----out-of-range numbers are accepted but flagged as invalid
                System.out.println("Remaining Attempts: " + (MaxAttempts - Attempts));
                System.out.println();
            

            }catch(InputMismatchException e){

                System.out.println("Invalid input Please enter a number.");
                scanner.next(); //clear the invalid input

            }

        }
        //-----End of Game Meassage-------
        if(!hasWon){
            System.out.println();
            System.out.println("Game over!");
            System.out.println("The Correct number was: " + randomNumber);

        }
        scanner.close();

        

    }

}       