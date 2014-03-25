package gradebook;

import java.util.ArrayList;
import java.util.Scanner;

public class GradeBook {
  public ArrayList<Student> students = new ArrayList();
  //public int position = 0;
  public static String br = System.getProperty("line.separator");
  
  public static void main(String[] args) {
      GradeBook gradeBook = new GradeBook();
      gradeBook.menu(gradeBook.students);
  }

    public void menu(ArrayList<Student> students) {
    //Displays a menu of the available commands and explains their functionality
        int loop =0;
        while(loop != 1) { 
            System.out.println(br + "Please choose from the following commands." + br
                             + "   'add' - add a student to the system." + br
                             + "   'list' - list all the students in the system and their records" + br 
                             + "   'search' - find a specific student's records to review or update" + br
                             + "   'quit' - to quit the program" + br);
          //Receive the command from the user and transform to lowercase in case user types in uppercase command
            Scanner m = new Scanner(System.in);
            String n = m.next().toLowerCase();
          //Call the function specified by the user's command (and check if input is not valid)     
            switch (n){
                case "add": this.add(students);
                   break;
                case "list": this.list(students);
                   break;
                case "search": this.search(students);
                   break;
                case "quit": loop = 1;
                   break;
                default: System.out.println("That is not a valid command");  
            }
        }
    }
    
    public void search(ArrayList<Student> students) {
    //searches for a specific student in the ArrayList and returns his/her information
         //initialize ArrayList to store matches found in the search
           ArrayList <Student> matches = new ArrayList();
         //Initialize a counter to count matches found 
           int counter = 0; 
        //Initialize a Student object variable to be referenced throughout the function
          Student x = null;
        //loop through the function until the user is done searching  
          int loop = 0;
          while (loop !=1) {
            //Reset Student x in case it is set from a previous search
              x = null;
            //Get name of requested student from the user 
              System.out.println("Enter the name of the student you wish to find." + br 
                               + "To return to the main menu enter quit");
              Scanner s = new Scanner(System.in);
              String m = s.next().toLowerCase();
            //Iterate through the ArrayList searching for that student
              if(m.matches("quit")) {
                  loop= 1;
                  continue;
              }
              //if specified student is found, set x as that student
                for(int i=0; i<students.size();i++) {
                    if(m.matches(students.get(i).getName())) {
                      x = students.get(i);
                    //increment the counter to determine the number of matches found   
                      counter++;
                    //add the match to ArrayList matches.  This will be used if multiple matches are found  
                      matches.add(x);
                    }
                }
            //If there is no student by that name, inform the user
              if(x==null) {
                  System.out.println("There is no one in the system by that name");
                //prompt the user to search again or quit to the main menu.
                  int t = 0;
                  while (t !=1) {
                    System.out.println("Would you like to try again? y/n");
                    Scanner l = new Scanner(System.in);
                    String p = l.next();
                    switch(p) {
                        case "y": t=1;
                           break;
                        case "n": t=1; 
                                  loop = 1; 
                           break;
                      //if command entered is not y or n, inform the user and reiterate to re-prompt the user  
                        default: System.out.println("That is not a valid command.  Please enter y or n.");      
                    }
                  }
              } 
              else { 
            //If the specified record does exist, print out his/her information  
                //if multiple matches exist, ask the user to choose one.
                  if(counter > 1) { 
                      System.out.println("There are multiple students with the name you searched for.");
                    //iterate through the matches ArrayList and display the records of the students who matched the user's search  
                      for(int i=0; i <matches.size(); i++) {
                          int number = i+1;
                          System.out.print(number + ") "); 
                          this.showRecord(matches.get(i));
                      }
                    //receive the number of the student the user chose   
                      int choice = this.getIntBetween("Please choose the number of the student you are searching for.", s, 1, matches.size());
                    //instantiate x as the Student the user chose 
                      x=matches.get(choice-1);
                  }
                //unset the matches ArrayList as it is no longer needed
                  matches.removeAll(matches);
                //reset counter to 0 for future searches
                  counter = 0;
                //display the chosen student's records  
                  this.showRecord(x);
                  
                //Prompt the user to search for a different student, update the current student or return to the main menu  
                  System.out.println("To search for another record enter 'search'." + br 
                                   + "To change this record enter 'update'." + br 
                                   + "To return to the main menu enter any key.");
                //take input from user    
                  Scanner e = new Scanner(System.in);
                  String q = e.next();
                  switch(q) {
                    //if user typed 'search', reloop  
                      case "search": continue;
                    //if user typed 'update', call the update function
                      case "update": this.update(students, x);
                         break;
                    //if input is not 'search' or 'update', break out of the loop to go back to the main menu  
                      default: loop = 1;
                  }
              } 
          }
    }
    
