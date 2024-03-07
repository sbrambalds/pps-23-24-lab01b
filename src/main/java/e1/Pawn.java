package e1;

public class Pawn implements Piece {

    private Pair<Integer, Integer> position;

    public Pawn(Pair<Integer, Integer> pair) {
        this.position = pair;
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }

}
