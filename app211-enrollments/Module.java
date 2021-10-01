
/**
 * Write a description of class Module here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Module
{
    // The code of this module
    private String code;
    // The title of this module
    private String title;
    // The credit value of this module
    private int creditValue;

    /**
     * Constructor for objects of class Module
     */
    public Module()
    {
        // initialise instance variables
        x = 0;
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
    public String getCreditValue()
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
        System.out.println(" Module Code: " + this.code);
        System.out.println(" Module Title: " + this.title);
        System.out.println(" Module Credit Value: " + this.creditValue);
    }
}
