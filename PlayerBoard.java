public class PlayerBoard
{
    private String[][] playerBoard =  new String[8][8];
    int fiveBoat = 5;
    int fourBoat = 4;
    int threeBoat1 = 3;
    int threeBoat2 = 3;
    int twoBoat = 2;

    public PlayerBoard()
    {
        for (int i = 0; i < playerBoard.length; i++)
        {
            for (int j = 0; j < playerBoard[0].length; j++)
            {
                if (j == 7) //if the index is at the last column, don't add a space
                {
                    playerBoard[i][j] = "|";
                }
                else
                {
                    playerBoard[i][j] = "| ";
                }
            }
        }

        placeBoats(fiveBoat);
        placeBoats(fourBoat);
        placeBoats(threeBoat1);
        placeBoats(threeBoat2);
        placeBoats(twoBoat);
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
                int row = (int) (Math.random() * playerBoard.length);
                int col = (int) (Math.random() * (playerBoard[0].length - boat - 1));
                for(int i = col; i < boat + col; i++)
                {
                    if(playerBoard[row][i] != "| ")
                    {
                        goodPlace = false;
                    }
                }

                if(goodPlace)
                {
                    for(int i = col; i < boat + col; i++)
                    {
                        playerBoard[row][i] = "|x";
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
                int row = (int) (Math.random() * (playerBoard.length - boat));
                int col = (int) (Math.random() * (playerBoard[0].length - 1));
                for(int i = row; i < boat + row; i++)
                    {
                        if(playerBoard[i][col] != "| ")
                        {
                            goodPlace = false;
                        }
                    }

                    if(goodPlace)
                    {
                        for(int i = row; i < boat + row; i++)
                        {
                            playerBoard[i][col] = "|x";
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
        for (String[] row : playerBoard)
        {
            boardString += count + " ";
            for (String s : row)
            {
                boardString += s;
            }
            boardString += "\n";
            count++;
        }

        return boardString;
    }
}
