public class GameLogic 
{
    private Board board;
    private PlayerBoard playerBoard;

    public GameLogic()
    { 
        board = new Board();
        playerBoard = new PlayerBoard();
    }

    public void play()
    {
        System.out.println(board);
        System.out.println("  ---------------"); //board length is 17 chars
        System.out.println(playerBoard);
    }
}
