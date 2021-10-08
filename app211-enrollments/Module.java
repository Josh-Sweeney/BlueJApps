
/**
 * This class contains information about a Module
 *
 * @author Joshua Sweeney
 * @version v1.0 01/10/21
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
     * Create a Module with the module code and title
     * Credit value is 0 by default
     */
    public Module(String code, String title)
    {
        this.code = code;
        this.title = title;
        this.creditValue = 0;
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
        System.out.println(" Module Code: " + this.code);
        System.out.println(" Module Title: " + this.title);
        System.out.println(" Module Credit Value: " + this.creditValue);
    }
}
