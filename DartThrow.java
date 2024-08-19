/**
* Class which generates a random number within a given range.
*
* @author Vincent
* @version ver1.0.0
*/
public class DartThrow
{
    private double minimumNumber;
    private double maximumNumber;

    /**
     * Default constructor which creates the object of the class DartThrow.
     *
     */
    public DartThrow()
    {
        this.minimumNumber = Double.MIN_VALUE;
        this.maximumNumber = Double.MAX_VALUE;
    }

    /**
     * Non-default constructor which creates the object of the class DartThrow.
     * 
     * @param minimumNumber          Accepts the minimum number as a double.
     * @param maximumNumber          Accepts the maximum number as a double.
     */
    public DartThrow(double minimumNumber, double maximumNumber)
    {
        this.minimumNumber = minimumNumber;
        this.maximumNumber = maximumNumber;
    }

    /**
     * Display method to print the state of the object.
     *
     */
    public void display()
    {
        System.out.println("Minimum Number: " + this.getMinimumNumber());
        System.out.println("Maximum Number: " + this.getMaximumNumber());
    }

    /**
     * Method that generates a random number with its decimals.
     *
     * @return                      The random number as a double.
     */
    public double generateRandomNumberDecimals()
    {
        double range = (this.maximumNumber - this.minimumNumber) + 1;
        double result = this.minimumNumber + (double)(Math.random() * range);
        while (result > this.maximumNumber)
        {
            result = this.minimumNumber + (double)(Math.random() * range);
        }
        return result;
    }

    /**
     * Method that generates a random number with its decimals.
     *
     * @param minimumNumber         Accepts the minimum number as a double.
     * @param maximumNumber         Accepts the maximum number as a double.
     *
     * @return                      The random number as a double.
     */
    public double generateRandomNumberDecimals(double minimumNumber, double maximumNumber)
    {
        double range = (maximumNumber - minimumNumber) + 1;
        double result = minimumNumber + (double)(Math.random() * range);
        while (result > maximumNumber)
        {
            result = minimumNumber + (double)(Math.random() * range);
        }
        return result;
    }

    /**
     * Method that generates a random number without its decimals.
     *
     * @return                      The random number as an integer.
     */
    public int generateRandomNumberInteger()
    {
        double range = (this.maximumNumber - this.minimumNumber) + 1;
        return (int)((Math.random() * range) + this.minimumNumber);
    }

    /**
     * Method that generates a random number without its decimals.
     *
     * @param minimumNumber         Accepts the minimum number as an integer.
     * @param maximumNumber         Accepts the maximum number as an integer.
     *
     * @return                      The random number as an integer.
     */
    public int generateRandomNumberInteger(int minimumNumber, int maximumNumber)
    {
        double range = (maximumNumber - minimumNumber) + 1;
        return (int)((Math.random() * range) + minimumNumber);
    }

    /**
     * Accessor method to get the maximum number.
     *
     * @return                      The maximum number as a double.
     */
    public double getMaximumNumber()
    {
        return this.maximumNumber;
    }

    /**
     * Accessor method to get the minimum number.
     *
     * @return                      The minimum number as a double.
     */
    public double getMinimumNumber()
    {
        return this.minimumNumber;
    }

    /**
     * Mutator method to set the maximum number.
     *
     * @param maximumNumber         Accepts the minimum number as a double.
     */
    public void setMaximumNumber(double maximumNumber)
    {
        this.maximumNumber = maximumNumber;
    }

    /**
     * Mutator method to set the minimum number.
     *
     * @param minimumNumber         Accepts the minimum number as a double.
     */
    public void setMinimumNumber(double minimumNumber)
    {
        this.minimumNumber = minimumNumber;
    }

    /**
     * Method to return the state of the object.
     *
     * @return                      The state of the object as a String.
     */
    public String toString()
    {
        return ("Minimum Number: " + this.getMinimumNumber() + "\nMaximum Number: " + 
        this.getMaximumNumber());
    }
}