    public void showRecord(Student x) { 
    //Displays the name, grades and average for the given student 
        //Change the fist letter of the name to uppercase  
          String name = this.firstToUpper(x.getName());
              //String lowerName = x.getName();
              //String name = Character.toUpperCase(lowerName.charAt(0)) + lowerName.substring(1);
        //Display the information  
          System.out.println("Name: " + name 
                         + " | Grades: " + x.getGrades()+ " | " 
                         + "Average: " + x.getAverage() + br);
    }
    
    public void update(ArrayList<Student> students, Student x) {
    //allows the user to add grades, change grades and change the name of the given student  
       //loop through the menu until the user has chosen a function or quit  
        int loop = 0;
        while(loop !=1) {
          //prompt the user to choose how they want to update the student's record
            System.out.println("Please choose from the following options" + br 
                             + "'add' - to add grades" + br
                             + "'chgrade' - to modify the student's grades"  + br
                             + "'chname' - to change the student's name" + br
                             + "'quit' - to return to the search menu");
          //take user's chosen command and call the corresponding function 
            Scanner s = new Scanner(System.in);    
            String q = s.next();  
            switch(q) {
                case "add": this.addGrade(x);
                   break;
                case "chgrade": this.changeGrades(x);
                   break;
                case "chname": this.changeName(x);
                   break;
                case "quit": loop = 1;
                   continue;
              //if command is invalid, inform user and reloop      
                default: System.out.println("That command is not valid.  Please try again");
            }
        }
      //find the position in the students ArrayList of the given student  
        int position = students.indexOf(x);
      //remove that student from the student ArrayList  
        students.remove(position);
      //add the Student with the updated information into the students ArrayList 
        students.add(position, x);
    }
    
    public void changeName(Student x) {
    //changes the name of the given Student    
        System.out.println("Please enter the new name for the student");
        Scanner s = new Scanner(System.in);
        String name = s.next().toLowerCase();
        x.changeName(name);
        String newName = this.firstToUpper(x.getName()); 
        System.out.println("The students name has now been updated to " + this.firstToUpper(x.getName()));
    }
    public void changeGrades(Student x) {
    //changes a grade of the given Student
        System.out.println("The students grades are listed below.  PLease enter the number of the score you wish to change");
      //iterate through the grades ArrayList and display the grade with a corresponding number starting from 1  
        for(int i =0;i<x.getGrades().size();i++) {
            int n = i+1;
            System.out.println("Grade " + n + ": " + x.getGrades().get(i));
        }
      //take user's choice of which grade they want to change  
        Scanner s = new Scanner(System.in);
        int gradeNum = 0;
        int choice = 0;
        boolean isValid = false;
        while (isValid==false) {
            if (s.hasNextInt() && s.nextInt() <= x.getGrades().size()) {
                gradeNum = s.nextInt();
                isValid = true;
            }
            else {
                System.out.println("The selection you have entered is not valid.  Please try again.");
            }
        }  
        System.out.println("What would you like to change this grade to?");
      //takes the new value for the grade the user wants to change  
        int newGrade = s.nextInt();
      //remove the chosen grade from the grades ArrayList   
        x.getGrades().remove(gradeNum-1);//position is -1 because the numbers of the grades started from 1
      //replace the chosen grade with the new grade   
        x.getGrades().add(gradeNum-1, newGrade);
        System.out.println("Here are the updated grades" + br
                         +  x.getGrades()); 
      //prompt the user if they want to change any more of the student's grades  
        System.out.println("To change this students grades again enter 'change'." + br
                         + "Enter any other key to return to the update menu");
      //take user's input  
        Scanner z = new Scanner(System.in);
        String q = z.next();
      //if the user typed 'change' recall the function, if not the function returns and the user is returned to the update menu 
        if (q.matches("change")) {
            this.changeGrades(x);
        }
    }
    
