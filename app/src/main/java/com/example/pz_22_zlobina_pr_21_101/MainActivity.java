package com.example.pz_22_zlobina_pr_21_101;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
/*
    String[] data = {"a","b","c","e","f","g","h","i","j","k"};

    GridView gvMain;
    ArrayAdapter<String> adapter;
 */

    ImageView curView = null;
    private int countPair = 0;
    final int[] drawable = new int[] {R.drawable.animal0,R.drawable.animal1,
            R.drawable.animal2,R.drawable.animal3,R.drawable.animal4,
            R.drawable.animal5,R.drawable.animal6,R.drawable.animal7,};
    int[] pos = {0,1,2,3,4,5,6,7,0,1,2,3,4,5,6,7};
    int currentPos = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      /*  adapter = new ArrayAdapter<String>(this, R.layout.grid_view_item, R.id.tvText, data);
        gvMain = (GridView) findViewById(R.id.gridView);
        gvMain.setAdapter(adapter);
        adjastGridView();*/

        GridView gridView = (GridView)findViewById(R.id.gridView);
        ImageAdapter imageAdapter = new ImageAdapter(this);
        gridView.setAdapter(imageAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(currentPos <0)
                {
                    currentPos = position;
                    curView = (ImageView) view;
                    ((ImageView)view).setImageResource(drawable[pos[position]]);
                }

                else
                {
                    if(currentPos == position)
                    {
                        ((ImageView)view).setImageResource(R.drawable.close);
                    }
                    else if(pos[position] != pos[position])
                    {
                        curView.setImageResource(R.drawable.close);
                        Toast.makeText(getApplicationContext(),"Not mach", Toast.LENGTH_SHORT).show();
                    }

                    else
                    {
                        ((ImageView)view).setImageResource(drawable[pos[position]]);
                        countPair++;

                        if(countPair==0)
                        {
                            Toast.makeText(getApplicationContext(),"You win",Toast.LENGTH_SHORT).show();
                        }
                    }
                    currentPos =-1;
                }
            }
        });
    }
}