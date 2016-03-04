package Ejercicios;

public class TicTacToe {
	public static void main(String[] args) {

		int N = 3;
		int M = 3;
		int[][] board = new int[N][M];

		// First row
		board[0][0] = 1;
		board[0][1] = 1;
		board[0][2] = 0;
		// Second row
		board[1][0] = 1;
		board[1][1] = 0;
		board[1][2] = 0;
		// Third row
		board[2][0] = 1;
		board[2][1] = 0;
		board[2][2] = 1;

		Board.printBoard(board);
		Board.printWinner(Board.winner(board));

	}

}
