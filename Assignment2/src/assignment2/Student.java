/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;
import java.util.Scanner;

/**
 * Title: ICT 167 Assignment 2
 * @author Sin Loo MAH (33220079)
 * File name: Student
 * Date of submission: 26th October 2018
 * Purpose: This is the based class that contain methods that getting information 
 * from the students and do the calculation parts.
 * Assumptions/ Expectations:
 * Assuming users will enter data in correct data type such as student number in
 * integers. Assuming there is only four choices for title, which is Mr, Miss, Ms 
 * and Mrs. Expecting when the user enter the data, it will store in the correct
 * variables. Expecting all the validations are working such as date of birth 
 * (day,month,year), marks assignments, practical work and final exam will be in 
 * range. Expecting all the calculations are working such as calculating the
 * overall marks and final grade.There are two constructors,input and output
 * methods, reasonable number of set and get methods,methods to compute final
 * overall mark and final grade are void method, equals method etc.
 */

public class Student {
    /*Declaration of variables */
    Scanner kb = new Scanner(System.in);
    private String title = ""; //title of the student
    private String firstName = ""; //first name of the student
    private String lastName = ""; //last name of the student
    private long studentID = 0; //student number
    private String dob = ""; //date of birth
    private int day = 0; // day of birth
    private int month = 0; // month of birth
    private int year = 0; //year of birth
    private double a1 = 0; //mark for assignment 1
    private double a2 = 0; //mark for assignment 2
    private double a3 = 0; //mark for assignment 3
    private double prac = 0; //total marks obtained for all practical work
    private double exam = 0; //total mark obtained in final examination
    private double totalMarks = 0; //overall mark
    private String finalGrade = ""; //final grade
    private int roundedTotalMarks = 0; //overall mark that rounded off to the nearest whole number
    
    /*There are two constructors, the default constructor and one with parameters
    to give initial values to all the instance variables.*/
    Student(){
        title = "No title yet";
        firstName = "No first name yet";
        lastName = "No last name yet";
        studentID = 0;
        day = 0;
        month = 0;
        year = 0;
        dob = "No date of birth yet";
        a1 = -1;
        a2 = -1;
        a3 = -1;
        prac = -1;
        exam = -1;
    }//end Student
    
    Student(String t, String fn, String ln, long sn, int d, int m, int y, double aa1, double aa2, double aa3, double pw, double fe){
        title = t;
        firstName = fn;
        lastName = ln;
        studentID = sn;
        day = d;
        month = m;
        year = y;
        dob = String.valueOf(d) + "/" + String.valueOf(m) + "/" + String.valueOf(y);
        a1 = aa1;
        a2 = aa2;
        a3 = aa3;
        prac = pw;
        exam = fe;
    }//end Student
    
    /*Input method to get student information such as title, first name, last name
    student number, date of birth,assignment marks, practical work marks and final
    exam mark with the set methods for validations.*/
    public void input(Student[] s){
        inputTitle();
        System.out.println("Please enter a first name (given name): ");
        firstName = kb.nextLine().trim().toUpperCase();
        System.out.println("Please enter a last name (given name): ");
        lastName = kb.nextLine().trim().toUpperCase();
        System.out.println("Please enter student number (ID): ");
        studentID = kb.nextLong();
        System.out.println("Please enter your date of birth separately: ");
        System.out.println("Please enter day of birth: ");
        day = kb.nextInt();
        this.setDay(day);
        System.out.println("Please enter month of birth: ");
        month = kb.nextInt();
        this.setMonth(month);
        System.out.println("Please enter year of birth: ");
        year = kb.nextInt();
        this.setYear(year);
        System.out.println("There are three assignments, each marked out of a maximum of 100 marks: ");
        System.out.println("Please enter the first assignment marks: ");
        a1 = kb.nextDouble();
        this.setA1(a1);
        System.out.println("Please enter the second assignment marks: ");
        a2 = kb.nextDouble();
        this.setA2(a2);
        System.out.println("Please enter the third assignment marks: ");
        a3 = kb.nextDouble();
        this.setA3(a3);
        System.out.println("Please enter the total mark obtained (out of a maximum of 10 marks) for all practical work: ");
        prac = kb.nextDouble();
        this.setPracWork(prac);
        System.out.println("Please enter the final examination that is marked out of a maximum of 100 marks: ");
        exam = kb.nextDouble();
        this.setFinalExam(exam);
    }//end input
    
