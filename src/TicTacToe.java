import java.util.Scanner;
public class TicTacToe {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board [][] = new String[ROW][COL];

    public static void main(String[] args)
    {
        boolean finished = false;
        boolean playing = true;
        Scanner in = new Scanner(System.in);
        String player = "X";
        int moveCnt = 0;
        int row = -1;
        int col = -1;
        final int MOVES_FOR_WIN = 5;
        final int MOVES_FOR_TIE = 7;

        do // this is the program loop
        {
            //now we begin a game
            player = "X";
            playing = true;
            moveCnt = 0;
            clearBoard();

            do //this is the game loop
            {
                do// this loop gets the move
                {
                    display();
                    System.out.println("Enter the move for " + player);
                    row = SafeInput.getRangedInt(in, "Enter the row ", 1, 3);
                    col = SafeInput.getRangedInt(in, "Enter the column ", 1, 3);
                    row--; col--;
                }while(!isValidMove(row, col));

                board[row][col] = player;
                moveCnt++;

                if(moveCnt >= MOVES_FOR_WIN)
                {
                    if(isWin(player))
                    {
                        display();
                        System.out.println("Player " + player + " wins!");
                        playing = false;
                    }
                }
                if(moveCnt >= MOVES_FOR_TIE)
                {
                    if(isTie())
                    {
                        display();
                        System.out.println("It's a Tie!");
                        playing = false;
                    }
                }
                if(player.equals("X"))
                {
                    player = "O";
                }
                else
                {
                    player = "X";
                }

            }while(playing);

            finished = SafeInput.getYNConfirm(in, "done playing? ");

        }while(!finished);
    }

    /** sets all the board elements to a space
     *
     */
    private static void clearBoard()
    {
        for(int row = 0; row < ROW; row++)
        {
            for(int col = 0; col < COL; col++)
            {
                board[row][col] = " ";
            }
        }
    }

    /** shows the TicTacToe games used as part of the prompt for the users move choice
     *
     */
    private static void display()
    {
        for(int row = 0; row < ROW; row++)
        {
            System.out.print("| ");
            for(int col = 0; col < COL; col++)
            {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }

    /** returns true if there is a space at the given proposed move coordinates which means it is a legal move
     *
     * @param row the number of rows in the display
     * @param col the number of cols in the display
     * @return
     */
    private static boolean isValidMove(int row, int col)
    {
        boolean retVal = false;
        if(board[row][col].equals(" "))
        {
            retVal = true;
        }
        return retVal;
    }

    /**
     * checks to see if there is a win state on the current board for the specified player (X or O)
     * this method in turn calls three additional methods that break down the 3 kinds of wins that are possible
     *
     * @param player
     * @return
     */
    private static boolean isWin(String player)
    {
        if(isColWin(player) || isRowWin(player) || isDiagonalWin(player))
        {
            return true;
        }
        return false;
    }

    /**
     * checks for a col win for a specified player
     *
     * @param player indicates if it is player x or player o
     * @return
     */
    private static boolean isColWin(String player)
    {
        for(int col = 0; col < COL; col++)
        {
            if (board[0][col].equals(player) &&
                    board[1][col].equals(player) &&
                    board[2][col].equals(player))
            {
                return true;
            }
        }
        return false; // no col win
    }

    /**
     * checks for row win for the specified player
     *
     * @param player indicates if it is player x or player o
     * @return
     */
    private static boolean isRowWin(String player)
    {
        for (int row = 0; row < ROW; row++)
        {
            if(board[row][0].equals(player) &&
                    board[row][1].equals(player) &&
                    board[row][2].equals(player))
            {
                return true;
            }
        }
        return false; // no row win
    }

    /**
     * checks for a diagonal win for the specified player
     *
     * @param player indicates if it is player x or player o
     * @return
     */
    private static boolean isDiagonalWin(String player)
    {
        if(board[0][0].equals(player) &&
                board[1][1].equals(player) &&
                board [2][2].equals(player))
        {
            return true;
        }
        return false;
    }

    /**
     * checks for a tie condition: all spaces are filled OR there is both an x and o in every vector
     * (all possible 8 wins are blocked by having both X and o in them)
     * checks for the win first to be efficient
     * checks for a tie before board is filled
     *
     * @return
     */
    private static boolean isTie()
    {
        boolean xFlag = false;
        boolean oFlag = false;
        for(int row = 0; row < ROW; row++)
        {
            if(board[row][0].equals("X") ||
                    board[row][1].equals("X") ||
                    board[row][2].equals("X"))
            {
                xFlag = true; //three is an x in this row
            }
            if(board[row][0].equals("O") ||
                    board[row][1].equals("O") ||
                    board[row][2].equals("O"))
            {
                oFlag = true; // there is an O in this row
            }

            if(! (xFlag && oFlag) )
            {
                return false; // no tie can still have a row win
            }
            xFlag = oFlag = false;
        }
        //now scan the columns
        for (int col = 0; col < COL; col++)
        {
            if(board[0][col].equals("X") ||
                    board[1][col].equals("X") ||
                    board[2][col].equals("X"))
            {
                xFlag = true; //three is an x in this col
            }
            if(board[0][col].equals("O") ||
                    board[1][col].equals("O") ||
                    board[2][col].equals("O"))
            {
                oFlag = true; // there is an O in this col
            }

            if(! (xFlag && oFlag) )
            {
                return false; // no tie can still have a col win
            }
        }
        //now check for the diagonals
        xFlag = oFlag = false;

        if(board[0][0].equals("X") ||
                board[1][1].equals("X") ||
                board[2][2].equals("X"))
        {
            xFlag = true; //three is an x in this col
        }
        if(board[0][0].equals("O") ||
                board[1][1].equals("O") ||
                board[2][2].equals("O"))
        {
            oFlag = true; // there is an O in this col
        }

        if(! (xFlag && oFlag) )
        {
            return false; // no tie can still have a col win
        }

        //checked every vector so I know I have a tie
        return true;

    }





}
