package e1.Piece;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import e1.Pair;

public class PieceTest {

    private Knight knight;
    private Pawn pawn;

    @BeforeEach
    public void beforeEach(){
        this.knight = PieceFactory.createKnight(new Pair<Integer, Integer>(0,0));
        this.pawn = PieceFactory.createPawn(new Pair<Integer, Integer>(1,1));
    }

    @Test
    public void testKnightMove(){
        Pair<Integer, Integer> newPosition = new Pair<Integer, Integer>(1,2);
        this.knight.move(newPosition);
        assertEquals(newPosition, this.knight.getPosition());
    }

    @Test
    public void testIllegalKnightMove(){
        Pair<Integer, Integer> oldPosition = this.knight.getPosition();
        Pair<Integer, Integer> wrongPosition = new Pair<Integer, Integer>(2,2);
        ((Knight) this.knight).move(wrongPosition);
        assertEquals(oldPosition, this.knight.getPosition());
    }


    @Test
    public void testCreateKnight() {
        assertNotNull(this.knight.getPosition());
    }

    @Test
    public void testCreatePawn() {
        assertNotNull(this.pawn.getPosition());
    }

}
