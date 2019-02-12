package game;
import java.io.*;

public class TicTacToeGame {
	//each game is represented by a grid made of 0s 1s and 2s
	//0 = blank, 1 = user, 2 = computer
	//the grids can be converted to booleans and checked to see if it contains a winning combination
	
	
	
	public static void main(String[] args) {
	}
	
	
	private static void userChoice(int[] game) {
		while(true) {
			System.out.println("Your Choice[1-9]: ");
			int u = readInt();
			if(game[u-1] == 0) {
				game[u-1] = 1;
				break;
			}
		}
		
	}
	private static void computerChoice(int[] game) {
		while(true) {
			int choice = (int) Math.random() * 8;
			if(game[choice] == 0)
				game[choice] = 2;
				
		}
	}

	
	/**
	 * Prints out the tic tac toe grid
	 * @param gameGrid
	 */
	private static void printSquare(int[] gameGrid) {
		for(int i = 0; i < 9; i++) {
			switch(gameGrid[i]) {
			case 0:
				System.out.print(" ");
			case 1:
				System.out.print("X");
			case 2:
				System.out.print("0");
			}
			System.out.print("|");
			
			if(i%3 == 0)
				System.out.println("");
		}
	}
	
			
	
	/**
	 * returns true if the gameGrid contains a winning combination
	 * @param gameGrid
	 * @return
	 */
	private static boolean checkWin(int[] game) {
		boolean[] gameGrid = convertToBooleans(game);
		boolean result = false;
		int[][] winningCombinations = {
				{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
				{0, 3, 6}, {1, 4, 7}, {2, 5, 6},
				{0, 4, 8}, {2, 4, 6} };
				
		
		
		for(int[] x : winningCombinations) {
			if(gameGrid[x[0]] && gameGrid[x[1]] && gameGrid[x[2]])
				result = true;
		}
		
		
		
		return result;
	}

	/**
	 * Gets an integer from the command line input
	 * @return
	 */
	private static int readInt() {
		try {
			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader bufferedIn = new BufferedReader(in);
			int x = Integer.parseInt(bufferedIn.readLine());
			return x;
		}catch (Error | NumberFormatException | IOException e) {
			System.out.println("Error reading input");
			return 0;
		}
	}

	/**
	 * Takes a integer game grid and converts it to a boolean list, allowing it to be checked
	 * @param listToConvert
	 * @return
	 */
	private static boolean[] convertToBooleans(int[] listToConvert) {
		boolean[] x = new boolean[listToConvert.length];
		
		for(int i = 0; i < listToConvert.length; i++) {
			if(listToConvert[i] == 0 || listToConvert[i] == 2)
				x[i] = true;
		}
		
		return x;
	}
	


}
