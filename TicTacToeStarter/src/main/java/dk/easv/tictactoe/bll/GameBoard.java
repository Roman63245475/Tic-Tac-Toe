
package dk.easv.tictactoe.bll;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

/**
 *
 * @author EASV
 */
public class GameBoard implements IGameBoard
{

    public GameBoard(GridPane grid, ArrayList<Button> buttons1,  ArrayList<Button> buttons2, ArrayList<Button> buttons3){
        this.gridpane = grid;
        matrix.add(buttons1);
        matrix.add(buttons2);
        matrix.add(buttons3);
    }

    private ArrayList<ArrayList<Button>> matrix;

    private GridPane gridpane;

    private int counter = 0;

    /**
     * Returns 0 for player 0, 1 for player 1.
     *
     * @return int Id of the next player.
     */
    public int getNextPlayer()
    {
        if (counter ==0){
            counter++;
            return 0;
        }
        counter = 0;
        return 1;
    }

    /**
     * Attempts to let the current player play at the given coordinates. It the
     * attempt is succesfull the current player has ended his turn and it is the
     * next players turn.
     *
     * @param col column to place a marker in.
     * @param row row to place a marker in.
     * @return true if the move is accepted, otherwise false. If gameOver == true
     * this method will always return false.
     */
    public boolean play(int col, int row) {

        for (Node node : gridpane.getChildren()) {
            Button btn = (Button) node;
            if (btn.getText().isEmpty()){
                System.out.println("Game proceeds");
                //amount++;
                return true;
            }
        }
        System.out.println("Game is over");
        return false;
//
    }

    private boolean winningCondition(int col, int row) {

    }
    /**
     * Tells us if the game has ended either by draw or by meeting the winning
     * condition.
     *
     * @return true if the game is over, else it will retun false.
     */
    public boolean isGameOver() {
        //TODO Implement this method
        return false;
    }

    /**
     * Gets the id of the winner, -1 if its a draw.
     *
     * @return int id of winner, or -1 if draw.
     */
    public int getWinner()
    {
        //TODO Implement this method
        return -1;
    }

    /**
     * Resets the game to a new game state.
     */
    public void newGame()
    {
        //TODO Implement this method
    }
}
