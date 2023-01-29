package goosegame;


public interface Cell{
    public boolean canPlay();

    public int getIndex();

    public int bounce(int i);

    public boolean isBusy();

    public void setPlayer(Player p);

    public Player getPlayer();
}