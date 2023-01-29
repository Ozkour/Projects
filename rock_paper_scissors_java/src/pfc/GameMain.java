package pfc;

import pfc.strategy.*;

/**
* @author Crapez Mina, Kerman Nicolas
*/


public class GameMain {

  private static final  String STRATEGY_PACKAGE = "pfc.strategy." ;
    
    public static void main(String[] args){
       int tour = 10;
       String prenom1 = "Pierre";
       String prenom2 = "Pepper";
       Strategy myStrategy1 = new RandomStrategy();
       Strategy myStrategy2 = new HumanStrategy();

    
       if (args.length >= 1){
           tour = Integer.parseInt(args[0]);
       }
       if (args.length >= 2){
           prenom1 = args[1];
       }
       if (args.length >= 3){
         prenom2 = args[2];
       }

       
       

      try {
        String strategyName1 = args[3];
        Class<?> strategyClass1 = Class.forName(STRATEGY_PACKAGE+ strategyName1);
          myStrategy1 = (Strategy) strategyClass1.getDeclaredConstructor().newInstance();
      } catch(Exception e) { 
       myStrategy1 = new HumanStrategy();  
      }

      try {
        String strategyName2 = args[4];
        Class<?> strategyClass2 = Class.forName(STRATEGY_PACKAGE+ strategyName2);
          myStrategy2 = (Strategy) strategyClass2.getDeclaredConstructor().newInstance();
      } catch(Exception e) { 
       myStrategy2 = new RandomStrategy();  
      }


      System.out.println("Beginning of the game: our players are "+prenom1+" with a "+myStrategy1.getClass().getSimpleName()+"\nand "+prenom2+" with a "+myStrategy2.getClass().getSimpleName()+"\n our game will have "+tour+" turns.");

      Player player1= new Player(prenom1,myStrategy1);
      Player player2= new Player(prenom2,myStrategy2);



      Game game= new Game(player1,player2);
      System.out.println("Le Winner is "+game.play(tour).getName());
    }
}