import java.util.Scanner;

public class SafeInput
{
    /**
     * get an arbitrary string of at least one character in length
     *
     * @param pipe scanner to use for input
     * @param prompt prompt msg that tells user what to input
     * @return a string response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";
        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        }while(retString.length()==0);

        return retString;
    }

    /**
     * use scanner to get an int from the console with no constraints
     *
     * @param pipe scanner to use for console input
     * @param prompt string prompt that tells the user what to input
     * @return an integer value
     */
    public static int getInt(Scanner pipe, String prompt)
    {
        int retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print(prompt + ": ");
            if(pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                pipe.nextLine();
                done = true;
            }
            else {
                trash = pipe.nextLine();
                System.out.println("you entered: " + trash + ". You must enter a valid val!");
            }
        }while(!done);

        return retVal;
    }

    /**
     * use scanner to get a double from the console with no constraints
     *
     * @param pipe scanner to use for console input
     * @param prompt string prompt that tells the user what to input
     * @return a double value
     */
    public static double getDouble(Scanner pipe, String prompt)
    {
        double retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + ": ");
            if(pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a double not " + trash);
            }
        }while(!done);

        return retVal;
    }

    /**
     * Get an integer value within a specified range of low - high
     *
     * @param pipe scanner to use for console input
     * @param prompt string that tells the user what to input
     * @param low low value for a range low - high
     * @param high high value for a range low - high
     * @return an int value within the low - high range
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) //returns an int
    {
        int retVal = low - 1;
        String trash = "";

        boolean done = false;
        do {
            System.out.print("\n" + prompt + "[" + low + " - " + high +"] : ");
            if(pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                pipe.nextLine();
                if (retVal >= low && retVal <= high)
                {
                    done = true;
                } else {
                    System.out.println("You said the val is " + retVal + " but that is out of range [" + low + " - " + high + "]");
                }
            } else
            {
                trash = pipe.nextLine();
                System.out.println("you entered: " + trash + ". You must enter a valid val!");
            }
        }while(!done);

        return retVal;
    }

    /**
     * Get a double value within a specified range of low - high
     *
     * @param pipe scanner to use for console input
     * @param prompt string that tells the user what to input
     * @param low low value for a range low - high
     * @param high high value for a range low - high
     * @return a double value within the low - high range
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double retVal = low - 1;
        String trash = "";

        boolean done = false;
        do {
            System.out.print("\n" + prompt + "[" + low + " - " + high +"] : ");
            if(pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                if (retVal >= low && retVal <= high) {

                    done = true;
                } else {
                    System.out.println("You said the val is " + retVal + " but that is out of range [" + low + " - " + high + "]");
                }
            } else
            {
                trash = pipe.nextLine();
                System.out.println("you entered: " + trash + ". You must enter a valid val!");
            }
        }while(!done);

        return retVal;
    }

    /**
     * gets a Y or N from the user and returns a True or False respectively
     *
     * @param pipe scanner to use to get the input
     * @param prompt string prompt for the user the yes/no question
     * @return a boolean value true for Y and false for N
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String respYN = "";
        boolean retVal = false;
        boolean done = false;

        do{
            System.out.print("\n" + prompt + " [Y/N]: ");
            respYN = pipe.nextLine();

            if(respYN.equalsIgnoreCase("Y"))
            {
                retVal = true;
                done = true;
            }
            else if (respYN.equalsIgnoreCase("N"))
            {
                retVal = false;
                done = true;
            }
            else{
                System.out.println("you must enter [Y/N]: ");
            }

        } while(!done);

        return retVal;
    }

    /**
     *gets a string that matches a regular expression pattern like ###-##-### \d{3}-\d{2}-\d{4}
     *
     * @param pipe scanner to use for input
     * @param prompt prompt that tells the user what we want
     * @param pattern A regEx Pattern to use for the test
     * @return a string entered by the user that matches the pattern
     */
    public static String getRegExString(Scanner pipe, String prompt, String pattern)
    {
        String retVal = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + ": ");

            retVal = pipe.nextLine();
            if(retVal.matches(pattern))
            {
                done = true;
            }
            else
            {

                System.out.println("What you entered does not match the pattern: " + pattern);
            }
        }while(!done);

        return retVal;
    }

    public static String prettyHeader(Scanner pipe, String prompt)
    {

        String retVal = "";


        do {
            System.out.print("\n" + prompt + ": ");
            retVal = pipe.nextLine();
            if (retVal.length() == 0) {
                System.out.println("You must have an input");
            }
        } while (retVal.length() == 0);

        int length = retVal.length();
        int space = 54 - length;
        int right = space / 2;
        int left = 0;

        if (space % 2 == 0) {
            left = right;
        } else {
            left = right + 1;
        }

        for (int x = 1; x <= 1; x++)
        {
            for (int y = 1; y <= 60; y++)
            {
                System.out.print("*");
            }
            System.out.println();
            for (int y = 1; y <= 1; y++) {
                System.out.print("***");
                for (int r = 1; r <= right; r++) {
                    System.out.print(" ");
                }
                System.out.print(retVal);
                for (int l = 1; l <= left; l++) {
                    System.out.print(" ");
                }
                System.out.print("***");
            }
            System.out.println();
            for (int y = 1; y <= 60; y++)
            {
                System.out.print("*");
            }
            System.out.println();

        }
        return retVal;

    }

}

