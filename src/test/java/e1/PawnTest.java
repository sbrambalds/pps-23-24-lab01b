package e1;

import org.junit.jupiter.api.BeforeEach;

public class PawnTest extends PieceTest{
    
    @BeforeEach
    public void beforeEach(){
        this.piece = new Pawn(new Pair<Integer, Integer>(1,1));
    }
}
