package com.example.vtkrishn.simpletodo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> items;
    ArrayAdapter<String> itemAdapter;
    ListView lvItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvItems = (ListView)findViewById(R.id.lvItems);
        items = new ArrayList<>();
        itemAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,items);
        lvItems.setAdapter(itemAdapter);
        items.add("First Item");
        items.add("Second Item");
        setupListViewlistener();
    }

    private void setupListViewlistener(){
        lvItems.setOnLongClickListener(
                new AdapterView.OnItemLongClickListener(){
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapter,View item, int pos, long id){
                        items.remove(pos);
                        itemAdapter.notifyDataSetChanged();
                        return true;
                    }
                }
        );
    }

    public void onAddItem(View v){
        EditText edNewItem = (EditText) findViewById(R.id.etNewItem);
        String itemText = edNewItem.getText().toString();
        itemAdapter.add(itemText);
        edNewItem.setText("");
    }
}
