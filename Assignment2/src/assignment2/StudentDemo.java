/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.util.Scanner;
import java.lang.Math;

/**
 * Title: ICT 167 Assignment 2
 * @author Sin Loo MAH (33220079)
 * File name: StudentDemo
 * Date of submission: 26th October 2018
 * Purpose: This is the client class that control the program,which able to call
 * and use the methods in Student Class.
 * Assumptions/ Expectations:
 * Assuming users will enter data in correct data type such as student number in
 * integers. Assuming there is only four choices for title, which is Mr, Miss, Ms 
 * and Mrs. Expecting when the user enter the data, it will store in the correct
 * variables in the array.At least 8 data are hard-coded for testing purpose.
 */
public class StudentDemo {
    
    /*Main method that controlling the program*/
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int SIZE = 15;
        int arraySIZE = 10;
        Student[] stu = new Student[SIZE]; //create array

        StudentDemo.hardcodeData(stu);
        
        /*To output the student's (author) information*/
        Student.studentInfo();
        
        while(true){ //to loop the program 
            /*Call the method to print out the menu*/
            StudentDemo.printMenu();
            
            char ch = kb.nextLine().trim().toLowerCase().charAt(0);
            
            switch (ch){ //Switch case to let user make a choice from the menu
                case 'q': //to quit program
                    System.out.println("You chose to quit the program. ");
                    System.exit(0);
                    break;
                    
                case 'a': //to add information
                    System.out.println("");
                    System.out.println("You chose to add information about student(s).");
                    while(true){ //to ask if user want to input another student details
                        stu[arraySIZE]= new Student();
                        stu[arraySIZE].input(stu);
                        System.out.println("");
                        stu[arraySIZE].display();
                        arraySIZE++;
                        checkSameStudents(stu,arraySIZE);
                        System.out.println("");
                        System.out.println("Do you want to enter another student details (Y/N)?");
                        String anotherStudentDetails = kb.nextLine();
                        if(anotherStudentDetails.equalsIgnoreCase("n")){
                            break;
                        }//end if
                    }//end while
                    break;
                
                case 'b': //output all students information
                    outputAllDetails(stu,arraySIZE);
                    break;
                    
                case 'c': //output average overall marks for all students
                    double avgOverallMarks = calAvgOverallMarks(stu,arraySIZE);
                    displayAvgOverallMarks(avgOverallMarks);
                    break;
                    
                case 'd': //output number of students obtained an overeall mark equal to or above the average overall mark and below the average overall mark
                    int above = calAboveBelow(stu, arraySIZE);
                    displayAboveBelow(above, arraySIZE);
                    break;
                    
                case 'e': //output the distribution of grades awarded
                    calAwards(stu, arraySIZE);
                    break;
                    
                case 'f': //to view all details of the student by the student number
                    findID(stu, arraySIZE);
                    break;
                    
                case 'g': //view all details of the student by student's name
                    findNames(stu, arraySIZE);
                    break;
                    
                case 'h': //output the names of the students with the highest overall and the second highest overall mark
                    displayHighest(stu, arraySIZE);
                    break;
                    
                case 'i': //to sorted array into ascending order of student's numbers.
                    Student.sortStudentNumber(stu, arraySIZE);
                    outputAllDetails(stu,arraySIZE);
                    break;
                    
                case 'j': //to sorted array of student objects into ascending (alphabetical/ dictionary) order of student's surnames
                    Student.sortSurname(stu, arraySIZE);
                    outputAllDetails(stu,arraySIZE);
                    break;
                    
                default:
                    System.out.println("Please choose enter option 'q', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h','i' or 'j' only. ");
                    break;
            }//end switch
        }//end while
    }//end main
    
    /*Method to check if there are same students with same names, date of birth and student number*/
    static void checkSameStudents(Student stu[],int arraySIZE){
        for(int i=0; i<arraySIZE - 1; i++){
            for(int j=i+1; j<arraySIZE; j++){
                if (stu[i].equal(stu[j])){
                    System.out.println("");
                    System.out.println("There are same students.");
                    System.out.println("Students " +  stu[i].getFirstName() + " " + stu[i].getLastName() + " and " + stu[j].getFirstName() + " " + stu[j].getLastName() + " " + "are having the same names, date of birth and student numbers. ");
                }//end if
            }//end for j
        }//end for i
    }//end checkSameStudents
    
    /*Method to output student details in a table form*/
    static void outputAllDetails(Student stu[],int arraySIZE){
        System.out.println("You chose to output students information. ");
        System.out.println("");
        System.out.println("All information of all students currently held in the array: ");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Title\t First Name\t Last Name\t Student ID\t Date of Birth\t Assignment 1\t Assignment 2\t Assignment 3\t Practical Work\t Final Examination\t Overall Marks\t Final Grade\t");
        for(int i=0; i < arraySIZE; i++){
            stu[i].outputAllInfo();
        }//end for
    }//end outputAllDetails
    
    /*Method to calculate the average overall marks for all students*/
    static double calAvgOverallMarks(Student stu[], int arraySIZE){
        double sumOverallMarks = 0;
        double avgOverallMarks;
        for(int i=0; i<arraySIZE; i++){
            sumOverallMarks += stu[i].getOverallMarks();
        }//end for
        avgOverallMarks = Student.round(sumOverallMarks/(double)arraySIZE, 2);
        return avgOverallMarks;
    }//end calAvgOverallMarks
    
    /*Method to display average overall marks of all students*/
    static void displayAvgOverallMarks(double avg){
        System.out.println("");
        System.out.println("You chose to output average overall marks.");
        System.out.println("Average overall marks: " + avg);
    }//end displayAvgOverallMarks
    
    /*Method to calculate the number of student who obtained overall mark above 
    average overall mark*/
    static int calAboveBelow(Student stu[], int arraySIZE){
        int above =0;
        for(int i=0; i<arraySIZE; i++){
            if(stu[i].getOverallMarks() >= calAvgOverallMarks(stu, arraySIZE)){
                above++;
            }//end if
        }//end for
        return above;
    }//end calAboveBelow
    
    /*Method to display the calAboveBelow*/
    static void displayAboveBelow(int above, int arraySIZE){
        System.out.println("");
        System.out.println("You chose to output number of students obtained equal or above and below the average marks.");
        System.out.println("Number of students obtained overall marks equal of above the average marks: " + above);
        System.out.println("Number of students obtained overall marks below the average marks: " + (arraySIZE - above));
    }//end displayAboveBelow
    
    /*Method to calculate the number of students getting HD and D*/
    static void calAwards(Student stu[], int arraySIZE){
        int isHD = 0;
        int isD = 0;
        System.out.println("");
        System.out.println("You chose to output Distribution of Grade Awarded. ");
        for(int i=0; i<arraySIZE; i++){
            if(stu[i].getRoundedOverallMarks() >= 80){
                isHD++;
            }//end if
            if((stu[i].getRoundedOverallMarks() >= 70) && (stu[i].getRoundedOverallMarks() < 80)){
                isD++;
            }//end if
        }//end for
        System.out.println("Number of HD: " + isHD);
        System.out.println("Number of D: " + isD);
    }//end calAwards
    
    /*Method to display student details with given student number*/
    static void findID(Student stu[], int arraySIZE){
        Scanner kb = new Scanner(System.in);
        System.out.println("");
        System.out.println("You chose to view student's details with student number(ID). ");
        System.out.println("Please enter a student number (ID): ");
        long id = kb.nextLong();
        boolean tt = false;
        for(int i=0; i<arraySIZE; i++){
            if(id == stu[i].getStudentID()){
                tt = true;
                System.out.println("");
                System.out.println("Student details for student number(ID) " + id + ";");
                stu[i].display();
                break;
            }//end if
        }//end for
        if(tt == false){
            System.out.println("");
            System.out.println("Student not found! ");
        }//end if
    }//end findID
    
    /*Method to display student details with given student names*/
    static void findNames(Student stu[], int arraySIZE){
        Scanner kb = new Scanner(System.in);
        System.out.println("");
        System.out.println("You chose to view student's details with student's name. ");
        System.out.println("Please enter a student's first name: ");
        String fn = kb.nextLine().trim().toUpperCase();
        System.out.println("Please enter a student's last name: ");
        String ln = kb.nextLine().trim().toUpperCase();
        boolean tt = false;
        for(int i=0; i<arraySIZE; i++){
            if(fn.equals(stu[i].getFirstName())){
                if(ln.equals(stu[i].getLastName())){
                    tt = true;
                    System.out.println("");
                    System.out.println("Student details for " + fn + " " + ln + ";");
                    stu[i].display();
                    break;
                }//end if lastName
            }//end if firstName
        }//end for
        if(tt == false){
            System.out.println("");
            System.out.println("Student not found! ");
        }//end if
    }//end findNames
    
    /*Method to find the highest overall mark*/
    static double findFirst(Student stu[], int arraySIZE){
        double first = -1;
        for(int i = 0; i<arraySIZE; i++){
            if(stu[i].getOverallMarks() > first){
                first = stu[i].getOverallMarks();
            }//end if
        }//end for
        return first;
    }//end findFirst
    
    /*Method to find the highest and second highest overall mark*/
    static double findSecond(Student stu[], int arraySIZE){
        double second = -1;
        for(int i=0; i <arraySIZE; i++){
            if(stu[i].getOverallMarks() > second && stu[i].getOverallMarks() < findFirst(stu, arraySIZE)){
                second = stu[i].getOverallMarks();
            }//end if
        }//end for
        return second;
    }//end findSecond
    
    /*Method to output the highest and second highest overall mark*/
    static void displayHighest(Student stu[], int arraySIZE){
        System.out.println("");
        System.out.println("You chose to output names of students with highest overall mark and second highest overall mark. ");
        
        System.out.println("Students with highest mark:");
        for(int i=0; i<arraySIZE; i++){
            if(stu[i].getOverallMarks() == findFirst(stu, arraySIZE)){
                System.out.println(stu[i].getFirstName() + " " + stu[i].getLastName());
            }//end if
        }//end for
        
        System.out.println("Students with second highest mark:");
        for(int i=0; i<arraySIZE; i++){
            if(stu[i].getOverallMarks() == findSecond(stu, arraySIZE)){
                System.out.println(stu[i].getFirstName() + " " + stu[i].getLastName());
            }//end if
        }//end for
    }//end displayHighest
    
    /*Hardcode data that store in the array for testing purpose*/
    static void hardcodeData(Student stu[]){
        stu[0] = new Student("Mr", "STEVE", "JONES", 32857838, 24,2,1990, 94,86,84.5,7.8,82);
        stu[1] = new Student("Miss", "MARY", "SMITH", 35050580, 15,7,1995, 49,60,77,6.9,68);
        stu[2] = new Student("Ms", "AMY", "BROWN", 31799703, 19,5,1992, 81.5,78,82,8.5,75);
        stu[3] = new Student("Mrs", "KAREN", "WALKER", 31195200, 8,9,1996, 49,50.5,48,4.2,39.9);
        stu[4] = new Student("Mr", "WILLIAM", "THOMPSON", 38512412, 26,10,1999, 77,77.9,75.3,7.5,75.5);
        stu[5] = new Student("Mr", "DAREN", "LEWIS", 36428539, 11,3,1994, 79.5,93.2,90.1,9,81);
        stu[6] = new Student("Miss", "THERESA", "WOOD", 31426793, 31,8,1993, 55,41.3,62,5.8,60);
        stu[7] = new Student("Ms", "SARA", "CLARKE", 37974024, 12,12,1997, 41,48.5,51,4.9,53);
        stu[8] = new Student("Mrs", "VIVIAN", "SANDERS", 38502450, 27,6,1991, 91,87.5,94.5,9.1,84);
        stu[9] = new Student("Mr", "MARTIN", "HARRIS", 30957635, 5,10,1995, 55,63,72,7.1,69.5);
    }//end hardcoreData
    
    /*Print out the menu*/
    static void printMenu(){
        System.out.println("");
        System.out.println("S T U D E N T  I N F O R M A T I O N");
        System.out.println("Menu: ");
        System.out.println("Enter 'q' to exit the program. ");
        System.out.println("Enter 'a' to add information about a student and determine the student grade. ");
        System.out.println("Enter 'b' to output all the student details that currently held in the array. ");
        System.out.println("Enter 'c' to output the average overall mark for students currently held in the array. ");
        System.out.println("Enter 'd' to display number of students obtained an overeall mark equal to or above the average overall mark and below the average overall mark. ");
        System.out.println("Enter 'e' to display the distribution of grades awarded. ");
        System.out.println("Enter 'f' to view all details of the student by the student number. ");
        System.out.println("Enter 'g' to view all details of the student by student's name. ");
        System.out.println("Enter 'h' to display the names of the students with the highest overall and the second highest overall mark.");
        System.out.println("Enter 'i' to display the sorted array into ascending order of student's numbers. ");
        System.out.println("Enter 'j' to display the sorted array of student objects into ascending (alphabetical/ dictionary) order of student's surnames. ");
        System.out.println("");
        System.out.println("Please enter an option: ");
    }//end printMenu
}//end StudentDemo
