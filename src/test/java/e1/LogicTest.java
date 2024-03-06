package e1;
import org.junit.jupiter.api.*;
import org.w3c.dom.css.Counter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

public class LogicTest {

  private static final int WINDOW_SIZE = 5;
  private static final List<Pair<Integer, Integer>> movementsList = Arrays.asList(new Pair<>(2,1), new Pair<>(1,2),
                                                                                  new Pair<>(-2,1), new Pair<>(1,-2),
                                                                                  new Pair<>(-1,2), new Pair<>(2,-1),
                                                                                  new Pair<>(-2,-1), new Pair<>(-1,-2));
  private Logics logic;
  private List<Pair<Integer, Integer>> legalMoves = new ArrayList<Pair<Integer, Integer>>();
  private List<Pair<Integer, Integer>> illegalMoves = new ArrayList<Pair<Integer, Integer>>();
  private Pair<Integer, Integer> knightPosition;
  private Pair<Integer, Integer> pawnPosition;

  @BeforeEach
  void beforeEach(){
    logic = new LogicsImpl(WINDOW_SIZE);
    this.setKnightAndPawnPosition();
    this.setLegalMoves();
  }

  @Test
  public void testOutOfBoundMove() {
    assertAll(
      () -> assertThrows(IndexOutOfBoundsException.class, () -> logic.hit(6, 6)),
      () -> assertThrows(IndexOutOfBoundsException.class, () -> logic.hit(-1, -1))
    );
  }

  @Test
  public void testWrongWindowSize(){
    assertAll(
      () -> assertThrows(StackOverflowError.class, () -> new LogicsImpl(1)),
      () -> assertThrows(IllegalArgumentException.class, () -> new LogicsImpl(0)) 
    );
  }

  @Test
  public void testKnightIsPresent() {
    assertNotNull(this.knightPosition);
  }

  @Test
  public void testPawnIsPresent() {
    assertNotNull(this.pawnPosition);
  }

  @Test
  public void testKnightIsExacltyOne(){
    assertTrue(this.pieceIsOne((i, j) -> logic.hasKnight(i, j)));
  }

  @Test
  public void testPawnIsExacltyOne(){
    assertTrue(this.pieceIsOne((i, j) -> logic.hasPawn(i, j)));
  }

  @Test 
  public void testAllLegalKnightMoves() {
    Pair<Integer, Integer> oldKnightPosition = this.knightPosition;
    for(Pair<Integer, Integer> legalMove : this.legalMoves){
      logic.hit(legalMove.getX(), legalMove.getY());
      assertAll(
        () -> assertTrue(logic.hasKnight(legalMove.getX(), legalMove.getY())),
        () -> assertFalse(logic.hasKnight(oldKnightPosition.getX(), oldKnightPosition.getY()))
      );
      logic.hit(oldKnightPosition.getX(), oldKnightPosition.getY()); //reset position to try all legal moves
    }
  }

  @Test
  public void testIllegalKnightMove() {
    Logics newLogic = new LogicsImpl(new Pair<Integer, Integer>(0,0), new Pair<Integer, Integer>(5,5), WINDOW_SIZE);
    assertFalse(newLogic.hit(1, 1)); 
  }

  @Test
  public void testIfKnightHitPawn() {
    Logics newLogic = new LogicsImpl(new Pair<Integer, Integer>(0,0), new Pair<Integer, Integer>(1,2), 5);
    assertTrue(newLogic.hit(1, 2));
  }

  private void setKnightAndPawnPosition() {
    for(int posX = 0; posX < WINDOW_SIZE; posX++){
      for(int posY = 0; posY < WINDOW_SIZE; posY++){
        if(logic.hasKnight(posX, posY)){
          this.knightPosition = new Pair<>(posX, posY);
        } else if(logic.hasPawn(posX, posY)){
          this.pawnPosition =  new Pair<>(posX, posY);
        }
      }
    }
  }

  private boolean pieceIsOne(BiPredicate<Integer, Integer> predicate){
    int pieceCount = 0;
    for(int posX = 0; posX < WINDOW_SIZE; posX++){
      for(int posY = 0; posY < WINDOW_SIZE; posY++){
        if(predicate.test(posX, posY)){
          pieceCount = pieceCount + 1;
        } 
      }
    }
    return pieceCount == 1;
  }
  
  private void setLegalMoves() {
    for(Pair<Integer, Integer> move : movementsList) {
      int newMoveX = this.knightPosition.getX() + move.getX();
      int newMoveY = this.knightPosition.getY() + move.getY();
      if((newMoveX >= 0 && newMoveX < WINDOW_SIZE) && (newMoveY >= 0 && newMoveY < WINDOW_SIZE)){
        this.legalMoves.add(new Pair<Integer, Integer>(newMoveX, newMoveY));
      } else {
        this.illegalMoves.add(new Pair<Integer, Integer>(newMoveX, newMoveY));
      }
    }
  } 

}
