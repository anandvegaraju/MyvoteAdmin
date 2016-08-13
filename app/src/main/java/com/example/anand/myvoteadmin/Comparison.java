package com.example.anand.myvoteadmin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Acer on 13-08-2016.
 */

public class Comparison extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comparison_activity);
        Intent intentt = getIntent();
        int a1 = intentt.getIntExtra("num1",0);
        int a2 = intentt.getIntExtra("num2",0);
        int a3 = intentt.getIntExtra("num3",0);
        int a4 = intentt.getIntExtra("num4",0);
        int a5 = intentt.getIntExtra("num5",0);
        int summ = a1 + a2 + a3 + a4 + a5;
        float v1,v2,v3,v4,v5;

        v1 = ((float)a1/summ)*100;
        v2 = ((float)a2/summ)*100;
        v3 = ((float)a3/summ)*100;
        v4 = ((float)a4/summ)*100;
        v5 = ((float)a5/summ)*100;

        String msg = "Choice1:\t " + v1 + "%"+ "\nChoice2:\t " + v2 + "%" + "\nChoice3:\t " + v3  + "%" + "\nChoice4:\t " + v4  + "%" + "\nChoice5:\t " + v5  + "%";
        TextView comparisionn = (TextView)findViewById(R.id.comptext);
        comparisionn.setText(msg);

        Button closebutton = (Button)findViewById(R.id.closebutton);
        closebutton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
                        homeIntent.addCategory( Intent.CATEGORY_HOME );
                        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(homeIntent);
                    }
                }
        );

        Button goback = (Button)findViewById(R.id.goback);
        goback.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent goback = new Intent(Comparison.this,WelcomeAdmin.class);
                        startActivity(goback);
                    }
                }
        );



    }
}
