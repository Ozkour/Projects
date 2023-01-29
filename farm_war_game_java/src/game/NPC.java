package game;

import game.tile.TileExceptOcean;

/**
 * A NPC (Non Player Character) that can be for example a farmer or an Army.
 * They are the units with wich the players are going to play.
 *
 * @author Jeanne Lauwers and Gaelle Fret and Nicolas Kerman and Mina Crapez
 * @version 07/02/2021
 */
public abstract class NPC {

    protected int gold; // The gold of the character
    protected TileExceptOcean position; // The position of the character
    protected Player player; // The player who has the character
    protected int size; // The size of the npc 
    

    /** To build a NPC
     * @param position the tile where we want to deploy the npc
     * @param player the player who has the npc
     */
    protected NPC(TileExceptOcean position,Player player){
        this.position = position;
        this.gold = 0;
        this.player = player;
        this.size = 1;
    }

    /**
     * To get the character's position
     * @return the tile where the character is
     */
    public TileExceptOcean getPosition(){
        return this.position;
    }

    /**
     * To get the character's gold
     * @return the gold of the character
     */
    public int getGold(){
        return this.gold;
    }

    /** To get the character's player
     * @return the character's player
     */
    public Player getPlayer(){
        return this.player;
    }
    
    /** To get the character's size 
     * @return the character's size
     */
    public int getSize(){
        return this.size;
    }
    

    /** To set the character's player
     * @param player the new character's player
     */
    public void setPlayer(Player player){
        this.player = player;
    }

    /**
     * To define a new tile for a character
     * @param tile the new tile in which the character is
     */
    public void setPosition(TileExceptOcean tile){
        this.position = tile;
    }
    

    /**
     * To add gold to the character
     * @param moula the quantity of gold we give to the character
     */
    public void addGold(int moula){
        this.gold += moula;
    }
    
    /**
     * a display for a npc
     * @return a description of the npc
     */
    public abstract String toString();

}
