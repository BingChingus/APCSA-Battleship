import java.util.Scanner;

public class Boardcopy
{
    private Scanner scan = new Scanner(System.in);
    private Boat[][] board = new Boat[8][8];

    int boatCount = 5;
    int fiveBoat = 5;
    int fourBoat = 4;
    int threeBoat1 = 3;
    int threeBoat2 = 3;
    int twoBoat = 2;
    
    public Boardcopy()
    {
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                board[i][j] = null;
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
                int row = (int) (Math.random() * board.length);
                int col = (int) (Math.random() * (board[0].length - boat - 1));
                for(int i = col; i < boat + col; i++)
                {
                    if(board[row][i] != null)
                    {
                        goodPlace = false;
                    }
                }

                if(goodPlace)
                {
                    for(int i = col; i < boat + col; i++)
                    {
                        board[row][i] = new Boat(boat);
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
                        if(board[i][col] != null)
                        {
                            goodPlace = false;
                        }
                    }

                    if(goodPlace)
                    {
                        for(int i = row; i < boat + row; i++)
                        {
                            board[i][col] = new Boat(boat);
                        }
                        placed = true;
                    }
                }
        }   
    }

    public void guess()
    {
        int r = scan.nextInt();
        int c = scan.nextInt();

        if(board[r][c] != null)
        {
            for(Boat[] row : board)
            {
                for(Boat b : row)
                {
                    if(b != null && b.getBoatID() == board[r][c].getBoatID())
                    {
                        b.setBoatNum(b.getBoatNum() - 1);
                    }
                    else if(b != null && b.getBoatID() == board[r][c].getBoatID() && b.getBoatNum() == 0)
                    {
                        b.sink();
                    }
                }
            }
            board[r][c].hit();
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
                if (board[i][j] == null && j < 7)
                {
                    boardString += "| ";
                }
                else if (board[i][j] == null && j == 7)
                {
                    boardString += "|";
                }
                else if (board[i][j] != null && board[i][j].isHit())
                {
                    boardString += "|#";
                }
                else if (board[i][j] != null && j < 7)
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
