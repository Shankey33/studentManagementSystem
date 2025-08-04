import java.io.Serializable;

public class Student implements Serializable{

    int rollNumber;
    int marks;
    String sklClass;
    String name;


    public Student(int rollNumber, int marks, String sklClass, String name){
        
        this.rollNumber = rollNumber;
        this.name = name;
        this.sklClass = sklClass;
        this.marks = marks;
    }

    public Student(int rollNumber, String sklClass, String name){
        
        this.rollNumber = rollNumber;
        this.name = name;
        this.sklClass = sklClass;
        this.marks = 0;
    }

    public Student(){

    }

    @Override

    public String toString(){
        return (" Name: " + name + " Roll Number: " + rollNumber + " Class: " + sklClass + " marks: " + marks);
    }

}