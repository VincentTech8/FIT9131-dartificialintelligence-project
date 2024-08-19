/**
* Class which manages the playing of the dart game.
*
* @author Vincent
* @version ver1.0.0
*/
public class DartGame
{
    private Player computerPlayer;
    private Player myPlayer;
    private int totalThrow;
    private int computerEachRoundPoints;
    private int myPlayerEachRoundPoints;

    /**
     * Default constructor which creates the object of the class DartGame.
     *
     */
    public DartGame()
    {
        this.computerPlayer = new Player();
        this.myPlayer = new Player("unknown", 0);
        this.totalThrow = 0;
        this.computerEachRoundPoints = 0;
        this.myPlayerEachRoundPoints = 0;
    }

    /**
     * Non-default constructor which creates the object of the class DartGame.
     * 
     * @param computerPlayer            Accepts the computer as a Player class object.
     * @param myPlayer                  Accepts the player as a Player class object.
     * @param totalThrow                Accepts the total throw as an integer.
     * @param computerEachRoundPoints   Accepts the computer each round points as an integer.
     * @param myPlayerEachRoundPoints   Accepts the player each round points as an integer.
     */
    public DartGame(Player computerPlayer, Player myPlayer, int totalThrow, 
                    int computerEachRoundPoints, int myPlayerEachRoundPoints)
    {
        this.computerPlayer = computerPlayer;
        this.myPlayer = myPlayer;
        this.totalThrow = totalThrow;
        this.computerEachRoundPoints = computerEachRoundPoints;
        this.myPlayerEachRoundPoints = myPlayerEachRoundPoints;
    }

    /**
     * Method that calculates the throwing points of a dart.
     *
     * @return                      The throwing points of a dart as an integer.
     */
    public int calculateThrowingPoints()
    {
        DartThrow objDartThrow = new DartThrow();
        Validation objValidation = new Validation();
        double boardOutcome = objDartThrow.generateRandomNumberDecimals(1, 100);
        int insideBoardOutcome = objDartThrow.generateRandomNumberInteger(1, 100);
        if (boardOutcome <= (Math.PI / 4 * 100)) // Space in /
        {
            if (insideBoardOutcome <= 4)
            {
                return 5;
            }
            else if (objValidation.isIntegerValueWithinRange(insideBoardOutcome, 5, 20))
            {
                return 2;
            }
            else
            {
                return 1;
            }
        }
        else
        {
            return 0;
        }
    }

    /**
     * Display method to print the state of the object.
     *
     */
    public void display()
    {
        this.computerPlayer.display();
        this.myPlayer.display();
        System.out.println("Total Throw: " + this.getTotalThrow());
        System.out.println("Computer Each Round Points: " + 
        this.getComputerEachRoundPoints());
        System.out.println("Player Each Round Points: " + 
        this.getMyPlayerEachRoundPoints());
    }

    /**
     * Method that displays the result for the end the game.
     *
     * @param displayOption         Accepts the display option as an integer.
     */
    public void displayEndGameResult(int displayOption)
    {
        System.out.println("Game result");
        System.out.println("===========");
        if (displayOption == 1)
        {
            System.out.println(this.computerPlayer.getName() + " has won this game.");
        }
        else if (displayOption == 2)
        {
            System.out.println(this.myPlayer.getName() + " has won this game.");
        }
        else if (displayOption == 3)
        {
            System.out.println(this.myPlayer.getName() + "'s score is " + 
            this.myPlayer.getScore());
            System.out.println(this.computerPlayer.getName() + "'s score is " +
            this.computerPlayer.getScore());
            if (this.myPlayer.getScore() > this.computerPlayer.getScore())
            {
                System.out.println(this.myPlayer.getName() + " has won this game.");
            }
            else if (this.myPlayer.getScore() < this.computerPlayer.getScore())
            {
                System.out.println(this.computerPlayer.getName() + " has won this game.");
            }
            else //Draw condition
            {
                System.out.println("The game ended as a draw.");
            }
        }
    }

    /**
     * Method that displays the result of a dart throw based on the points.
     *
     * @param points         Accepts the points as an integer.
     */
    public void displayThrowingPointsResult(int points)
    {
        System.out.println("  Throwing the dart...");
        switch (points)
        {
            case 0:
            System.out.println("  Dart has gone outside the board!");
            break;
            case 1:
            System.out.println("  Dart has landed on the blue area.");
            break;
            case 2:
            System.out.println("  Dart has landed on the yellow area.");
            break;
            case 5:
            System.out.println("  Dart has landed on the black area.");
            break;
        }
        System.out.println("  Score for this round: " + points);
    }

