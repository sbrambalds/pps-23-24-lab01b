package e1.Piece;

import e1.Pair;

public class PieceFactory {

        public static Knight createKnight(Pair<Integer, Integer> position) {
                return new Knight(position);
        }

        public static Pawn createPawn(Pair<Integer, Integer> position) {
                return new Pawn(position);
        }

}
