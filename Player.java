/**
* This class stores the attributes and behaviours of players.
*
* @author Vincent
* @version ver1.0.0
*/
public class Player
{
    private String name;
    private int score;
    
    /**
     * Default constructor which creates the object of the class Player.
     *
     */
    public Player()
    {
        this.name = "Dart Vader";
        this.score = 0;
    }

    /**
     * Non-default constructor which creates the object of the class Player.
     * 
     * @param name          Accepts the name of the player as a String.
     * @param score         Accepts the score of the player as a String.
     */
    public Player(String name, int score)
    {
        this.name = name;
        this.score = score;
    }

    /**
     * Method that adds the score of the player by a given points.
     *
     * @param points         Accepts the points as an integer.
     */
    public void addScore(int points)
    {
        this.score += points;
    }

    /**
     * Display method to print the state of the object.
     *
     */
    public void display()
    {
        System.out.println("Player Name: " + this.getName());
        System.out.println("Score: " + this.getScore());
    }

    /**
     * Accessor method to get the name of the player.
     *
     * @return              The name of the player as a String.
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Accessor method to get the score of the player.
     *
     * @return              The score of the player as an integer.
     */
    public int getScore()
    {
        return this.score;
    }

    /**
     * Mutator method to set the name of the player.
     *
     * @param name          Accepts the name of the player as a String.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Mutator method to set the score of the player.
     *
     * @param score         Accepts the score of the player as an integer.
     */
    public void setScore(int score)
    {
        this.score = score;
    }

    /**
     * Method to return the state of the object.
     *
     * @return              The state of the object as a String.
     */
    public String toString()
    {
        return "Player Name: " + this.getName() + "\nScore: " + this.getScore();
    }
}
