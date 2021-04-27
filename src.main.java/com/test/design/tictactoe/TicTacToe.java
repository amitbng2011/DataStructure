package com.test.design.tictactoe;

/**
 * @Features
 * 
 * 1. Times game?
 * 2. Undo function?
 * 3. Viewer?
 * 4. Statistics?
 *
 *
 */
public class TicTacToe {

	private int[][] board;
	private int n;
	private int[] colSum;
	private int[] rowSum;
	private int diagSum;
	private int reverseDiagSum;
	private int winner;
	private int player;

	public static void main(String[] args) {

		TicTacToe obj = new TicTacToe(3);
		int[][] moves = new int[][] {{0,0},{2,0},{1,1},{2,1},{2,2}};
		int player = 0;
		int count = 0;
		for(int[] move : moves) {
			player = count%2 == 0? 0:1;
			System.out.println(obj.makeMove(move[0], move[1], player));
		}
	}

	public TicTacToe(final int n) {
		this.n = n;
		board = new int[n][n];
		rowSum = new int[n];
		colSum = new int[n];
	}

	/**
	 * Makes move in the board and returns the winner if the move is winning move
	 * 
	 * player: either 0 or 1
	 * rows: is the move's row index
	 * cols: is the move's col index
	 * 
	 * @Note: Instead of passing params, we can utilize Move Object
	 * @param moves
	 * @return
	 */
	public int makeMove(int row, int col, int player) throws IllegalStateException{


		if(row<0 || row>=n ||col<0 || col>=n) {
			throw new IllegalStateException("Move is out of the board boundary");
		}else if(board[row][col] != 0) {
			throw new IllegalStateException("Cell is already occupied");
		}else if(player != 0 && player != 1){
			throw new IllegalStateException("Invalid Player");
		} else {
			player = player == 0? -1 : 1;
			board[row][col] = player;
			rowSum[row] += player; // calculate rowSum
			colSum[col] += player; // calculate colSum

			if(row == col) { // calculate diagsum
				diagSum += player;
			}
			if(row == n-1-col) { // calculate reverse diagsum
				reverseDiagSum += player;
			}

			//			If any sum satisfies winning condition then set winner
			if(Math.abs(rowSum[row])==n || Math.abs(colSum[col])==n || Math.abs(diagSum)==n || Math.abs(reverseDiagSum)==n ) {
				winner = player;
			}
		}
		return getWinner();

	}

	public int currentPlayer() {
		return this.player;
	}

	public int getWinner() {
		return this.winner;
	}

	public int[][] getBoard() {
		return this.board;
	}

}
