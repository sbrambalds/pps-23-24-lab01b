package e1.Piece;

import e1.Pair;

public class Pawn implements Piece {

    private Pair<Integer, Integer> position;

    public Pawn(Pair<Integer, Integer> position) {
        this.position = position;
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }

}
