package e1.Board;

import java.util.Random;

import e1.Pair;
import e1.Piece.Knight;
import e1.Piece.Pawn;
import e1.Piece.PieceFactory;

public class BoardImpl implements Board{

    private int boardSize;
    private Knight knight;
    private Pawn pawn;
    private final Random random = new Random();

    public BoardImpl(int boardSize) {
        this.boardSize = boardSize;
        this.knight = PieceFactory.createKnight(randomEmptyPosition());
        this.pawn = PieceFactory.createPawn(randomEmptyPosition());
    }

    public BoardImpl(int boardSize, Pair<Integer, Integer> knightPosition,  Pair<Integer, Integer> pawnPosition) {
        this.boardSize = boardSize;
        this.knight = PieceFactory.createKnight(knightPosition);
        this.pawn = PieceFactory.createPawn(pawnPosition);
    }

    private final Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(boardSize),this.random.nextInt(boardSize));
    	return this.pawn!=null && this.pawn.getPosition().equals(pos) ? randomEmptyPosition() : pos;
    }

    @Override
    public int getSize() {
        return this.boardSize;
    }

    @Override
    public Knight getKnight() {
        return this.knight;
    }

    @Override
    public Pawn getPawn() {
        return this.pawn;
    }

    @Override
    public void moveKnight(Pair<Integer, Integer> newPosition) {
        int row = newPosition.getX();
        int col = newPosition.getY();
        if (row<0 || col<0 || row >= this.boardSize || col >= this.boardSize) {
			throw new IndexOutOfBoundsException("Given position is out of board");
		}
        this.knight.move(newPosition);
    }

    @Override
    public boolean hasKnight(Pair<Integer,Integer> position) {
        return this.knight.getPosition().equals(position);
    }

    @Override
    public boolean hasPawn(Pair<Integer, Integer> position) {
        return this.pawn.getPosition().equals(position);
    }
}
