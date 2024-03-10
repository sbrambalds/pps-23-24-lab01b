package e1;

import e1.Board.Board;
import e1.Board.BoardImpl;

public class LogicsImpl implements Logics {
	
	private Board board;
	 
    public LogicsImpl(int size){
		this.checkBoardSize(size);
		board = new BoardImpl(size);
    }

	public LogicsImpl(int size, Pair<Integer, Integer> pawnPosition, Pair<Integer, Integer> knightPosition) {
		this.checkBoardSize(size);
		board = new BoardImpl(size, knightPosition, pawnPosition);	
	}

	@Override
	public boolean hit(int row, int col) { 
		board.moveKnight(new Pair<>(row, col));
		return this.board.getPawn().getPosition().equals(this.board.getKnight().getPosition());
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.board.hasKnight(new Pair<>(row, col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.board.getPawn().getPosition().equals(new Pair<>(row,col));
	}

	private void checkBoardSize(int size) {
		if (size <= 1) throw new IllegalArgumentException("Given game board size is too small");
	}
}
