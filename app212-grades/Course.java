import java.util.ArrayList;
/**
 * This class stores information about a course
 * that enrolled students may want to complete
 *
 * @author Derek Peacock, Nicholas Day and Joshua Sweeney
 * @version 0.2 15/Oct/2021
 */
public class Course
{
    public final static int MAXN_MODULES = 4;
    
    public ArrayList<Module> modules;
    
    private String code;
    private String title;
    
    private Grades finalGrade;
     
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
        
        modules  = new ArrayList<Module>();
        
        createModules();
    }

    /**
     * Create four modules and add them to the
     * modules list for testing purposes.  These
     * must be your four modules.
     */
    public void createModules()
    {
        Module computerArchitectures = new Module("CO450", "Computer Architectures");
        Module networking = new Module("CO451", "Networking");
        Module programmingConecepts = new Module("CO452", "Programming Concepts");
        Module webDevelopment = new Module("CO456", "Web Development");

        this.addModule(computerArchitectures);
        this.addModule(networking);
        this.addModule(programmingConecepts);
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
     */
    public Grades calculateGrade(ArrayList<ModuleMark> marks)
    {
        return Grades.NS;
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