    /*This method is to let the user choose the title of the student and assuming 
    that there are only four choices of title, which is Mr, Miss, Ms and Mrs.*/
    private void inputTitle(){
        System.out.println("TItle: ");
        System.out.println("a. Mr ");
        System.out.println("b. Miss ");
        System.out.println("c. Ms ");
        System.out.println("d. Mrs ");
        boolean t = true;
        while(t){
            System.out.println("Please choose a title: ");
            char ch = kb.nextLine().trim().toLowerCase().charAt(0);
            switch(ch){
                case 'a':
                   title = "Mr";
                   t = false;
                   break;
                
                case 'b':
                   title = "Miss";
                   t = false;
                   break;
                case 'c':
                    title = "Ms";
                    t = false;
                    break;
                case 'd':
                    title = "Mrs";
                    t = false;
                    break;
                default:
                    System.out.println("Invalid. Please enter 'a', 'b', 'c' or 'd' only. ");
                    t= true;
                    break;
            }//end switch
        }//end while
    }//end inputTitle
    
    /*Set methods that will run all the validations to ensure the data enter are'
    in range. */
    private void setDay(int d){ //ensure day range from day 1 to 31 
        while((d < 1) || (d > 31)){
            System.out.println("Invalid. Please enter day range from 1 to 31 only.");
            d = kb.nextInt();
        }//end while
        this.day = d;
    }//end setDay
    
    private void setMonth(int m){//ensure month range from January to December in numeric
        while((m < 1) || (m > 12)){
            System.out.println("Invalid. Please enter month range from 1 to 12 only.");
            m = kb.nextInt();
        }//end while
        this.month = m;
    }//end setMonth
    
    private void setYear(int y){//ensure the year are valid (not less than 1)
        while(y < 1){
            System.out.println("Invalid. Please enter year not less than 1");
            y = kb.nextInt();
        }//end while
        this.year = y;
    }//end setYear
    
    private void setA1(double a1){//ensure assignment mark range from 1 to 100 only
        while((a1 < 0) || (a1 >100)){
            System.out.println("Invalid. Please enter marks range from 0 - 100 only.");
            a1 = kb.nextDouble();
        }//end while
        this.a1 = a1;
    }//end setA1
    
    private void setA2(double a2){//ensure assignment mark range from 1 to 100 only
        while((a2 < 0) || (a2 >100)){
            System.out.println("Invalid. Please enter marks range from 0 - 100 only.");
            a2 = kb.nextDouble();
        }//end while
        this.a2 = a2;
    }//end setA2
    
    private void setA3(double a3){//ensure assignment mark range from 1 to 100 only
        while((a3 < 0) || (a3 >100)){
            System.out.println("Invalid. Please enter marks range from 0 - 100 only.");
            a3 = kb.nextDouble();
        }//end while
        this.a3 = a3;
    }//end setA3
    
    private void setPracWork(double p){//ensure assignment mark range from 1 to 10 only
        while((p < 0) || (p >10)){
            System.out.println("Invalid. Please enter marks range from 0 - 10 only.");
            p = kb.nextDouble();
        }//end while
        this.prac = p;
    }//end setPracWork
    
    private void setFinalExam(double e){//ensure mark for final examination range from 1 to 100 only
        while((e < 0) || (e >100)){
            System.out.println("Invalid. Please enter marks range from 0 - 100 only.");
            e = kb.nextDouble();
        }//end while
        this.exam = e;
    }//end setFinalExam
    
    /*Calculation for overall mark:
      The three assignments together count for a total of 45% (15% each) of the 
      final grade, the practical work is worth 10% and the final exam is worth 
      45% of the final grade.*/
    public void calOverallMarks(){
        totalMarks = round((((getA1() + getA2() + getA3())/300) * 45) + getPracWork() + ((getFinalExam()/100) * 45),2);
        int rd = (int)totalMarks;
        double dec = totalMarks - rd;
        if (dec >= 0.5)
            roundedTotalMarks = rd + 1;
        else
            roundedTotalMarks = rd;
    }//end calOverallMarks
    
    /*Round off method that can be use either in based class or client class, 
    which can print out any amount of decimal value(s) that the user want.*/
    public static double round(double value, int precision){
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }//end round
    
    /*Method to award the final grade of student. An overall mark of 80 or higher 
    is an HD, 70 or higher is D, 60 or higher is C, 50 and higher is P and below
    50 is an N.*/
    public void calFinalGrade(){
        if(roundedTotalMarks >= 80)
            finalGrade = "HD";
        else if (roundedTotalMarks >= 70 && roundedTotalMarks < 80)
            finalGrade = "D";
        else if (roundedTotalMarks >= 60 && roundedTotalMarks < 70)
            finalGrade = "C";
        else if (roundedTotalMarks >= 50 && roundedTotalMarks < 60)
            finalGrade = "P";
        else
            finalGrade = "N";
    }//end calFinalGrade
    