    public void list(ArrayList<Student> students) {
    //lists all students in the ArrayList with their information
        System.out.print(br);
        for(int i =0;i<students.size();i++) {
            Student x = students.get(i);
            showRecord(x);
        }
        System.out.println(br + "Enter any key to return to the main menu");
        Scanner ck = new Scanner(System.in);
        String ba = ck.next();
    }
    
    public void add(ArrayList<Student> students) {
    //adds a student record to the ArrayList    
      //loop through the function until the user is done  
        int loop = 0;
        while(loop != 1) {
            System.out.println("Please enter the name of the student you wish to add.");
          //take the name of theStudent that the user wants to add 
            Scanner n = new Scanner(System.in);
          //transform the name to all lowercase to make searching easier  
            String name = n.next().toLowerCase();
          //instantiate a new Student with the name given by the user  
            Student x = new Student(name);
          //transform the first letter of the name to uppercase to display  
            String uName = this.firstToUpper(x.getName());
            System.out.println("You have created a student account for: " + uName + br);
            System.out.println("  To enter grade(s) for this student enter 'y'," +
                               "  otherwise enter any other key.");
          //take the user's choice.  
            Scanner r = new Scanner(System.in);
            String q = r.next();
          //If use chose to add another grade call the addGrade function
            if (q.toLowerCase().matches("y")) {
              this.addGrade(x);
            }
          //add the new Student to the students ArrayList    
            students.add(x);
          //prompt user if they want to add another Student and receive their input 
            System.out.println("Do you have another student to enter? If yes enter 'y', otherwise enter any key to return to the main menu");
          //receive user input   
            Scanner z = new Scanner(System.in);
            q = z.next();
          //if user chooses 'y' reloop through the add function 
            if (q.toLowerCase().matches("y")) {
              continue;
            }
          //otherwise, break out of the loop to return to the main menu  
            loop = 1;
        }    
    }     
    
    public void addGrade(Student x) {
    //adds grades to the given student's record    
      //loops through the function until the user is done  
        int loop = 0;
        while(loop != 1) {
          //take a grade from the user  
            System.out.println("Please enter a grade for this student.");
            Scanner g = new Scanner(System.in);
            x.addGrade(g.nextInt());
          //loop until the user chooses to enter another grade or return to the previous function    
            int t=0;
            while(t!=1) {  
              //prompt the user whether they want to enter another grade or not  
                System.out.println("Do you have another grade for this student?  Please enter 'y' or 'n'");
              //take user input  
                Scanner c = new Scanner(System.in);
                String p = c.next();
                switch(p) {  
                  //if user types 'y', break out of current loop to return to the beginning of the function  
                    case "y": t=1; 
                       break;
                  //if user types 'n', break out of current loop and the addGrade functions loop to return to the caling function  
                    case "n": t=1; 
                              loop = 1;
                              System.out.println("This is the student's current record:");
                            //display the current record of the given student before returning to the calling function  
                              this.showRecord(x);
                       break;     
                  //if user enters something else, inform user and restart current loop 
                    default: System.out.println("That entry is not valid.  Please enter 'y' or 'n'");
                }
          
            }
          
        }
    }   

    public String firstToUpper(String lower) {
    //takes a string and transforms the first letter to uppercase 
        String upper = Character.toUpperCase(lower.charAt(0)) + lower.substring(1);
          return upper;
    }

    public int getIntBetween(String prompt, Scanner sc, int min, int max) {
        int selection = 0;
        boolean isValid = false;
        System.out.println(prompt);
        while (isValid==false) {
            sc.nextLine();
            if (sc.hasNextInt()) {
                int num = sc.nextInt();
                if(num >= min && num <= max) {
                    selection = num;
                    isValid = true;
                }
                else {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                }
            }
            else {
                System.out.println("The selection you have entered is not valid.  Please enter a number between " + min + " and " + max + ".");
            }
        }     
        return selection;
    }



}
