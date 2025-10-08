
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

    public GameBoard(ArrayList<Button> buttons1,  ArrayList<Button> buttons2, ArrayList<Button> buttons3){
        matrix.add(buttons1);
        matrix.add(buttons2);
        matrix.add(buttons3);
    }

    private ArrayList<ArrayList<Button>> matrix = new ArrayList<>();

    private int counter = 0;

    private int player = 0;

    private boolean flag = false;

    private int winner;

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
        if (!flag){
            Button btn = matrix.get(row).get(col);
            if (btn.getText().isEmpty()){
                if(player==0){
                    btn.setText("X");
                    player++;
                }
                else{
                    player = 0;
                    btn.setText("O");
                }
            }
            else{
                return false;
            }
            for (int i = 0; i <= matrix.size() -1; i++) {
                if (matrix.get(i).get(0).getText().equals("X") && matrix.get(i).get(1).getText().equals("X") && matrix.get(i).get(2).getText().equals("X") || matrix.get(i).get(0).getText().equals("O") && matrix.get(i).get(1).getText().equals("O") && matrix.get(i).get(2).getText().equals("O")){
                    System.out.println("Game is Over");
                    flag = true;
                    Button btn1 = matrix.get(i).get(0);
                    Button btn2 = matrix.get(i).get(1);
                    Button btn3 = matrix.get(i).get(2);
                    btn1.setStyle("-fx-background-color: lightgreen");
                    btn2.setStyle("-fx-background-color: lightgreen");
                    btn3.setStyle("-fx-background-color: lightgreen");
                    setWinner(player);
                    return false;
                }
                if (matrix.get(0).get(i).getText().equals("X") && matrix.get(1).get(i).getText().equals("X") && matrix.get(2).get(i).getText().equals("X") || matrix.get(0).get(i).getText().equals("O") && matrix.get(1).get(i).getText().equals("O") && matrix.get(2).get(i).getText().equals("O")){
                    System.out.println("Game is Over");
                    flag = true;
                    Button btn1 = matrix.get(0).get(i);
                    Button btn2 = matrix.get(1).get(i);
                    Button btn3 = matrix.get(2).get(i);
                    btn1.setStyle("-fx-background-color: lightgreen");
                    btn2.setStyle("-fx-background-color: lightgreen");
                    btn3.setStyle("-fx-background-color: lightgreen");
                    setWinner(player);
                    return false;
                }
                if (matrix.get(0).get(0).getText().equals("X") && matrix.get(1).get(1).getText().equals("X") && matrix.get(2).get(2).getText().equals("X") || matrix.get(0).get(0).getText().equals("O") && matrix.get(1).get(1).getText().equals("O") && matrix.get(2).get(2).getText().equals("O")){
                    System.out.println("Game is Over");
                    flag = true;
                    Button btn1 = matrix.get(0).get(0);
                    Button btn2 = matrix.get(1).get(1);
                    Button btn3 = matrix.get(2).get(2);
                    btn1.setStyle("-fx-background-color: lightgreen");
                    btn2.setStyle("-fx-background-color: lightgreen");
                    btn3.setStyle("-fx-background-color: lightgreen");
                    setWinner(player);
                    return false;
                }
                if (matrix.get(2).get(0).getText().equals("X") && matrix.get(1).get(1).getText().equals("X") && matrix.get(0).get(2).getText().equals("X") || matrix.get(2).get(0).getText().equals("O") && matrix.get(1).get(1).getText().equals("O") && matrix.get(0).get(2).getText().equals("O")){
                    System.out.println("Game is Over");
                    flag = true;
                    Button btn1 = matrix.get(2).get(0);
                    Button btn2 = matrix.get(1).get(1);
                    Button btn3 = matrix.get(0).get(2);
                    btn1.setStyle("-fx-background-color: lightgreen");
                    btn2.setStyle("-fx-background-color: lightgreen");
                    btn3.setStyle("-fx-background-color: lightgreen");
                    setWinner(player);
                    return false;
                }

            }
            if (checkDraw()){
                flag = true;
                setWinner(-1);
                return false;
            }



        }
        else{
            return false;
        }
        return true;
    }

    private boolean checkDraw(){
        for (int i = 0; i <= matrix.size() - 1; i++){
            for (Button btn : matrix.get(i)){
                if (btn.getText().isEmpty()){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Tells us if the game has ended either by draw or by meeting the winning
     * condition.
     *
     * @return true if the game is over, else it will retun false.
     */
    public boolean isGameOver() {
        return flag;
    }

    /**
     * Gets the id of the winner, -1 if its a draw.
     *
     * @return int id of winner, or -1 if draw.
     */
    public int getWinner()
    {
        //TODO Implement this method
        return winner;
    }

    private void setWinner(int player){
        if (player == 1){
            winner = 0;
        }
        else if (player == 0){
            winner = 1;
        }
        else{
            winner = player;
        }
    }

    /**
     * Resets the game to a new game state.
     */
    public void newGame()
    {
        for (int i = 0; i <= matrix.size() - 1; i++){
            for(Button btn : matrix.get(i)){
                btn.setStyle("");
            }
        }
        player =  0;
        flag = false;
    }
}
