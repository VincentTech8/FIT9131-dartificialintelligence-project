/**
* Class which validates the condition in the selection statement.
*
* @author Vincent
* @version ver 1.0.0
*/
public class Validation
{
    /**
     * Default constructor which creates the object of the class Validation.
     *
     */
    public Validation()
    {

    }

    /**
     * Method that validates whether it is an empty String object.
     *
     * @return              The result of the validation as a boolean.
     */
    public boolean isBlank(String input)
    {
        if (input.trim().length() == 0)
        {
            return true;
        }
        return false;
    }

    /**
     * Method that validates whether an integer is within a given range.
     *
     * @return              The result of the validation as a boolean.
     */
    public boolean isIntegerValueWithinRange(int input, int lowerBound, int upperBound)
    {
        if (input >= lowerBound && input <= upperBound)
        {
            return true;
        }
        return false;
    }

    /**
     * Method that validates whether there is an integer in the String object.
     *
     * @return              The result of the validation as a boolean.
     */
    public boolean isNoInteger(String input)
    {
        if (input.matches("[a-zA-Z\\s]+"))
        {
            return true;
        }
        return false;
    }

    /**
     * Method that validates whether there is a whitespace in the String object.
     *
     * @return              The result of the validation as a boolean.
     */
    public boolean isNoWhitespace(String input)
    {
        if (input.matches(".*\\s+.*"))
        {
            return false;
        }
        return true;
    }

    /**
     * Method that validates whether the String object only contains an integer value.
     *
     * @return              The result of the validation as a boolean.
     */
    public boolean isOnlyInteger(String input)
    {
        try
        {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e)
        {
            return false;
        }
    }

    /**
     * Method that validates whether a String object only contains a lowercase letter.
     *
     * @return              The result of the validation as a boolean.
     */
    public boolean isOnlyLowerCaseLetter(String input)
    {
        if (input.matches("[a-z\\s]+"))
        {
            return true;
        }
        return false;
    }

    /**
     * Method that validates whether a String object is within a given range.
     *
     * @return              The result of the validation as a boolean.
     */
    public boolean isStringLengthWithinRange(String input, int lowerBound, int upperBound)
    {
        if (input.trim().length() >= lowerBound && input.trim().length() <= upperBound)
        {
            return true;
        }
        return false;
    }
}
