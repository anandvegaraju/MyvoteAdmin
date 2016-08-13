package com.example.anand.myvoteadmin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Acer on 13-08-2016.
 */

public class WelcomeAdmin extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_welcome);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef1 = database.getReference("option1");
        final DatabaseReference myRef2 = database.getReference("option2");
        final DatabaseReference myRef3 = database.getReference("option3");
        final DatabaseReference myRef4 = database.getReference("option4");
        final DatabaseReference myRef5 = database.getReference("option5");

        Button exitbutton = (Button)findViewById(R.id.exit_button);
        exitbutton.setOnClickListener(
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

        Button gotolast = (Button)findViewById(R.id.gotolast);
        gotolast.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent lastt = new Intent(WelcomeAdmin.this,Comparison.class);
                        TextView t1 = (TextView)findViewById(R.id.p1);
                        String s11 = t1.getText().toString();
                        int i1 = Integer.parseInt(s11);

                        TextView t2 = (TextView)findViewById(R.id.p2);
                        String s22 = t2.getText().toString();
                        int i2 = Integer.parseInt(s22);

                        TextView t3 = (TextView)findViewById(R.id.p3);
                        String s33 = t3.getText().toString();
                        int i3 = Integer.parseInt(s33);

                        TextView t4 = (TextView)findViewById(R.id.p4);
                        String s44 = t4.getText().toString();
                        int i4 = Integer.parseInt(s44);

                        TextView t5 = (TextView)findViewById(R.id.p5);
                        String s55 = t5.getText().toString();
                        int i5 = Integer.parseInt(s55);

                        lastt.putExtra("num1",i1);
                        lastt.putExtra("num2",i2);
                        lastt.putExtra("num3",i3);
                        lastt.putExtra("num4",i4);
                        lastt.putExtra("num5",i5);
                        startActivity(lastt);
                    }
                }
        );

        Button button = (Button)findViewById(R.id.buttonref);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myRef1.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                int i1 = dataSnapshot.getValue(Integer.class);
                                String s1 = String.valueOf(i1);
                                final TextView p1 = (TextView)findViewById(R.id.p1);
                                p1.setText(s1);
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                        myRef2.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                int i2 = dataSnapshot.getValue(Integer.class);
                                String s2 = String.valueOf(i2);
                                TextView p2 = (TextView)findViewById(R.id.p2);
                                p2.setText(s2);
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                        myRef3.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                int i3 = dataSnapshot.getValue(Integer.class);
                                String s3 = String.valueOf(i3);
                                TextView p3 = (TextView)findViewById(R.id.p3);
                                p3.setText(s3);
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                        myRef4.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                int i4 = dataSnapshot.getValue(Integer.class);
                                String s4 = String.valueOf(i4);
                                TextView p4 = (TextView)findViewById(R.id.p4);
                                p4.setText(s4);
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                        myRef5.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                int i5 = dataSnapshot.getValue(Integer.class);
                                String s5 = String.valueOf(i5);
                                TextView p5 = (TextView)findViewById(R.id.p5);
                                p5.setText(s5);
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });

                    }
                }



        );
        TextView t1 = (TextView)findViewById(R.id.p1);
        String s11 = t1.getText().toString();
        int i1 = Integer.parseInt(s11);

        TextView t2 = (TextView)findViewById(R.id.p2);
        String s22 = t2.getText().toString();
        int i2 = Integer.parseInt(s22);

        TextView t3 = (TextView)findViewById(R.id.p3);
        String s33 = t3.getText().toString();
        int i3 = Integer.parseInt(s33);

        TextView t4 = (TextView)findViewById(R.id.p4);
        String s44 = t4.getText().toString();
        int i4 = Integer.parseInt(s44);

        TextView t5 = (TextView)findViewById(R.id.p5);
        String s55 = t5.getText().toString();
        int i5 = Integer.parseInt(s55);












    }
}
