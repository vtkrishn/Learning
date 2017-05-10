package game.vtkrishn.com.gameapplication.model;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

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

    public void loadUIComponents(Activity activity){
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

    public void startTheGame(Activity activity){
        //show the grid
        setVisibility(grid,true);
        //start the board
        board = new Board();
        //initialize all the cells to nothing
        for(int i=1;i<10;i++) {
            int id = activity.getResources().getIdentifier("id/button" + i, "button", activity.getPackageName());
            Button b = (Button)activity.findViewById(id);
            if (b != null)
                b.setText("");
            b.setClickable(true);
        }
        //show game points for games played more than once
        if(gamesPlayed > 1){
            gamePoints.setText("Human :  "+ humanPoints + ", Computer : "+ compPoints);
            setVisibility(gamePoints,true);
        }
        gamesPlayed++;
    }

    public void propogate(Activity activity){

    }

    public boolean isWin(){
        if(board.cells[0][0] && board.cells[0][1] && board.cells[0][1])
    }

}
