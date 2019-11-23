
package a1;
import java.util.Scanner;
/**
 * Title: Principles of Computer Science Assignment 1 Question 2 
 * @author Jocelyn MAH 
 * File name: A1Q2
 * Date of submission: 14th September 2018
 * Purpose: To create a class that could be used to play a simplified version of
 * the hangman game.
 * Assumptions/ Expectations:This the hangman class that store all the methods 
 * that could used to play a simplified version of hangman game.
 */
public class A1Q2 {
    
    /*
    The variables in this program are declared as below. The internal used 
    variables that only use in this class are declared as private while the
    variables that are using in the class and client class are declared as public.
    
    secretWord = secret word 
    disguisedWord = disguised word that appear in ?
    wordlength = the word length of the secret word
    totalGuess = total guesses made
    guessLetter = the guess letter enter by user
    totalWrongGuess = total wrong guesses made
    guessLetterAll = all the guess letters
    gameCount = the round of the hangman game
    */
    private String secretWord = "";
    private String disguisedWord = "";
    private int wordlength;
    private int totalGuess = 0;
    private String guessLetter = "";
    private boolean flag = true;
    private int totalWrongGuess = 0;
    private String guessLetterAll = "";
    public boolean found = false;
    public int gameCount = 0;
    
    
    /*
    studentInfo method is to display the student details at the beginning of the
    program result
    */
    public void studentInfo(){
        
        System.out.println("");
        System.out.println("S T U D E N T  I N F O");
        System.out.println("Student name: Sin Loo MAH");
        System.out.println("Student number: 33220079");
        System.out.println("Mode of enrolment: Internal");
        System.out.println("Tutor name: Rukshima Debare");
        System.out.println("Tutorial attendance day and time: Wednesday 3.30pm");
    
    }//end studentInfo
    
    /*
    initialize method is created to reset all the data back to zero when a secret 
    word is guessed correctly and continue with the new data(secret word).
    */
    public void initialize(){

        secretWord = "";
        disguisedWord = "";
        wordlength = 0;
        totalGuess = 0;
        guessLetter = "";
        totalWrongGuess = 0;
        guessLetterAll = "";
        flag = true;
        found = false;
    }//end initialize
    
    /*
    getSecretWord method is to store the secret word. Before starting
    a hangman game, the program will output the round of the hangman games (e.g.
    Lets play a round of hangman game).
    */
    public void getSecretWord(){
    
        String countWord = "";//declare countWord as empty string
        
        switch (gameCount){//switch case to print the round of hangman game
            case 2: 
                countWord = " second";
                secretWord = "Hello World".toLowerCase();
                break;
            case 3: 
                countWord = " third";
                secretWord = "Testing".toLowerCase();
                break;
            default: 
                countWord = "";
                secretWord = "Java".toLowerCase();
                break;
                      
        }//end switch
        
        System.out.println("");
        System.out.println("Let's play a" + countWord + " round of hangman.");
        System.out.println("We are playing hangman.");
        System.out.println("");
        
//        Scanner input = new Scanner(System.in);   
//        
//        System.out.println("Please enter a secret word or phrase.");
//        secretWord = input.nextLine();
        wordlength = secretWord.length();// to calculate the length of secret word
        System.out.println("");
        System.out.println("Please guess the disguised word(s). ");
        System.out.println("");
        
    }//end getSecretWord
    
    
    /*
    getDisguisedWord method is to convert the secret word to ? then display it.
    In this method, nested for loop is used. The outer loop is to loop the
    secret word and the inner loop is to loop the guess letters made. This is 
    program, the whitespace will still remains as whitespace.
    */
    public void getDisguisedWord(){
        //declare variables
        char charFound;
        disguisedWord = "";//declare disguised word as empty string
        
        for (int i = 0; i < wordlength; i++){//for loop to check secret word
            charFound = Character.MIN_VALUE;//to set charFound to minimum value
            
            if (Character.isWhitespace(secretWord.charAt(i))){// if the secret word contain white space
               disguisedWord =  disguisedWord.concat(Character.toString(' '));//convert character ' ' to string in order to concatenate white space 
            }//end if 
            
            else{ 
                for (int j = 0; j < guessLetterAll.length(); j++){//for loop to compare the guess letter
                    if(secretWord.charAt(i) == guessLetterAll.charAt(j)){//if the secretWord match the guessLetter
                        charFound = guessLetterAll.charAt(j);//store guessLetter as charFound
                        break;// break out the for loop j
                    }//end if
                }//end for loop for j
                
                if (charFound == Character.MIN_VALUE){//if charFound equal to minimum value
                    disguisedWord =  disguisedWord.concat(Character.toString('?')); //disguisedWord append ?
                }//end if
                else{
                    disguisedWord =  disguisedWord.concat(Character.toString(charFound)); //append disguisedWord as charFound
                }//end else      
                    
            }//end else
            
        }//end for loop for i
        
        System.out.println("The disguised word(s) is " + "<" + disguisedWord + ">");// print out disguisedWord with ?
    }//end getDisguisedWord
    
