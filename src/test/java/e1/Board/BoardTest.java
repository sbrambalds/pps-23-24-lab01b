package e1.Board;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import e1.Pair;

public class BoardTest {
    
    private static final int BOARD_SIZE = 5;
    private List<Pair<Integer, Integer>> legalMoves = new ArrayList<>();
    private Board board;

    @BeforeEach
    public void beforeEach(){
        board = new BoardImpl(BOARD_SIZE);
        this.setLegalMoves();
    }

    @Test 
    public void testCreateBoard(){
        assertAll(
            () -> assertEquals(BOARD_SIZE, board.getSize()),
            () -> assertNotNull(board.getKnight()),
            () -> assertNotNull(board.getPawn())
        );
    }

    @Test
    public void testHasKnight(){
        Pair<Integer,Integer> position = board.getKnight().getPosition();
        assertTrue(board.hasKnight(position));
    }

    @Test
    public void testHasPawn(){
        Pair<Integer,Integer> position = board.getPawn().getPosition();
        assertTrue(board.hasPawn(position));
    }

    @Test 
    public void testLegalKnightMove() {
        Pair<Integer, Integer> oldKnightPosition = board.getKnight().getPosition();
        for(Pair<Integer, Integer> legalMove : this.legalMoves){
        board.moveKnight(new Pair<Integer, Integer>(legalMove.getX(), legalMove.getY()));
        assertAll(
            () -> assertTrue(board.hasKnight(new Pair<>(legalMove.getX(), legalMove.getY()))),
            () -> assertFalse(board.hasKnight(new Pair<>(oldKnightPosition.getX(), oldKnightPosition.getY())))
        );
        board.moveKnight(new Pair<>(oldKnightPosition.getX(), oldKnightPosition.getY())); //reset position to try all legal moves
        }
    }

    private void setLegalMoves() {
        for(Pair<Integer, Integer> move : getMovementList()) {
        int newMoveX = board.getKnight().getPosition().getX() + move.getX();
        int newMoveY = board.getKnight().getPosition().getY() + move.getY();
        if((newMoveX >= 0 && newMoveX < BOARD_SIZE) && (newMoveY >= 0 && newMoveY < BOARD_SIZE)){
            this.legalMoves.add(new Pair<Integer, Integer>(newMoveX, newMoveY));
        }
        }
    } 

    private List<Pair<Integer, Integer>> getMovementList() {
        int[] moveX = {2,1,-2,1,-1,2,-2,-1};
        int[] moveY = {1,2,1,-2,2,-1,-1,-2};
        List<Pair<Integer, Integer>> movementList = new ArrayList<>();
        for(int i = 0; i < board.getSize(); i++){
            movementList.add(new Pair<>(moveX[i], moveY[i]));
        }
        return movementList;
    }


}