    /**
     * Method that displays the welcome to the dart game message.
     *
     */
    public void displayWelcome()
    {
        System.out.println("Welcome to the Dart Game");
        System.out.println("========================");
    }

    /**
     * Accessor method to get the computer each round points.
     *
     * @return              The computer each round points as an integer.
     */
    public int getComputerEachRoundPoints()
    {
        return this.computerEachRoundPoints;
    }

    /**
     * Accessor method to get the object of the computer.
     *
     * @return              The computer as a Player class object.
     */
    public Player getComputerPlayer()
    {
        return this.computerPlayer;
    }

    /**
     * Accessor method to get the object of the player.
     *
     * @return              The player as a Player class object.
     */
    public Player getMyPlayer()
    {
        return this.myPlayer;
    }

    /**
     * Accessor method to get the player each round points.
     *
     * @return              The player each round points as an integer.
     */
    public int getMyPlayerEachRoundPoints()
    {
        return this.myPlayerEachRoundPoints;
    }

    /**
     * Accessor method to get the total throw.
     *
     * @return              The total throw as an integer.
     */
    public int getTotalThrow()
    {
        return this.totalThrow;
    }

    /**
     * Method that begin the program execution.
     *
     * @param args          An array of String passed in as command line parameters.
     */
    public static void main(String[] args)
    {
        DartGame objDartGame = new DartGame();
        objDartGame.play();
    }

    /**
     * Method that initiates the play of the dart game.
     *
     */
    public void play()
    {
        Input objInput = new Input();
        Validation objValidation = new Validation();
        DartThrow objDartThrow = new DartThrow();
        this.displayWelcome();
        this.requestPlayerName();
        System.out.println();
        boolean flag = true;
        while (flag)
        {
            this.requestNumberOfThrow();
            System.out.println("Let's play!\n");
            boolean shouldStop = false;
            for (int i = 1; i < (this.getTotalThrow() + 1) && !shouldStop; i++)
            {
                System.out.println("Dart #" + i);
                System.out.println("=======");
                System.out.println(this.myPlayer.getName() + "'s turn.");
                String userInput = objInput.acceptStringInput("Press any key to throw the " + 
                "dart, or 'X' to abandon this game: ");
                if (!userInput.equals("X"))
                {
                    this.setMyPlayerEachRoundPoints(this.calculateThrowingPoints());
                    this.myPlayer.addScore(this.getMyPlayerEachRoundPoints());
                    this.displayThrowingPointsResult(this.getMyPlayerEachRoundPoints());
                    System.out.println("  Total score: " + this.myPlayer.getScore());
                    int computerAbandon = objDartThrow.generateRandomNumberInteger(1, 100);
                    if (!objValidation.isIntegerValueWithinRange(computerAbandon, 1, 5))
                    {
                        System.out.println(this.computerPlayer.getName() + "'s turn");
                        this.setComputerEachRoundPoints(this.calculateThrowingPoints());
                        this.computerPlayer.addScore(this.getComputerEachRoundPoints());
                        this.displayThrowingPointsResult(this.getComputerEachRoundPoints());
                        System.out.println("  Total score: " + this.computerPlayer.getScore() + "\n");
                        if (i == this.getTotalThrow()) // After final throw's "show result"
                        {
                            this.displayEndGameResult(3);
                            System.out.println();
                            if (this.requestAnotherGame())
                            {
                                this.myPlayer.setScore(0);
                                this.computerPlayer.setScore(0);
                                System.out.println();
                            }
                            else
                            {
                                flag = false;
                                System.out.println("Goodbye!");
                            }
                        }
                    }
                    else
                    {
                        System.out.println(this.computerPlayer.getName() + " has abandoned this game.\n");
                        this.displayEndGameResult(2);
                        System.out.println();
                        if (this.requestAnotherGame())
                        {
                            shouldStop = true;
                            this.myPlayer.setScore(0);
                            this.computerPlayer.setScore(0);
                            System.out.println();
                        }
                        else
                        {
                            shouldStop = true;
                            flag = false;
                            System.out.println("Goodbye!");
                        }
                    }
                }
                else
                {
                    System.out.println(this.myPlayer.getName() + " has abandoned this game.\n");
                    this.displayEndGameResult(1);
                    System.out.println();
                    if (this.requestAnotherGame())
                    {
                        shouldStop = true;
                        this.myPlayer.setScore(0);
                        this.computerPlayer.setScore(0);
                        System.out.println();
                    }
                    else
                    {
                        shouldStop = true;
                        flag = false;
                        System.out.println("Goodbye!");
                    }
                }
            }
        }
    }

