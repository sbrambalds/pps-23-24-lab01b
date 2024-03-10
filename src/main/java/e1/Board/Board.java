package e1.Board;
import e1.Pair;
import e1.Piece.Knight;
import e1.Piece.Pawn;

public interface Board {

    public int getSize();

    public Knight getKnight();

    public Pawn getPawn();

    public void moveKnight(Pair<Integer, Integer> pair);

    public boolean hasKnight(Pair<Integer,Integer> position);

    public boolean hasPawn(Pair<Integer, Integer> position);
    
}
