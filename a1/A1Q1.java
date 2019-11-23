
package a1;
import java.util.Scanner;
/**
 * Title: Principles of Computer Science Assignment 1 Question 1 
 * @author Jocelyn MAH 
 * File name: A1Q1
 * Date of submission: 14th September 2018
 * Purpose: To create a TV show survey and output a table of viewers who watch
 *          the show regularly.
 * Assumptions/ Expectations: 
 * This program should asked the user to choose to proceed the survey or quit 
 * the program. If the user choose to proceed the program then it will ask the 
 * user to input data and repeat the process if the user would like to enter 
 * another person details. Appropriate error message will be output and re prompt
 * until the user enter correct data. The process of data collection will stop 
 * when the user do not want to enter another person details and it will output 
 * the result of the survey. The processes will be repeated until the user want 
 * to quit the program.
 */
public class A1Q1 {

    /*
    getAge method is to get the user age and return it to main method. The age 
    accepted is range from 1 to 110. Appropriate error message will be output 
    and re prompt until the user enter the correct data. 
    */
    public static int getAge(){
       
        int returnAge = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("");

        System.out.println("Please enter your age (1 - 110)");
        while(true){// to check if the user input age is in the range
            if(input.hasNextInt()){//if the input is integer
                int inputAge = input.nextInt();
                if(inputAge < 1 || inputAge > 110){//if the age is out of range
                    System.out.println("Invalid. Please enter age range from 1 to 110.");
                }//end if 
                else{//if the input age is in range
                    returnAge = inputAge;
                    break;
                }//end else
            }//end if 
            else{//if the input is not integer
                input.next();
                System.out.println("Invalid. Please enter age range from 1 to 110.");
            }//end else
        }//end while
        
        return returnAge;
   }//end getAge
    
    /*
    getGender method is to get the user gender and only m for male and f for
    female is accepted. Appropriate error message will be output and re prompt 
    until the user enter the correct data. 
    */
    public static String getGender(){
       
        String returnGender = "";
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please enter your gender (M/F)");
        while(true){//to check if the user input correct gender
            if(!input.hasNext("[mMfF]")){//if the input is not M/F
                input.next();
                System.out.println("Invalid. Please enter your gender (M/F) ");
            }//end if
            else{//if the use input correct gender
                returnGender = input.next();
                break;
            }//end else
        }//end while
        
        return returnGender;
    }//end getGender
    
    /*
    getRegular method is to let the user input if the user watch the TV show
    regularly. Appropriate error message will be output and re prompt 
    until the user enter the correct data.
    */
    public static String getRegular(){
       
        String returnRegular = "";
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please enter whether you watch the show regularly (Y/N)");
        while(true){//to check if the user input is Y/N
            if(!input.hasNext("[yYnN]")){//if the input is not Y/N
                input.next();
                System.out.println("Invalid. Please enter whether you watch the show regularly (Y/N) ");
            }//end if 
            else{//if the user input correct answer
                returnRegular = input.next();
                break;
            }//end else
        }//end while
        
        return returnRegular;
   }//end getRegular
    
    /*
    getAnotherSurvey method is to let the user choose to proceed to enter another
    person details for the TV show. Appropriate error message will be output 
    and re prompt until the user enter the correct data.
    */
    public static String getAnotherSurvey(){
       
        String returnAnotherSurvey = "";
        Scanner input = new Scanner(System.in);
        
        System.out.println("Do you want to enter another person's details (Y/N)");
        while(true){//to check if user input correct answer
            if(!input.hasNext("[yYnN]")){//if the input is not Y/N
                input.next();
                System.out.println("Invalid. Do you want to enter another survey (Y/N) ");
            }//end if
            else{//if the user input Y/N
                returnAnotherSurvey = input.next();
                break;
            }//end else
        }//end while
        
        return returnAnotherSurvey;
   }//end getAnotherSurvey
   
