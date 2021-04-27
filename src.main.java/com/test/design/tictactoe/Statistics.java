package com.test.design.tictactoe;

/**
 * This  will store user statistics
 *
 */
public class Statistics {

	private int lossCount;
	private int winCount;
	public int getLossCount() {
		return lossCount;
	}
	public void setLossCount(int lossCount) {
		this.lossCount = lossCount;
	}
	public int getWinCount() {
		return winCount;
	}
	public void setWinCount(int winCount) {
		this.winCount = winCount;
	}
	
}
