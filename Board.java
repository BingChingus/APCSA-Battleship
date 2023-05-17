public class Board 
{
    private boolean[][] board = new boolean[8][8];
    int fiveBoat = 5;
    int fourBoat = 4;
    int threeBoat1 = 3;
    int threeBoat2 = 3;
    int twoBoat = 2;

    public Board()
    {
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                board[i][j] = false;
            }
        }

        placeBoats(fiveBoat);
        placeBoats(fourBoat);
        placeBoats(threeBoat1);
        placeBoats(threeBoat2);
        placeBoats(twoBoat);

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

    public void placeBoats(int boat)
    {
        boolean placed = false;
        int direction = (int) (Math.random() * 2 + 1); //1 = vertical, 2 = horizontal

        if (direction == 1)
        {
            while(!placed)
            {
                boolean goodPlace = true;
                int row = (int) (Math.random() * board.length);
                int col = (int) (Math.random() * (board[0].length - boat - 1));
                for(int i = col; i < boat + col; i++)
                {
                    if(board[row][i])
                    {
                        goodPlace = false;
                    }
                }

                if(goodPlace)
                {
                    for(int i = col; i < boat + col; i++)
                    {
                        board[row][i] = true;
                    }
                    placed = true;
                }
            }
        }

        if (direction == 2)
        {
            while(!placed)
            {
                boolean goodPlace = true;
                int row = (int) (Math.random() * (board.length - boat));
                int col = (int) (Math.random() * (board[0].length - 1));
                for(int i = row; i < boat + row; i++)
                    {
                        if(board[i][col])
                        {
                            goodPlace = false;
                        }
                    }

                    if(goodPlace)
                    {
                        for(int i = row; i < boat + row; i++)
                        {
                            board[i][col] = true;
                        }
                        placed = true;
                    }
                }
        }   
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
                if (!board[i][j] && j < 7)
                {
                    boardString += "| ";
                }
                else if (!board[i][j] && j == 7)
                {
                    boardString += "|";
                }
                else if (board[i][j] && j < 7)
                {
                    boardString += "|x";
                }
            }
            boardString += "\n";
            count++;
        }
        return boardString;

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
    }   
}
