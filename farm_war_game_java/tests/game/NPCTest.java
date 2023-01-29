package game; 

import org.junit.Before;

import game.character.*;
import game.factory.WarFactory;
import game.strategy.*;
import game.tile.*;
import game.util.Position;
import game.util.TooMuchSoldierException;
import game.players.*;

public abstract class NPCTest{

	protected TileExceptOcean tile;
    protected NPC npc;
    protected Player playerF;
    protected Player playerW;
    protected TileExceptOcean tile2;
	protected Army army;
	protected Farmer farmer;
	protected Strategy strategyF;
	protected Strategy strategyW;
	protected Factory factory;


    @Before
    public void Before() throws TooMuchSoldierException{
    	this.factory = new WarFactory();
        this.tile = new Desert(new Position(1,3), this.factory);
        this.strategyF = new RandomStrategyFarm(null);
        this.strategyW = new RandomStrategyWar(null);
        this.playerF = new FarmPlayer("Kevin", strategyF);
        this.playerW = new WarPlayer("Kevin", strategyW);
        this.npc = createNPC(); 
        this.tile2 = new Grassland(new Position(5,1), this.factory);
        this.army = new Army(tile, this.playerW, 2);
        this.farmer = new Farmer(tile2,this.playerF);
    }

    protected abstract NPC createNPC() throws TooMuchSoldierException;
    
    


    

}