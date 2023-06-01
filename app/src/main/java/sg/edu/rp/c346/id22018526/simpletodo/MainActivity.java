package sg.edu.rp.c346.id22018526.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
    EditText input;
    TextView adding;
    TextView deleting;
    TextView clearing;
    Spinner picking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.taskList);
        input = findViewById(R.id.inputtext);
        adding = findViewById(R.id.addview);
        deleting = findViewById(R.id.deleteview);
        clearing = findViewById(R.id.clearview);
        picking = findViewById(R.id.spinner);



        ArrayList taskList = new ArrayList<String>();
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,taskList);
        list.setAdapter(adapter);

        adding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newcolour = input.getText().toString();
                taskList.add(newcolour);
                adapter.notifyDataSetChanged();

            }
        });
        deleting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newcolour = input.getText().toString();
                taskList.remove(newcolour);
                adapter.notifyDataSetChanged();

            }
        });
        clearing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskList.clear();
                adapter.notifyDataSetChanged();

            }
        });

        picking.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        picking.setBackgroundColor((Color.parseColor("#7983BD")));
                        adding.setTextColor((Color.parseColor("#FFFFFF")));
                        deleting.setTextColor((Color.parseColor("#36454F")));
                        adding.setClickable(true);
                        deleting.setClickable(false);
                        break;
                    case 1:
                        picking.setBackgroundColor((Color.parseColor("#6871AC")));
                        deleting.setTextColor((Color.parseColor("#FFFFFF")));
                        adding.setTextColor((Color.parseColor("#36454F")));
                        adding.setClickable(false);
                        deleting.setClickable(true);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }
}