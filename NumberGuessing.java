
import java.util.Scanner;

public class NumberGuessing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int maxAttempts = 5;
        int round = 1;
        boolean guessedCorrectly = false;
        int score = 0;
        boolean playAgain;

       

        System.out.println("Welcome to the Number Guessing Game!");
       

        int attempts = 0;
         do{
            attempts = 0; // Reset attempts for each new round

            int random = (int) ((Math.random() *100) + 1);
          
            System.out.println("\n Round " + round + " - Guess a number between 1 and 100.");


                System.out.println("\nYou have only "+ maxAttempts+ " chance for Guessing a Number");
           

            while (attempts < maxAttempts) {
                
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
    
                if (userGuess == random) {

                    System.out.println(" Correct! You guessed it in " + attempts + " attempt(s).");
                    guessedCorrectly = true;
                    score += (maxAttempts - attempts + 1); // Higher score for fewer attempts
                    break;

                }else if (userGuess < random && (maxAttempts - attempts) > 0) {
                    System.out.println("Too low! Try again. And you have only "+ (maxAttempts-attempts)+ " Chance");
                }else if(userGuess > random && (maxAttempts - attempts) > 0){
                    System.out.println("Too high! Try again.  And you have only "+ (maxAttempts-attempts)+ " Chance");
                }else{
                    System.out.println("You Use All Attempts..");
                }

                if (attempts == maxAttempts) {
                    System.out.println("You've used all attempts! The number was: " + random);
                } 
                
            }
            System.out.print("Do you want to play another round? (yes/no): ");
            String responce = scanner.next().toLowerCase();
            playAgain = responce.equals("yes");

            if (playAgain) {
                round++;
            }
         }while(playAgain);

         System.out.println("\n Game Over!");
         System.out.println("Total Rounds Played: " + round);
         System.out.println("Your Final Score: " + score);
         
         scanner.close();
    }
}