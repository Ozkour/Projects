package competition.competitor;


/**
 * A participant that is going to play in a competition.
 * 
 * @author Nicolas Kerman and Mina Crapez
 * @version 22/09/2021
 */

public class Competitor {

    private int nbPoints; // the number of points of the competitor
    private String name; // the name of the competitor

    /**
     * The constructor of Competitor
     * @param name the name of the competitor 
     */
    public Competitor (String name){
        this.nbPoints= 0;
        this.name = name;
    } 

    /**
     * To get the name of the competitor
     * @return the name of the competitor
     */
	  public String getName(){
	      return this.name;
	  }

    /**
     * To get the number of points of the competitor
     * @return the number of points of the competitor
     */
	  public int getPoints(){
	      return this.nbPoints;
	  }

    /**
     * To set the name of the competitor
     * @param name the name of the competitor
     */
	  public void setName(String name){
	      this.name = name;
	  }

    /**
     * To set the number of points of the competitor
     * @param points the points of the player
     */
	  public void setPoints(int points){
	      this.nbPoints = points;
	  }

    /**
     * To add a number of points to the competitor
     * @param points the number of points that we want to add to the competitor
     */
	  public void addPoints(int points){
	      this.nbPoints += points;
	  }


     /**
     * To check if an object is equals to a competitor
     * @param o an other object that we want to test
     * @return true if the competitor and the object are equals and false otherwise
     */
    public boolean equals(Object o){
        if (o instanceof Competitor){
            Competitor other = (Competitor) o;
            return (this.name.equals(other.name) && this.nbPoints == other.nbPoints);
        }
        else{
            return false;
        }
    }

}