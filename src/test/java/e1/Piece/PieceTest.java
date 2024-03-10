package e1.Piece;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public abstract class PieceTest {

    protected Piece piece;

    @Test
    public void testCreatePiece() {
        assertNotNull(this.piece.getPosition());
    }

}
