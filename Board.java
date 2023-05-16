public class Board 
{
    private boolean[][] board = new String[8][8];

    public Board()
    {
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                board[i][j] = false;
            }
        }

        /* test for string board
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                if (j == 7) //if the index is at the last column, don't add a space
                {
                    board[i][j] = "|";
                }
                else
                {
                    board[i][j] = "| ";
                }
            }
        }
        */
    }

    public String toString()
    {
        
        int count = 0;
        String boardString = "   0 1 2 3 4 5 6 \n";
        for (int i = 0; i < board.length; i++)
        {
            boardString += count + " ";
            for (int j = 0; j < board[0].length; j++)
            {
                if (!b && j < 7)
                {
                    boardString += "| ";
                }
                else if (!b && j == 7)
                {
                    boardString += "|";
                }
            }
            boardString += "\n";
            count++;
        }

        /* test for string board
        for (String[] row : board)
        {
            boardString += count + " ";
            for (String s : row)
            {
                boardString += s;
            }
            boardString += "\n";
            count++;
        }
        boardString += "  ---------------";

        return boardString;
        */
        //return null; //place holder

        return boardString;
    }   
}
