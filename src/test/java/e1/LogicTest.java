package e1;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

  private static final int WINDOW_SIZE = 5;

  private Pair<Integer, Integer> knightPosition = new Pair<Integer, Integer>(0,0);
  private Pair<Integer, Integer> pawnPosition = new Pair<Integer, Integer>(1,2);
  private Logics logic;

  @BeforeEach
  void beforeEach(){
    logic = new LogicsImpl(WINDOW_SIZE, pawnPosition, knightPosition);
  }

  @Test
  public void testWrongWindowSize(){
    assertAll(
      () -> assertThrows(IllegalArgumentException.class, () -> new LogicsImpl(1)),
      () -> assertThrows(IllegalArgumentException.class, () -> new LogicsImpl(0)) 
    );
  }

  @Test
  public void testKnightPosition(){
    assertTrue(this.logic.hasKnight(knightPosition.getX(), knightPosition.getY()));
  }

  @Test
  public void testPawnPosition(){
    assertTrue(this.logic.hasPawn(pawnPosition.getX(), pawnPosition.getY()));
  }

  @Test
  public void testIfKnightHitPawn() {
    assertTrue(this.logic.hit(1, 2));
  }
  

}
