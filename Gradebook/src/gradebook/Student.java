package gradebook;

import java.util.ArrayList;

public class Student {
    private String name;
    private ArrayList<Integer> grades = new ArrayList<Integer>();
    //public ArrayList<Student> students = new ArrayList<Student>();
    
    public Student(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    public void changeName(String newName) {
        this.name = newName;
    }
    public void addGrade(int grade){
        grades.add(grade);
    }
    
    public ArrayList<Integer> getGrades() {
        return grades;
    }
    public int getAverage() {
        int total = 0;
        for(int grade : grades) {
            //total = total + grade;
            total += grade;
        }
        if (total != 0)
          total /= grades.size();
        return total;
    }
    

}
/*public void addStudent(Student s) {
      int i =0;
      students.add(i, s);
      i++;
    }

   public void showStudents() {
       for(int i =0; i<3; i++){
            System.out.print(students.get(i));
        }
   }*/