package e1.Piece;

import org.junit.jupiter.api.BeforeEach;

import e1.Pair;

public class PawnTest extends PieceTest{
    
    @BeforeEach
    public void beforeEach(){
        this.piece = PieceFactory.createPawn(new Pair<Integer, Integer>(1,1));
    }
}
