package e1;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class LogicTest {

  private static final int WINDOW_SIZE = 5;
  private static final Pair<Integer, Integer> PAWN_POSITION = new Pair<>(WINDOW_SIZE-1, WINDOW_SIZE-1);
  private static final Pair<Integer, Integer> KNIGHT_POSITION = new Pair<>(0,0);
  private Logics logic;
  private List<Pair<Integer, Integer>> movementList;

  @BeforeEach
  void beforeEach(){
    logic = new LogicsImpl(WINDOW_SIZE);
    movementList = Arrays.asList(new Pair<>(1,2), new Pair<>(2,4), new Pair<>(3,2));
  }

  @Test
  public void testOutOfBoundMove() {
    assertAll(
      () -> assertThrows(IndexOutOfBoundsException.class, () -> logic.hit(6, 6)),
      () -> assertThrows(IndexOutOfBoundsException.class, () -> logic.hit(-1, -1))
    );
  }

  @Test
  public void testIfKnightIsPresent() {
    assertEquals(KNIGHT_POSITION, this.getKnightPosition());
  }

  @Test
  public void testIfPawnIsPresent() {
    assertEquals(PAWN_POSITION, this.getPawnPosition());
  }

  @Test 
  public void testKnightMovement() {
    logic.hit(movementList.get(0).getX(), movementList.get(0).getY());
    assertAll(
      () -> assertTrue(logic.hasKnight(movementList.get(0).getX(), movementList.get(0).getY())),
      () -> assertFalse(logic.hasKnight(KNIGHT_POSITION.getX(), KNIGHT_POSITION.getY()))
    );
  }

  @Test
  public void testKnightHitPawn() {
    for(Pair<Integer, Integer> move: movementList) {
      assertFalse(logic.hit(move.getX(), move.getY()));
    }
    assertTrue(logic.hit(WINDOW_SIZE - 1, WINDOW_SIZE - 1));
  }

  private Pair<Integer, Integer> getKnightPosition() {
    for(int i = 0; i < WINDOW_SIZE; i++){
      for(int j = 0; j < WINDOW_SIZE; j++){
        if(logic.hasKnight(i, j)){
          return new Pair<>(i, j);
        }
      }
    }
    return null;
  }


  private Pair<Integer, Integer> getPawnPosition() {
    for(int i = 0; i < WINDOW_SIZE; i++){
      for(int j = 0; j < WINDOW_SIZE; j++){
        if(logic.hasPawn(i, j)){
          return new Pair<>(i, j);
        }
      }
    }
    return null;
  }

}