    public static int getTotalRegPer(int total, int totalRegular){
        return (int)((totalRegular / (double)total)*100);//to calculate the percentage of total regular watch 
    }
    
    public static int getUnder30Per(int totalRegFemaleBelow30, int totalRegMaleBelow30, int totalRegular){
        return (int)(Math.round(((totalRegFemaleBelow30 + totalRegMaleBelow30)/ (double)totalRegular)*100));//to calculate the percentage age below 30
    }
    
    public static int getAbove30Per(int totalRegFemale30Above, int totalRegMale30Above, int totalRegular){
        return (int)(Math.round(((totalRegFemale30Above + totalRegMale30Above)/ (double)totalRegular)*100));//to calculate the percentage age 30 and above;
    }
    
    public static int getTotalPer(int under30Per, int above30Per){
        return under30Per + above30Per;//to calculate percentage of total
    }
    
    public static int getTotalRegFemaleBelow30Per(int totalRegFemaleBelow30, int totalRegMaleBelow30, int under30Per){
        return (int)(Math.round((totalRegFemaleBelow30/(double)(totalRegFemaleBelow30 + totalRegMaleBelow30))*under30Per));//to calculate the percentage of total regular female age below 30
    }
    
    public static int getTotalRegFemale30AbovePer(int totalRegFemale30Above, int totalRegMale30Above, int above30Per){
        return (int)(Math.round((totalRegFemale30Above/(double)(totalRegFemale30Above + totalRegMale30Above))*above30Per));//to calculate the percentage of total regular female age 30 and above
    }
    
    public static int getTotalRegMaleBelow30Per(int totalRegMaleBelow30, int totalRegFemaleBelow30, int under30Per){
        return (int)(Math.round((totalRegMaleBelow30 / (double)(totalRegFemaleBelow30 + totalRegMaleBelow30))*under30Per));//to calculate the percentage of total regular male age below 30
    }
    
    public static int getTotalRegMale30AbovePer(int totalRegMale30Above, int totalRegFemale30Above, int above30Per){
        return (int)(Math.round((totalRegMale30Above /(double) (totalRegFemale30Above + totalRegMale30Above))*above30Per));//to calculate the percentage of total regular male age 30 and above
    }
    
    public static int getTotalRegFemalePer(int totalRegFemaleBelow30Per, int totalRegFemale30AbovePer){
        return totalRegFemaleBelow30Per + totalRegFemale30AbovePer;//to calculate percentage of total regular female 
    }
    
    public static int getTotalRegMalePer(int totalRegMaleBelow30Per, int totalRegMale30AbovePer){
        return totalRegMaleBelow30Per + totalRegMale30AbovePer;//to calculate percentage of total regular male 
    }
    
    /*
    output method is to display the information of the survey and a table of 
    viewers who watch the particular show regularly.
    */
    public static void output(String tvShowName, int total, int totalRegular, int totalRegPer, int totalRegFemaleBelow30Per,int totalRegFemale30AbovePer,int totalRegFemalePer, 
            int totalRegMaleBelow30Per,int totalRegMale30AbovePer,int totalRegMalePer, int under30Per,int above30Per,int totalPer){// to display the output and table
        
        System.out.println("Below is the survey result for " + tvShowName);
        System.out.println("------------------------------------------------------");
        System.out.println("The total number of people surveyed: " + total);
        System.out.println("The number of people who watch the show regularly: " + totalRegular);
        System.out.println("The percentage of those who watch the show regularly: " + totalRegPer);
        
 
        System.out.println("");
        System.out.println("Distribution of viewers who watch the show regularly");
        System.out.println("------------------------------------------------------");
        System.out.println("Gender\t % Under 30\t % 30 or Over\t % Total");
        System.out.format("%1s%10d%15d%15d","Female",totalRegFemaleBelow30Per,totalRegFemale30AbovePer,totalRegFemalePer);
        System.out.println("");
        System.out.format("%1s%12d%15d%15d","Male",totalRegMaleBelow30Per,totalRegMale30AbovePer,totalRegMalePer);
        System.out.println("");
        System.out.println("------------------------------------------------------");
        System.out.format("%1s%11d%15d%15d","Total",under30Per,above30Per,totalPer);
        System.out.println("");
        
    }//end output
    
