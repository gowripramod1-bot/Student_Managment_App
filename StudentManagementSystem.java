import java.util.ArrayList;
import java.util.Scanner;

class Student{
    int id;
    String name;
    int age;
    String course;

    Student(int id, String name, int age, String course) {
        this.id=id;
        this.name=name;
        this.age=age;
        this.course=course;
    }
    void display() {
        System.out.println("ID: "+id);
        System.out.println("NAME: "+name);
        System.out.println("AGE: "+age);
        System.out.println("COURSE: "+course);
    }
}

public class StudentManagementSystem{
    static ArrayList<Student> studentList=new ArrayList<>();
        static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        while(true){
            System.out.println("\n==== Student Management System ====");
            System.out.println("1. Add student");
            System.out.println("2. View student");
            System.out.println("3. Update student");
            System.out.println("4. Delete student");
            System.out.println("5. Exit");
            System.out.println("Enter your choice:");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("exiting...thank you for using the student management system");
                    System.exit(0);
                    break;
                default:
                    System.out.println("invalid choice.please try again");
            }
        }
    }

    public static void addStudent() {
        System.out.println("Enter student ID: ");
        int id = sc.nextInt();
        System.out.println("Enter student name: ");
        String name = sc.next();
        System.out.println("Enter student age: ");
        int age = sc.nextInt();
        System.out.println("Enter student course: ");
        String course=sc.nextLine();
        Student student = new Student(id,name,age,course);
        studentList.add(student);
        System.out.println("Student added successfully");
        
    }

    public static void viewStudents() {
        if(studentList.isEmpty()){
            System.out.println("no students found.");
        }else{
            for(Student student : studentList){
                student.display();
            }
        }
    }

    public static void updateStudent(){
        System.out.println("enter student id to update:");
        int id = sc.nextInt();
        for(Student student : studentList){
            if(student.id == id){
                System.out.println("enter new name: ");
                String name = sc.nextLine();
                System.out.println("enter new age: ");
                int age = sc.nextInt();
                System.out.println("enter new course: ");
                String course = sc.nextLine();
                student.name = name;
                student.age = age;
                student.course = course;
                System.out.println("student updated successfully.");
                return;
                
            }

        }
        System.out.println("student not found.");
    } 
    
    public static void deleteStudent(){
        System.out.println("enter student id to delete:");
        int id = sc.nextInt();
        for(Student student : studentList){
            if(student.id == id){
                studentList.remove(student);
                System.out.println("student deleted successfully.");
                return;
            }
        }
        System.out.println("student not found.");
    }
}