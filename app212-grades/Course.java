import java.util.ArrayList;
/**
 * This class stores information about a course
 * that enrolled students may want to complete
 *
 * @author Derek Peacock & Nicholas Day
 * @author Modified by Joshua Sweeney
 * @version 0.3 4/Nov/2021
 */
public class Course
{
    // Defines the maxinum number of modules for a course
    public final static int MAXN_MODULES = 4;
    
    // A list of the modules present on this course
    public ArrayList<Module> modules;
    
    private String code;
    private String title;
    
    // The final grade calculated by the average marks of 
    // the 4 modules
    private Grades finalGrade;
     
    /**
     * Constructor that creates a predefined course
     */
    public Course()
    {
        this("G400", "BSc Computing");
    }
    
    /**
     * Constructor for objects of class Course
     */
    public Course(String code, String title)
    {
        // initialise instance variables
        this.code = code;
        this.title = title;
        
        // Create a new list of modules
        modules = new ArrayList<Module>();
    }

    /**
     * Create four modules and add them to the
     * modules list for testing purposes.  These
     * must be your four modules.
     */
    public void createModules()
    {
        Module computerArchitectures = new Module("CO450", "Computer Architectures");
        // Use \t in the name so the course grades table displays correctly
        Module networking = new Module("CO451", "Networking\t");
        Module programmingConcepts = new Module("CO452", "Programming Concepts");
        // Use \t in the name so the course grades table displays correctly
        Module webDevelopment = new Module("CO456", "Web Development\t");

        this.addModule(computerArchitectures);
        this.addModule(networking);
        this.addModule(programmingConcepts);
        this.addModule(webDevelopment);
    }
    
    /**
     * Adds a module to this course.
     * Only allows 4 courses to be added as defined by MAXN_MODULES
     */
    public void addModule(Module module)
    {
        if(modules.size() < MAXN_MODULES)
        {
            modules.add(module);
        }
    }
    
    /**
     * Converts and returns a percentage mark to a final grade
     * @return the value of the converted grade
     */
    public Grades convertToGrade(int mark)
    {
        if (mark >= 0 && mark <= 39)
            return Grades.NS;
        else if (mark >= 40 && mark <= 49)
            return Grades.F;
        else if (mark >= 50 && mark <= 59)
            return Grades.D;
        else if (mark >= 60 && mark <= 69)
            return Grades.B;
        else if (mark >= 70 && mark <= 100)
            return Grades.A;
        else // If an invalid grade was passed in, return 0 (Grades.NS)
            return Grades.NS;
    }
    
    /**
     * Calculate the average mark from the four module marks
     * and convert that into a final grade.
     * @return the final grade of this course
     */
    public Grades calculateGrade(ArrayList<ModuleMark> marks)
    {
        int markSum = 0;

        for (ModuleMark moduleMark : marks)
        {
            markSum += moduleMark.getMark();
        }

        int averageMark = markSum / marks.size();

        finalGrade = convertToGrade(averageMark);

        return finalGrade;
    }
    
    /**
     * Prints out the details of a course and the
     * four modules
     */
    public void print()
    {
        System.out.println();
        System.out.println(" Course " + code + ": " + title);
        System.out.println();

        printModules();
    }
    
    /**
     * Print the course's four modules
     */
    public void printModules()
    {
        for (Module module : modules)
        {
            module.print();
        }
    }
}