    /*Output method to display the student's details*/
    public void display(){
        System.out.println("Title: " + getTitle());
        System.out.println("First name: " + getFirstName());
        System.out.println("Last name: " + getLastName());
        System.out.println("Student number: " + getStudentID());
        System.out.println("Date of birth: " + getDOB());
        System.out.println("Assignment marks: ");
        System.out.println("Assignment 1: " + getA1());
        System.out.println("Assignment 2: " + getA2());
        System.out.println("Assignment 3: " + getA3());
        System.out.println("Total marks for all the practical work: " + getPracWork());
        System.out.println("Marks for final exam: " + getFinalExam());
        System.out.println("Overall marks: " + getOverallMarks());
        System.out.println("Rounded off overall marks: " + getRoundedOverallMarks());
        System.out.println("Final grade: " + getFinalGrade());
    }//end display
    
    /*Method to compare two students objects and return true if they have the same
    student names, the same date of birth and the same student number, otherwise 
    return false.*/
    public boolean equal(Student b){
        boolean match = false;
        if(this.firstName.equals(b.firstName)){
            if(this.lastName.equals(b.lastName)){
                if(this.day == b.day){
                    if(this.month == b.month){
                        if(this.year == b.year){
                            if(this.studentID == b.studentID){
                                    match =true;
                            }//end if studentID
                        }//end if year
                    }//end  if month
                }//end if day
            }//end if lastName
        }//end if firstName
        return match;
    }//end equal
    
    /*Output method to display student information in a table form*/
    public void outputAllInfo(){
        if(title.equalsIgnoreCase("Miss")){
            System.out.format("%1s%12s%15s%18d%20s%13.2f%16.2f%16.2f%16.2f%17.2f%23.2f%13s%n",getTitle(),getFirstName(),getLastName(),getStudentID(),getDOB(),getA1(),getA2(),getA3(),getPracWork(),getFinalExam(),getOverallMarks(),getFinalGrade());
        }//end if
        else if(title.equalsIgnoreCase("Mrs")){
            System.out.format("%1s%13s%15s%18d%20s%13.2f%16.2f%16.2f%16.2f%17.2f%23.2f%13s%n",getTitle(),getFirstName(),getLastName(),getStudentID(),getDOB(),getA1(),getA2(),getA3(),getPracWork(),getFinalExam(),getOverallMarks(),getFinalGrade());
        }//end else if
        else{
            System.out.format("%1s%14s%15s%18d%20s%13.2f%16.2f%16.2f%16.2f%17.2f%23.2f%13s%n",getTitle(),getFirstName(),getLastName(),getStudentID(),getDOB(),getA1(),getA2(),getA3(),getPracWork(),getFinalExam(),getOverallMarks(),getFinalGrade());
        }//end else
    }//end outputAllInfo
    
    /*Method to sort the array into ascending order of students' number (ID) in 
    selection sort.*/
    public static void sortStudentNumber(Student array[], int arraySIZE){
        Student temp;
        for (int i = 1; i < arraySIZE; i++) {
            for(int j = i ; j > 0 ; j--){
                if(array[j].getStudentID() < array[j-1].getStudentID()){
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }//end if
            }//end for j
        }//end for i
    }//end sortStudentNumber
    
    /*Method to sort array in ascending (alpahbetical/dictionary) order of student's
    surnames in exchange sort.*/
    public static void sortSurname(Student array[], int arraySIZE){
        Student temp;
        for (int i = 0; i < arraySIZE; i++){
            for (int j = i + 1; j < arraySIZE; j++){
                if (array[i].getLastName().compareTo(array[j].getLastName())>0){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }//end if
            }//end for j
        }//end for i
    }//end sortSurname
    
    /*Get methods to get the variables that have been stored.*/
    public String getTitle(){
        return title;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public String getNames(){
        return (firstName + " " + lastName);
    }
    
    public long getStudentID(){
        return studentID;
    }
    
    public String getDOB(){
        dob = String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year);
        return dob;
    }
    
    public double getA1(){
        return a1;
    }
    
    public double getA2(){
        return a2;
    }
    
    public double getA3(){
        return a3;
    }
    
    public double getPracWork(){
        return prac;
    }
    
    public double getFinalExam(){
        return exam;
    }
    
    public double getOverallMarks(){
        calOverallMarks();
        return totalMarks;
    }

    public double getRoundedOverallMarks(){
        calOverallMarks();
        return roundedTotalMarks;
    }
    
    public String getFinalGrade(){
        calFinalGrade();
        return finalGrade;
    }
    
    /*Student's (author) information*/
    public static void studentInfo(){
        System.out.println("");
        System.out.println("S T U D E N T  D E T A I L S");
        System.out.println("Student name: Sin Loo MAH");
        System.out.println("Student number: 33220079");
        System.out.println("Mode of enrolment: Internal");
        System.out.println("Tutor name: Mark Abernethy");
        System.out.println("Tutorial attendance day and time: Thursday 3.30pm");
        System.out.println("");
    }//end studentInfo
}//end Student Class
