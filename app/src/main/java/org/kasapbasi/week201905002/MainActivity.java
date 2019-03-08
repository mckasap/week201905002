package org.kasapbasi.week201905002;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private SeekBar sb;
    private ListView lv;

    private void update(){


        ArrayList<String> liste= new ArrayList<>();

        for(int i=0;i<20;i++){
            liste.add(String.valueOf(i*sb.getProgress()));
        }
        ArrayAdapter<String> adap= new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                liste);

        lv.setAdapter(adap);



    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sb= (SeekBar) findViewById(R.id.seekBar);
        lv= (ListView) findViewById(R.id.ListView);

        sb.setMax(20);
        sb.setProgress(10);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int pos, boolean b) {


                if(sb.getProgress()==0)
                    sb.setProgress(1);
                update();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
update();
    }
}
