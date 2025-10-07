
package dk.easv.tictactoe.gui.controller;

// Java imports
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

// Project imports
import dk.easv.tictactoe.bll.GameBoard;
import dk.easv.tictactoe.bll.IGameBoard;

/**
 *
 * @author EASV
 */
public class TicTacViewController implements Initializable
{
    @FXML
    private Label lblPlayer;

    private ArrayList<Button> buttons1Row = new ArrayList<>();
    private ArrayList<Button> buttons2Row = new ArrayList<>();
    private ArrayList<Button> buttons3Row = new ArrayList<>();

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button btn7;
    @FXML
    private Button btn8;
    @FXML
    private Button btn9;

    @FXML
    private Button currentButton;

    @FXML
    private GridPane gridPane;

    @FXML
    private Button btnNewGame;

    
    private static final String TXT_PLAYER = "Player: ";
    private IGameBoard game;

    private int player;

    /**
     * Event handler for the grid buttons
     *
     * @param event
     */
    @FXML
    private void handleButtonAction(ActionEvent event)
    {
        try
        {
            Integer row = GridPane.getRowIndex((Node) event.getSource());
            Integer col = GridPane.getColumnIndex((Node) event.getSource());
            int r = (row == null) ? 0 : row;
            int c = (col == null) ? 0 : col;
//            System.out.println(r);
//            System.out.println(c);
            //int player = game.getNextPlayer();
            if (game.play(c, r)) {
                    //Button btn = (Button) event.getSource();
//                  String xOrO = (player == 0) ? "X" : "O";
//                  btn.setText(xOrO);
                setPlayer();
                System.out.println("This one is called");
            }
            else {
                if (game.isGameOver())
                {
                    int winner = game.getWinner();
                    displayWinner(winner);
                }
            }
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Event handler for starting a new game
     *
     * @param event
     */
    @FXML
    private void handleNewGame(ActionEvent event)
    {
        game.newGame();
        setPlayer(0);
        clearBoard();
    }

    /**
     * Initializes a new controller
     *
     * @param url
     * The location used to resolve relative paths for the root object, or
     * {@code null} if the location is not known.
     *
     * @param rb
     * The resources used to localize the root object, or {@code null} if
     * the root object was not localized.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        buttons1Row.add(btn1);
        buttons1Row.add(btn2);
        buttons1Row.add(btn3);
        buttons2Row.add(btn4);
        buttons2Row.add(btn5);
        buttons2Row.add(btn6);
        buttons3Row.add(btn7);
        buttons3Row.add(btn8);
        buttons3Row.add(btn9);
        game = new GameBoard(gridPane, buttons1Row, buttons2Row, buttons3Row);
        setPlayer();
    }

//    private boolean checkSelected(int row, int cloumn){
//        for (Node node : gridPane.getChildren()) {
//            Integer r = GridPane.getRowIndex(node);
//            Integer c = GridPane.getColumnIndex(node);
//            int rr = (r == null) ? 0 : r;
//            int cc = (c == null) ? 0 : c;
//            if (rr == row && cc == cloumn) {
//                currentButton = (Button) node;
//                break;
//            }
//        }
//        return currentButton.getText().isEmpty();
//    }

    /**
     * Set the next player
     */
    private void setPlayer()
    {
        player = game.getNextPlayer();
        lblPlayer.setText(TXT_PLAYER + player);
    }

    private void setPlayer(int player){
        this.player = player;
        lblPlayer.setText(TXT_PLAYER + player);
    }


    /**
     * Finds a winner or a draw and displays a message based
     * @param winner
     */
    private void displayWinner(int winner)
    {
        String message = "";
        switch (winner)
        {
            case -1:
                message = "It's a draw :-(";
                break;
            default:
                message = "Player " + winner + " wins!!!";
                break;
        }
        lblPlayer.setText(message);
    }

    /**
     * Clears the game board in the GUI
     */
    private void clearBoard()
    {
        for(Node n : gridPane.getChildren())
        {
            Button btn = (Button) n;
            btn.setText("");
        }
    }
}
