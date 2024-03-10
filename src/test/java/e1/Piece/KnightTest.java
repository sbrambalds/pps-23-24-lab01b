package e1.Piece;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import e1.Pair;

public class KnightTest extends PieceTest{

    @BeforeEach
    public void beforeEach(){
        this.piece = PieceFactory.createKnight(new Pair<Integer, Integer>(0,0));
    }

    @Test
    public void testMove(){
        Pair<Integer, Integer> newPosition = new Pair<Integer, Integer>(1,2);
        ((Knight) this.piece).move(newPosition);
        assertEquals(newPosition, this.piece.getPosition());
    }

    @Test
    public void testIllegalMove(){
        Pair<Integer, Integer> oldPosition = this.piece.getPosition();
        Pair<Integer, Integer> wrongPosition = new Pair<Integer, Integer>(2,2);
        ((Knight) this.piece).move(wrongPosition);
        assertEquals(oldPosition, this.piece.getPosition());
    }

}
