import java.util.*;
import java.util.Random;
/**
 * The Student class represents a student in a student administration system.
 * It holds the student details relevant in our context.
 * 
 * @author Michael Kölling and David Barnes
 * Modified by Derek Peacock, Nicholas Day & Joshua Sweeney
 * @version 2021-10-29
 */
public class Student
{
    // the student ID
    private int id;
    // the student's full name
    private String name;
    // The course the student is enrolled on
    private Course course;
    // The marks awarded for the modules on the course
    private ArrayList<ModuleMark> marks;
    
    /**
     * This constructor creates a new student with a
     * fixed name and id. 
     */
    public Student()
    {
        this("Joshua Sweeney", 22102043);
    }
    
    /**
     * Create a new student with a given name and ID number.
     */
    public Student(String name, int id)
    {
        this.name = name;
        this.id = id;
        
        marks = new ArrayList<ModuleMark>();
    }

    public void addMark(ModuleMark mark)
    {
        marks.add(mark);
    }
    
    /**
     * Find the module by the moduleCode and
     * set its mark to the value
     */
    public void awardMark(String moduleCode, int value)
    {
        for (ModuleMark moduleMark : this.marks)
        {
            Module currentModule = moduleMark.getModule();
            
            if (currentModule.getCode() == moduleCode)
            {
                moduleMark.setMark(value);
            }
        }
    }
    
    /**
     * Set the student's course
     */
    public void enrol(Course course)
    {
        this.course = course;
        awardTestMarks();
    }
    
    /**
     * Award a different pass mark for each of the
     * modules on the enrolled course
     */
    public void awardTestMarks()
    {

    /*
     * Generates a random number between 0 and 100 to be used
       as a mark
    */
    private int randomMark()
    {
        Random random = new Random();
        
        // Returns a random number where 100 is the upper bound
        return random.nextInt(100);
    }
    
    /**
     * Return the full name of this student.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Return the student ID of this student.
     */
    public int getID()
    {
        return id;
    }

        
    /**
     * Print the student's name and ID number to the 
     * output terminal.
     */
    public void print()
    {
        System.out.println(" Student ID: " + id + ", " + name);
    }
    
    public void printCourse()
    {
        this.print();
        course.print();
    }
    /*
     * Prints the modules this student is enrolled on
     */
    private void printModules()
    {
        this.course.printModules();
    }
    
    public void printTranscript()
    {
        System.out.println(" ------------------------------------");
        System.out.println(" App21-02: Exam Board Transcript 2021");
        System.out.println("        by student name");
        System.out.println(" ------------------------------------");
        
        printCourse();
        
        System.out.println();
        System.out.println();
        System.out.println(" ---- \t -------------------- \t ------\t ---- \t -----");
        System.out.println(" Code \t Module \t\tCredit\t Mark \t Grade");
        System.out.println(" ---- \t -------------------- \t ------\t ---- \t -----");
        
       
        Grades finalGrade = course.calculateGrade(marks);
        
        System.out.println();
        System.out.println();
        
        if(finalGrade == Grades.NS)
        {
            System.out.println(" No Final Course Grade Yet!");
        }
        else
        {
            System.out.println(" Final Course Grade = " + finalGrade);
        }
    }
}