    /*
    makeGuess method is to get user guess letter and ensure the user only enter
    one alphabet character at one guess. Appropriate error message will be output
    until the user enter the guess letter in the correct way. It will also check
    if the guesses made is correct or wrong.
    */
    public void makeGuess(){//to get guessed letter and compare with secret word
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Guess a letter: ");
        
        while(true){//while loop to ensure user input the guess letter in a correct way
            
            if(input.hasNextInt()){//if user input an integer
                input.next();
                System.out.println("Sorry, your guess must be an alphabet character from a to z. ");
                System.out.println("Guesses made " + totalGuess + " with " + totalWrongGuess + " wrong");//print out the number of guess made with number of wrong guess
                System.out.println("");
                System.out.println("The disguised word(s) is " + "<" + disguisedWord + ">");// print out disguisedWord with ?
                System.out.println("Guess a letter: ");
            }//end if
            
            else{
                String guessLetterInput = input.next();
                
                if(guessLetterInput.length() > 1){//if the user input more than one letter
                    System.out.println("Sorry, bad guess. Need a single letter.");
                    System.out.println("Guesses made " + totalGuess + " with " + totalWrongGuess + " wrong");//print out the number of guess made with number of wrong guess
                    System.out.println("");
                    System.out.println("The disguised word(s) is " + "<" + disguisedWord + ">");// print out disguisedWord with ?
                    System.out.println("Guess a letter: ");
                }//end if
                
                else{
                    guessLetter = guessLetterInput.toLowerCase();
                    break;
                }//end else
            }//end else
        }//end while

        for(int j = 0; j < wordlength; j++){//for loop to match secretWord with guessLetter
            
            if(Character.toString(secretWord.charAt(j)).equalsIgnoreCase(guessLetter)){//if guessLetter is match with the character in secretWord
                flag = true;
                guessLetterAll = guessLetterAll.concat(guessLetter);//append guessLetter to guessLetterAll
                break;
            }//end if
            
            else{
                flag = false;
            }//end else
            
        }//end for loop
        
        if(flag == true){//if guessLetter is match with the character in secretWord
            System.out.println("Correct. ");
        }//end if
        
        else{//if guessLetter is not match with the character in secretWord
            System.out.println("Incorrect. ");  
        }//end else
        
    }//end makeGuess
    
    
    /*
    getGuessCount method is to calculate the guesses made and wrong guesses made
    by the user and display it.
    */
    public void getGuessCount(){//to print out the number of guesses and number of wrong guesses
        totalGuess ++;// calculate total number of guess
        
        if (flag == false){//if guessLetter is not match with the character in secretWord
            totalWrongGuess ++; //calculate total number of incorrect guess
        }//end if
        
        System.out.println("Guesses made " + totalGuess + " with " + totalWrongGuess + " wrong");
        System.out.println("");
    }//end getGuessCount
    
    
    /*
    isFound method is to ensure the user guess the secret word correctly and 
    output the message to let user know that the user get the secret word correctly.
    */
    public void isFound(){//to print out congrats when the user found the secret word
        StringBuilder disguisedWordString = new StringBuilder(disguisedWord);//declare disguisedWord(primitive type) as class type
        //StringBuilder can replace a character in certain position
        
        for(int j = 0; j < wordlength; j++){//for loop to compare character in secret word with guessLetter
            if(Character.toString(secretWord.charAt(j)).equalsIgnoreCase(guessLetter)){//if secretWord match guessLetter
                disguisedWordString.setCharAt(j, guessLetter.charAt(0));//replace ? with guessLetter
            }//end if
        }//end for loop
        
        disguisedWord =  disguisedWordString.toString();//declare disguisedWordString(StringBuilder) to String
        found = !disguisedWord.contains(Character.toString('?'));//found equal to diguisedWord does not contain ?
        
        if (found == true){//to print out congrats message if user found the secret word
            System.out.println("Congratulations, you found the secret word(s): " + disguisedWord);
            System.out.println("***************************************************************");
        }//end if
        
    }//end isFound
    
}//end A1Q2
