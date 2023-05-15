public class GameLogic 
{
    private Board compboard;

    public GameLogic()
    { 
        compboard = new Board();
    }

    public void play()
    {
        System.out.println(compboard);
    }
}
