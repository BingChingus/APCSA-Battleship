

public class GameLogic 
{
    private Boardcopy board;
    private PlayerBoard playerBoard;


    public GameLogic()
    { 
        board = new Boardcopy();
        playerBoard = new PlayerBoard();
    }

    public void play()
    {
        while (0 < 1)
        {
        System.out.println(playerBoard);
        System.out.println("  ---------------"); //board length is 17 chars
        System.out.println(board);
        board.guess();
        }
    }
}
