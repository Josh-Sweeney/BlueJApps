
/**
 * This class contains information and methods 
 * about a module which is a part of a class
 *
 * @author Joshua Sweeney
 * @version v3.0 15/10/21
 */
public class Module
{
    // The code of this module
    public String code;
    // The title of this module
    public String title;
    // The credit value of this module
    public int creditValue = 0;

    /**
     * This is a contructor method to create a Module
     * with the module code and title
     * Credit value is 0 by default
     */
    public Module(String code, String title)
    {
        this.code = code;
        this.title = title;
    }

    /* 
     * Gets the code of this course
     */
    public String getCode()
    {
        return this.code;
    }

    /* 
     * Gets the title of this course
     */
    public String getTitle()
    {
        return this.title;
    }

    /* 
     * Gets the credit value of this course
     */
    public int getCreditValue()
    {
        return this.creditValue;
    }

    /*
     * Sets the credit value of this course
     */
    public void setCreditValue(int newCreditValue)
    {
        this.creditValue = newCreditValue;
    }
    
    /*
     * Prints all of the details of this module
     */
    public void print()
    {
        printHeading();
        System.out.println(" Module Code: " + this.code);
        System.out.println(" Module Title: " + this.title);
        System.out.println(" Module Credit Value: " + this.creditValue);
    }
    
    /**
     * Prints the heading for the details of this module
     */
    private void printHeading()
    {
        System.out.println(" --------------------------------");
        System.out.println("   App211: Module Details");
        System.out.println(" --------------------------------");
        System.out.println();
    }
}