    /*
    studentInfo method is to display the student details at the beginning of the
    program result
    */
    public static void studentInfo(){
        
        System.out.println("");
        System.out.println("S T U D E N T  I N F O");
        System.out.println("Student name: Sin Loo MAH");
        System.out.println("Student number: 33220079");
        System.out.println("Mode of enrolment: Internal");
        System.out.println("Tutor name: Rukshima Debare");
        System.out.println("Tutorial attendance day and time: Wednesday 3.30pm");
        System.out.println("");
    
    }//end studentInfo
    
    
        public static void main(String[] args) {
        
        /*
        All the variables in this program are declared as followed

        total = total number of people survey
        totalRegular = total number of people who watch the show regularly
        totalRegFemale = total number of female who watch the show regularly
        totalRegFemaleBelow30 = total number of female age below 30 who watch the show regularly
        totalRegFemale30Above = total number of female age 30 and above who watch the show regularly
        totalRegMale = total number of male who watch the show regularly
        totalRegMaleBelow30 = total number of male age below 30 who watch the show regularly
        totalRegMale30Above = total number of male age 30 and above who watch the show regularly
        totalRegPer = Percentage of total number of people who watch the show regularly
        totalRegFemaleBelow30Per = Percentage of total number of female age below 30 who watch the show regularly
        totalRegFemale30AbovePer = Percentage of total number of female age 30 and above who watch the show regularly
        totalRegMaleBelow30Per = Percentage of total number of male age below 30 who watch the show regularly
        totalRegMale30AbovePer = Percentage of total number of male age 30 and above who watch the show regularly
        totalRegFemalePer = Percentage of total number of female who watch the show regularly
        totalRegMalePer = Percentage of total number of male who watch the show regularly
        under30Per =  Percentage of  total number of people age below 30 who watch the show regularly
        above30Per = Percentage of  total number of people age 30 and above who watch the show regularly
        totalPer = Percentage of total number of people survey
        */
        
        int age;// declare age as integer 
        String gender, regular; //declare gender and regular as string
        String anotherSurvey;//if the user want to enter another person details
        int total, totalRegular, totalRegFemale,totalRegFemaleBelow30, totalRegFemale30Above, 
                totalRegMale, totalRegMaleBelow30, totalRegMale30Above;
        int totalRegPer, totalRegFemaleBelow30Per,totalRegFemale30AbovePer,
                totalRegMaleBelow30Per, totalRegMale30AbovePer,totalRegFemalePer,
                totalRegMalePer,under30Per,above30Per, totalPer;
        String tvShowName; //declare tvShowName as string
         
        System.out.println("**********************************");
        System.out.println("* Welcome to Survey for TV show! *");
        System.out.println("**********************************");

        while(true){//outer loop
            Scanner input = new Scanner(System.in);

            System.out.println("");
            System.out.println("Please enter 'p' to proceed to create a new survey or 'q' to exit.");

            char ch = input.nextLine().trim().toLowerCase().charAt(0);

            switch (ch){// to let user choose to proceed the survey or quit
                case 'p':// to proceed the survey
                    /* 
                    Initialize Variable to reset data to 0 
                    */
                    age = 0;
                    gender = "";
                    regular = ""; 
                    anotherSurvey = "y";
                    total = 0;
                    totalRegular = 0;
                    totalRegFemale = 0;
                    totalRegFemaleBelow30 = 0;
                    totalRegFemale30Above = 0;
                    totalRegMale = 0;
                    totalRegMaleBelow30 = 0;
                    totalRegMale30Above = 0;
                    totalRegPer = 0;
                    totalRegFemaleBelow30Per = 0;
                    totalRegFemale30AbovePer = 0;
                    totalRegMaleBelow30Per = 0;
                    totalRegMale30AbovePer = 0;
                    totalRegFemalePer = 0;
                    totalRegMalePer = 0;
                    under30Per = 0;
                    above30Per = 0;
                    totalPer = 0;
                    tvShowName = "";
                    
                    System.out.println("Please enter the title of the TV show"); // to let user to enter title of the show
                    tvShowName = input.nextLine().toUpperCase();// to store the title as tvShowName with upper case
                    System.out.println("");
                    System.out.println("You are doing a survey for " + tvShowName);

                    while(anotherSurvey.equalsIgnoreCase("y")){
                        age = getAge();
                        gender = getGender();
                        regular = getRegular();
                        anotherSurvey = getAnotherSurvey();
                        
                        total++; //to get total count
        
                        if(regular.equalsIgnoreCase("y")){// if regular equal to yes
                            totalRegular++;//to get total regular count

                            if(gender.equalsIgnoreCase("f")){//if gender equal to female
                                totalRegFemale ++;//to get total regular female count

                                if(age < 30){
                                    totalRegFemaleBelow30 ++;//to get total regular female age below 30 count
                                }//end if age < 30

                                else{
                                    totalRegFemale30Above ++;//to get total regular female age 30 and above count
                                }//end else totalRegFemale30Above

                            }//end if gender.equalsIgnoreCase("f")

                            else if(gender.equalsIgnoreCase("m")){// if gender equal to male
                                totalRegMale ++;//to get total regular male count

                                if(age < 30){
                                    totalRegMaleBelow30 ++;//to get total regular male age below 30 count
                                }//end if age < 30

                                else{
                                    totalRegMale30Above ++;//to get total regular male age 30 and above count
                                }//end else totalRegMale30Above
                            }//end else if gender.equalsIgnoreCase("m")
                        }//end if regular.equalsIgnoreCase("y")
                    }//end while

                    totalRegPer = getTotalRegPer(total,totalRegular);

                    under30Per = getUnder30Per(totalRegFemaleBelow30, totalRegMaleBelow30, totalRegular);
                    above30Per = getAbove30Per(totalRegFemale30Above, totalRegMale30Above, totalRegular);
                    totalPer = getTotalPer(under30Per, above30Per);
                    totalRegFemaleBelow30Per = getTotalRegFemaleBelow30Per(totalRegFemaleBelow30, totalRegMaleBelow30, under30Per);
                    totalRegFemale30AbovePer = getTotalRegFemale30AbovePer(totalRegFemale30Above, totalRegMale30Above, above30Per);
                    totalRegMaleBelow30Per = getTotalRegMaleBelow30Per(totalRegMaleBelow30, totalRegFemaleBelow30, under30Per);
                    totalRegMale30AbovePer = getTotalRegMale30AbovePer(totalRegMale30Above, totalRegFemale30Above, above30Per);
                    totalRegFemalePer = getTotalRegFemalePer(totalRegFemaleBelow30Per, totalRegFemale30AbovePer);
                    totalRegMalePer =  getTotalRegMalePer(totalRegMaleBelow30Per, totalRegMale30AbovePer);
                    studentInfo();//to call method studentInfo()
                    output(tvShowName, total, totalRegular, totalRegPer, totalRegFemaleBelow30Per, totalRegFemale30AbovePer, totalRegFemalePer, totalRegMaleBelow30Per,
                            totalRegMale30AbovePer, totalRegMalePer, under30Per, above30Per, totalPer);//to call method output()
                    
                    break;

                case 'q'://to quit the survey
                    System.out.println("You chose to quit the survey. Thank you for participating!");
                    System.exit(0);
                    break;

                default://if the user do not 'p' or 'q' 
                    System.out.println("Invalid. Please enter 'p'to proceed the survey or 'q' to exit. ");//output error message
                    break;

            }//end switch
        }//end while
    }//end main
}//end A1Q1
