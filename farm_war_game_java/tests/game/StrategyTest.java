package game;

import java.io.IOException;

public class StrategyTest {
	
	public static class StrategyForTest extends Strategy {
		
		public StrategyForTest(Game game) {
			super(game);
		}
	
		/**
		 * To choose the action depending on the strategy choosen
		 * @param nbChoices of actions 
		 * @return the number of the action chosen 
		 * @throws IOException if the input isn't correct
		 */
		@Override
		public int choice(int nbChoices) throws IOException {
			return 0;
		}
	
		/**
		 * To get the horizontal coordinate 
		 * @return the horizontal coordinate
		 * @throws IOException if the input isn't correct
		 */
		@Override
		protected int getX() throws IOException {
			return 2;
		}
	
		/**
		 * used to get the vertical coordinate 
		 * @return the vertical coordinate
		 * @throws IOException if the input isn't correct
		 */
		@Override
		protected int getY() throws IOException {
			return 3;
		}
		
		/**
		 * To get the size of a new npc deployed
		 * @return the size of this npc
		 * @throws IOException if the input is not correct 
		 */
		@Override
		public int getSizeOfNpc() throws IOException{
			return 2;
		}
		
	}
}
	