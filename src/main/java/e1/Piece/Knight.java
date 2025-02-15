package e1.Piece;

import e1.Pair;

public class Knight implements Piece, Movable {

    private Pair<Integer, Integer> position;

    public Knight(Pair<Integer, Integer> position) {
        this.position = position;
    }

    @Override
    public void move(Pair<Integer, Integer> newPosition){
		int x = newPosition.getX() - this.position.getX();
		int y = newPosition.getY() - this.position.getY();
		if (x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3) {
			this.position = (new Pair<>(newPosition.getX(),newPosition.getY()));
		}
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }

}
