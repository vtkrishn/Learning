package game.vtkrishn.com.gameapplication.model;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import game.vtkrishn.com.gameapplication.R;

/**
 * Created by vtkrishn on 5/5/2017.
 */

public class Controller {
    /*

    restart the game if some one won
    end the game based one the logic

    */
    Button newButton;
    TextView gamePoints;
    GridLayout grid;
    Board board;
    int gamesPlayed;
    int humanPoints;
    int compPoints;

    Activity activity;
    public Controller(Activity activity){
        this.activity = activity;
    }
    public void loadUIComponents(){
        newButton = (Button)activity.findViewById(R.id.button);
        gamePoints = (TextView)activity.findViewById(R.id.textView);
        grid = (GridLayout)activity.findViewById(R.id.gridLayout);

        setVisibility(gamePoints,false);
        setVisibility(grid,false);
    }

    private void setVisibility(View view, boolean value){
        if(value)
            view.setVisibility(View.VISIBLE);
        else
            view.setVisibility(View.INVISIBLE);
    }

    public void startTheGame(){
        //show the grid
        setVisibility(grid,true);
        //start the board
        board = new Board();
        //initialize all the cells to nothing
        for(int i=1;i<10;i++) {
            int id = getResourceIdentifier(i);
            Button b = (Button)activity.findViewById(id);
            if (b != null)
                b.setText("");
            b.setClickable(true);
        }
        //show game points for games played more than once
        if(gamesPlayed >= 1){
            gamePoints.setText(gamesPlayed + ": " + "Human :  "+ humanPoints + ", Computer : "+ compPoints);
            setVisibility(gamePoints,true);
        }
        gamesPlayed++;
    }

    public void propagate(View view){
        //H is clicking
        setHumanCell(view,"X");
        //check where to place for computer
        setComputerCell("O");

        if(board.map.size() == 9) {
            displayMessage("Game Over");
            startTheGame();
        }
    }
    public void setHumanCell(View view, String value){
        //set the button cell to H
        setTheButtonCellToValue((Button) view, value);
        //mark the backup cell to H
        setCellValue(view,value);
    }

    private void setTheButtonCellToValue(Button view, String value) {
        Button cell = view;
        cell.setText(value);
        cell.setClickable(false);
    }

    private void setCellValue(View view,String marker){
        for(int i=0;i<10;i++){
            int id = getResourceIdentifier(i);
            if(view.getId() == id && activity.findViewById(id) != null){
                board.placeMarker(i,marker);
                break;
            }
            else
                continue;
        }
    }

    private int getResourceIdentifier(int i) {
        return activity.getResources().getIdentifier("id/button" + i, "button", activity.getPackageName());
    }

    public void setComputerCell(String marker){
        int cellValue = 0;
        if(board.map.size() == 1) {
             cellValue = placeComputerRandomly(marker);
        }
         else{
            int index = 1;
            int sum = 0;
            int min = 0;
            int minIndex = 0;
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(!board.map.containsKey(index)){
                        if(min > sum) {
                            min = sum;
                            minIndex = index;
                        }
                    }
                    sum = sum + tryMarker(i,j);
                    index++;
                }
                if(min > sum) {
                    min = sum;
                    minIndex = index;
                }
                sum = 0;
            }
            cellValue = minIndex;
            for(int i=0;i<board.cells.length;i++){
                for(int j=0;j<board.cells[0].length;j++) {
                    if(cellValue > 0 && !board.map.containsKey(cellValue)) {
                        board.placeMarker(cellValue,marker);
                    }
                    else
                        continue;
                }
            }
        }

        int id = getResourceIdentifier(cellValue);
        Button cell = (Button) activity.findViewById(id);
        if (cell != null && (cell.getText() == null || cell.getText().equals(""))) {
            setTheButtonCellToValue(cell, marker);
        }
    }

    private int placeComputerRandomly(String marker){
        int random;
        for(int i=0;i<board.cells.length;i++){
            for(int j=0;j<board.cells[0].length;j++) {
                random = (int) (Math.random() * 9);
                if(random > 0 && !board.map.containsKey(random)) {
                    board.placeMarker(random,marker);
                    return random;
                }
                else
                    continue;
            }
        }
        return -1;
    }
    private int tryMarker(int i, int j){
        if(board.cells[i][j] == null)
            return 0;
        else if(board.cells[i][j].value.equals("H"))
            return -1;
        else if(board.cells[i][j].value.equals("C"))
            return 1;
        return -1;
    }

    public boolean isWinning(){
        //check if any 1 is winning then
        displayMessage("Human Wins. Game Over!, starting new game");
        return true;
    }

    public void displayMessage(String message){
        Toast.makeText(activity.getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}

