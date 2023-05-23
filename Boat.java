public class Boat 
{   
    private boolean hit;
    private boolean sunk;
    private int boatNum;
    private int boatID;

    public Boat(int bNum)
    {
        boatNum = bNum;
        boatID = bNum;
        hit = false;
        sunk = false;
    }

    public void sink()
    {
        sunk = true;
    }

    public void hit()
    {
        hit = true;
    }

    public void setBoatNum(int num)
    {
        boatNum = num;
    }

    public int getBoatNum()
    {
        return boatNum;
    }

    public int getBoatID()
    {
        return boatID;
    }

    public boolean isHit()
    {
        return hit;
    }
}

