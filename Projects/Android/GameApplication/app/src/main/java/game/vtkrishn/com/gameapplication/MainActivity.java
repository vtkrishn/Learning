package game.vtkrishn.com.gameapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button newButton = (Button)findViewById(R.id.button);
        TextView points = (TextView)findViewById(R.id.textView);

        GridLayout grid = (GridLayout)findViewById(R.id.gridLayout);
        points.setVisibility(View.INVISIBLE);
        grid.setVisibility(View.INVISIBLE);
    }

    public void onNewClick(View view){
        GridLayout grid = (GridLayout)findViewById(R.id.gridLayout);
        grid.setVisibility(View.INVISIBLE);
    }
}
