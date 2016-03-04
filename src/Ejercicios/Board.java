package Ejercicios;

public class Board {

	// Implement this method returning the winner's coordinates
	// {(x,y),(x,y),(x,y)} from left to right and top to bottom
	
	public static int[] winner(int[][] board) {

		int[] coordinates = new int[6];
//        cordinates{0,1 2,3 4,5}
		int count=0;
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				
			do{
				System.out.print(board[i][j]);
				count++;
			}while(board[i][0]!=0 );
								
				
			}
		}
		
		return coordinates;
	}

	public static void printBoard(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void printWinner(int[] coordinates) {
		for (int i = 0; i < coordinates.length; i++) {
			System.out.print(coordinates[i]);
			if (i % 2 == 0)
				System.out.print(",");
			else
				System.out.print(" ");
		}
	}
}
