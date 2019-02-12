package game;
import java.io.*;



public class TTT {
	public static void main(String[] args) {
		playGame();
		
	}
	
	public static void playGame() {

		int[] grid = new int[9];
		while(true) {
			printSquare(grid);
			userChoice(grid);
			if(checkForWin(1, grid)) {
				printSquare(grid);
				endGame(true);
			}
			printSquare(grid);
			computerChoice(grid);
			if(checkForWin(2, grid)) {
				printSquare(grid);
				endGame(false);
			}
		}
	}
	
	/**
	 * prints out the game square
	 * @param grid
	 */
	private static void printSquare(int[] grid) {
		
		int counter = 0;
		for(int i : grid) {
			counter ++;
			System.out.print("|");
			if(i == 0)
				System.out.print(" ");
			else if(i == 1)
				System.out.print("X");
			else if(i == 2)
				System.out.print("0");
			System.out.print("|");
			if(counter%3 == 0) {
				System.out.println("");
				System.out.println("---------");
			}
		}
	}
	/**
	 * Gets the user choice
	 * @param grid
	 */
	private static void userChoice(int[] grid) {

		//get user input from the terminal
		while (true) {
		int choice = 0;
		try {
			System.out.print("your choice[1-9]: ");
			InputStreamReader in =  new InputStreamReader(System.in);
			BufferedReader inbuff = new BufferedReader(in);
			choice = Integer.parseInt(inbuff.readLine());
			
		}catch(Exception e) {
			choice = 0;
		}
		
		if(checkValid(choice, grid)) {
			grid[choice-1] = 1;
			break;
		}
		}
		
		
		
		
		//check if it is a valid choice or not
		//if it is valid, edit the grid
	}
	/**
	 * checks if a square can be filled in
	 * @param x
	 * @param grid
	 * @return
	 */
	private static boolean checkValid(int x, int[] grid) {
		boolean valid = false;
		
		if(x == 0)
			valid = false;
		else if(grid[x-1] == 0)
			valid = true;
		
		
		return valid;
	}
	/**
	 * cpu chooses a grid at random
	 * @param grid
	 */
	private static void computerChoice(int[] grid) {
		int choice;
		while(true) {
			choice = (int)(Math.random() * 9);
			choice += 1;
			if(checkValid(choice, grid)) {
				grid[choice-1] = 2;
				break;
			}
			
			
		}
		
	}

	private static boolean checkForWin(int x, int[] grid) {
		boolean win = false;
		//convert the list to booleans
		boolean[] b = new boolean[9];
		for(int i = 0; i < 9; i++) {
			if(grid[i] == x)
				b[i] = true;
		}
		
		int[][] winningCombinations = {
				{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
				{0, 3, 6}, {1, 4, 7}, {2, 5, 6},
				{0, 4, 8}, {2, 4, 6} };
		
		for(int[] a : winningCombinations) {
			if(b[a[0]] && b[a[1]] && b[a[2]])
				win = true;
		}
		
		return win;
		
		
		
	}

	private static void endGame(boolean winner) {
		if(winner)
			System.out.println("You Won!!!!");
		else
			System.out.println("You lost :(");
		playGame();
	}
}