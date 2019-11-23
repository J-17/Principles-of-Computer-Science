
package a1;
import java.util.Scanner;
/**
 * Title: Principles of Computer Science Assignment 1 Question 2 
 * @author Jocelyn MAH 
 * File name: A1Q2Demo
 * Date of submission: 14th September 2018
 * Purpose: To create a simplified hangman game and this is the client class that
 * uses hangman class (A1Q2).
 * Assumptions/ Expectations:
 */
public class A1Q2Demo {//client class
    
    public static void main(String[] args) {
        
        A1Q2 hangman = new A1Q2();
        Scanner input = new Scanner(System.in);
        
        hangman.studentInfo();//to call method studentInfo from the class
        
        while(true){//to ask user if the user want to proceed with hangman game or quit
            System.out.println("");
            System.out.println("H A N G M A N  G A M E");
            System.out.println("Please enter 'p' to proceed the hangman game or 'q' to exit.");

            char ch = input.nextLine().trim().toLowerCase().charAt(0);

            switch (ch){//to let the user choose if he or she want to proceed hangman game or quit
                case 'p'://proceed with the hangman game

                    for(int i = 0; i < 3; i++){//to loop for three games

                        hangman.initialize();//call method initialize()
                        hangman.gameCount = i + 1;//to calculate the round of game and output 
                        hangman.getSecretWord();//call method getSecretWord()

                        while (!hangman.found){//loop around until the user guess the secret word correctly

                            hangman.getDisguisedWord();//call method getDisguisedWord()
                            hangman.makeGuess();//call method makeGuess()
                            hangman.getGuessCount(); //call method getGuessCount()
                            hangman.isFound();//call method isFound()
                        }//end while
                    }//end for loop
                    break;//break out from switch

                case 'q'://to quit the game

                     System.out.println("You chose to quit the hangman game. Thank you for playing!");
                     System.exit(0);
                     break;

                default://if the user do not 'p' or 'q' 
                        System.out.println("Invalid. Please enter 'p'to proceed the hangman game or 'q' to exit. ");//output error message
                        break;

            }//end switch

        }//end while
    }//end main
}//end A1Q2Demo
