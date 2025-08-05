import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Main{
    
    public void exportCsv(){
        try(PrintWriter writer = new PrintWriter(new File("students.csv"))){
            writer.println("Roll Number - Name - Class - Marks");

            for(Student s: students){
                writer.println(s.rollNumber + "," + s.name + "," + s.sklClass + "," + s.marks );
                System.out.println("Students Data exported Successfully!");
            } 
        }
        catch(Exception e){
            System.out.println("Error Exporting data to CSV, check error refrence: " + e.getMessage());
        }
    }

    private static final String FILE_NAME = "students.dat";

    public void saveData() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {    
            out.writeObject(students);
        } catch (Exception e) {
            System.out.println("❌ Error saving data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadData() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            students = (ArrayList<Student>) in.readObject();
        } catch (Exception e) {
            students = new ArrayList<>();
        }
    }




    private ArrayList<Student>students = new ArrayList<>();
    
    public void showAll(){
        for(Student s: students){
            System.out.println(s);
            System.out.println("");
        }
    }

    public void addStudent(){
        Scanner in = new Scanner(System.in);

        System.out.print("Assign a roll number: ");
        
        int roll = in.nextInt();
        in.nextLine();
        boolean match = false;

        if(roll > 0){
            

            for(Student s: students){
                if(roll == s.rollNumber){
                    match = true;
                }
            }
        }

        if(!match){

            System.out.print("Enter Name: ");
            String name = in.nextLine();

            System.out.print("Enter Class: ");
            String sklClass = in.nextLine();

            System.out.print("Enter marks(optional): ");
            int marks = in.nextInt();
            in.nextLine();

            Student s1 = new Student(roll, marks, sklClass, name);

            students.add(s1);
            saveData();

            System.out.println("Student Added successfully\n\n");

        } else {
            System.out.println("Enter a dinstinct roll number!\n");
            addStudent();
        }
    }
    

    public void viewStudent(){
        
        Scanner in = new Scanner(System.in);
        
        Student s1 = new Student();

        System.out.print("Enter roll number: ");
        int roll = in.nextInt();

        if(roll > 0){
            for(Student s: students){
                if(roll == s.rollNumber){
                    s1 = s;
                }
            }

            if(s1 == null){
                System.out.println("No entry found!\n");
                return;
            }
        }

        

        while(true){
            
            System.out.println(s1);
            System.out.println("[1] Edit Roll\n[2] Edit Name\n[3] Edit Class\n[4] Edit Marks\n[5] Delete record\n[6] Back To Main Menu\n\n");
            
            System.out.print("Enter Selection: ");
            int selection = in.nextInt();
            System.out.println("");

            switch(selection){
                case 1:{
                    System.out.print("\nAssign a roll number: ");
                    int r = in.nextInt();

                    boolean match = false;

                    if(r > 0){
                        for(Student s: students){
                            if(r == s.rollNumber){
                                match = true;
                            }
                        }
                    } else {
                        System.out.println("\nEnter a valid non zero roll number!\n");
                        continue;
                    }

                    if(!match){
                        s1.rollNumber = r;
                        System.out.println("\nRoll Number Changed Successfully!\n");
                        continue;
                    }
                    else {
                        System.out.println("\nAnother student with same roll number found, assign a unique roll number!\n");
                        continue;
                    }
                }
            
                case 2: {
                    in.nextLine();
                    System.out.print("Enter Name: ");
                    String name = in.nextLine();

                    if(name.length() > 1){
                        s1.name = name;
                        System.out.println("\nName Changed Successfully\n");
                        continue;
                    } else{
                        System.out.println("\nEnter a valid name! (Too short for it to be a real name)\n");
                        continue;
                    }
                }

                case 3: {
                    in.nextLine();
                    System.out.print("Enter Class: ");
                    String sklClass = in.nextLine();

                    s1.sklClass = sklClass;
                    System.out.println("\nClass Changed Successfully\n");
                    continue;
                }

                case 4: {
                    in.nextLine();
                    System.out.print("Enter Marks: ");
                    int marks = in.nextInt();

                    if(marks >= 0 && marks <= 100){
                        s1.marks = marks;
                        System.out.println("\nMarks Changed Successfully\n");
                        continue;
                    } else {
                        System.out.println("\nEnter valid marks [0-100]\n");
                        continue;
                    }
                }
            
                case 5: {
                    students.remove(s1);
                    saveData();
                    System.out.println("\nStudent Deleted Successfully\n");
                    return;
                }


                case 6: {
                    return;
                }
            }


        }


    }
    
    
    
    
    
    public static void main(String[] args) {
        
        Main app = new Main();
        app.loadData();

        Scanner input = new Scanner(System.in);

        

        System.out.print("Welcome to St Pauls Students Database System\n");

        while(true){

            System.out.println("[1] View All Students\n[2] Add a new student\n[3] View a student by roll number\n[4] Export to CSV\n[5] Exit\n\n");

            System.out.print("Enter Selection: ");

            int selection;

           try{
            selection = input.nextInt();
           } catch(Exception e){
            System.out.println("Enter a valid selection\n"); 
            input.nextLine(); // Clear the invalid input
            continue;
           }


            if(selection < 1 || selection > 5 ){
                System.out.println("Invalid Selection!\n");
                continue;
            }

            switch(selection){
                
                case 1: {
                    app.showAll();
                    continue;
                }

                case 2: {
                    app.addStudent();
                    continue;
                }

                case 3: {
                    app.viewStudent(); 
                    continue;
                }

                case 4:{
                    app.exportCsv();
                    continue;
                }

                case 5: {
                    System.out.println("Exiting the app...");
                    app.saveData();
                    return;
                }

                default: {
                    System.out.println("Invalid Selection!\n");
                }

            }
        }

    }
}