    /**
     * Method that requests the player for another game after completion.
     *
     * @return              The converted input from the player as a boolean.
     */
    public boolean requestAnotherGame()
    {
        Input objInput = new Input();
        boolean flag = true;
        boolean result = true;
        do
        {
            String userInput = objInput.acceptStringInput("Play another game (Y/N)? ");
            if (userInput.length() == 1)
            {
                if (userInput.toLowerCase().equals("y"))
                {
                    flag = false;
                    result = true;
                }
                else if (userInput.toLowerCase().equals("n"))
                {
                    flag = false;
                    result = false;
                }
                else
                {
                    System.out.println("Invalid input: Enter a valid character!");
                }
            }
            else
            {
                System.out.println("Invalid input: Only one character is allowed!");
            }
        } while (flag);
        return result;
    }

    /**
     * Method that requests the player for how many number of darts to throw.
     *
     */
    public void requestNumberOfThrow()
    {
        Input objInput = new Input();
        Validation objValidation = new Validation();
        boolean flag = true;
        do
        {
            String userInput = objInput.acceptStringInput("How many darts? ");
            if (!objValidation.isOnlyInteger(userInput))
            {
                System.out.println("Invalid input: Please enter a number.");
            }
            else if (!objValidation.isIntegerValueWithinRange(Integer.parseInt(userInput), 1, 5))
            {
                System.out.println("Invalid input: Number must be between 1 and 5.");
            }
            else
            {
                flag = false;
                this.totalThrow = Integer.parseInt(userInput);
            }
        } while (flag);
    }

    /**
     * Method that requests the name of the player.
     *
     */
    public void requestPlayerName()
    {
        Input objInput = new Input();
        Validation objValidation = new Validation();
        boolean flag = true;
        do
        {
            String userInput = objInput.acceptStringInput("Enter player name: ");
            if (objValidation.isBlank(userInput))
            {
                System.out.println("Player name must not be blank!");
            }
            else if (!objValidation.isNoInteger(userInput))
            {
                System.out.println("Player name must only contain characters!");
            }
            else if (!objValidation.isOnlyLowerCaseLetter(userInput))
            {
                System.out.println("Player name must only contains lowercase characters!");
            }
            else if (!objValidation.isNoWhitespace(userInput))
            {
                System.out.println("Player name must only one word!");
            }
            else if (!objValidation.isStringLengthWithinRange(userInput, 1, 8))
            {
                System.out.println("Player name must have no more than 8 characters!");
            }
            else
            {
                flag = false;
                this.myPlayer.setName(userInput);
            }
        } while (flag);
    }

    /**
     * Mutator method to set the computer each round points.
     *
     * @param computerEachRoundPoints   Accepts the computer each round points as an integer.
     */
    public void setComputerEachRoundPoints(int computerEachRoundPoints)
    {
        this.computerEachRoundPoints = computerEachRoundPoints;
    }

    /**
     * Mutator method to set the object of the computer.
     *
     * @param computerPlayer            Accepts the computer as a Player class object.
     */
    public void setComputerPlayer(Player computerPlayer)
    {
        this.computerPlayer = computerPlayer;
    }

    /**
     * Mutator method to set the object of the player.
     *
     * @param myPlayer                  Accepts the player as a Player class object.
     */
    public void setMyPlayer(Player myPlayer)
    {
        this.myPlayer = myPlayer;
    }

    /**
     * Mutator method to set the player each round points.
     *
     * @param myPlayerEachRoundPoints   Accepts the player each round points as an integer.
     */
    public void setMyPlayerEachRoundPoints(int myPlayerEachRoundPoints)
    {
        this.myPlayerEachRoundPoints = myPlayerEachRoundPoints;
    }

    /**
     * Mutator method to set the total throw.
     *
     * @param totalThrow                Accepts the total throw as an integer.
     */
    public void setTotalThrow(int totalThrow)
    {
        this.totalThrow = totalThrow;
    }

    /**
     * Method to return the state of the object.
     *
     * @return              The state of the object as a String.
     */
    public String toString()
    {
        return (this.computerPlayer.toString() + "\n" + this.myPlayer.toString() + 
        "\nTotal Throw: " + this.getTotalThrow() + "\nComputer This Round" +
        "Points: " + this.getComputerEachRoundPoints() + "\nPlayer This Round" +
        "Points: " + this.getMyPlayerEachRoundPoints());
    }
}
