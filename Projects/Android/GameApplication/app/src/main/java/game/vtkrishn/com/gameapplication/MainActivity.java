package game.vtkrishn.com.gameapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import game.vtkrishn.com.gameapplication.model.Board;
import game.vtkrishn.com.gameapplication.model.Controller;

public class MainActivity extends AppCompatActivity {
    Controller controller;
    Board b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize the controller and load the components
        controller = new Controller();
        controller.loadUIComponents(this);
    }

    public void onNewClick(View view){
        //initialize the board
        controller.startTheGame(this);
    }

    public void onCellClick(View view) {
        controller.propogate(this);

//        for (int i = 1; i < 10; i++) {
//            if (!b.getMap().containsKey(i)) {
//                if (view.getId() == getResources().getIdentifier("id/button" + i, "button", getPackageName()) && findViewById(getResources().getIdentifier("id/button" + i, "button", getPackageName())) != null) {
//                    b.placeMarker(i);
//                    break;
//                }
//            } else {
//                continue;
//            }
//        }
//
//        Button bn = ((Button) view);
//        bn.setText("H");
//        bn.setClickable(false);
//
//        //place mark for computer
//        if (b.getMap().size() < 9) {
//            int cValue = b.optimizeMark();
//            if(cValue == -1) {
//                Toast.makeText(getApplicationContext(), "Human Wins", Toast.LENGTH_SHORT).show();
//                onNewClick(null);
//            }
//            Button bn1 = ((Button) findViewById(getResources().getIdentifier("id/button" + cValue, "button", getPackageName())));
//            if(bn1 != null  && (bn1.getText() == null || bn1.getText().equals(""))) {
//                bn1.setText("C");
//                bn1.setClickable(false);
//            }
//        }
    }

}
