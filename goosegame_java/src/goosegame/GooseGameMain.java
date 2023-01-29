package goosegame;
import goosegame.cells.*;

public class GooseGameMain {
    
    public static void main(String[] args){

        BasicBoard board = new BasicBoard();
        String prenom1 = "Nico";
        String prenom2 = "Mina";
        String prenom3 = "routrout";
        
        if (args.length >= 1){
            prenom1 = (args[0]);
          }
        if (args.length >= 2){
            prenom2 = args[1];
         }

        Player player1 = new Player(prenom1,board.getCell(0));
        Player player2 = new Player(prenom2,board.getCell(0));
        Player player3 = new Player(prenom3,board.getCell(0));
        
        Game game = new Game(board);
        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        game.play();
        
    }
}
