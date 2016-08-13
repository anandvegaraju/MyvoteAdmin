package com.example.anand.myvoteadmin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.digits.sdk.android.AuthCallback;
import com.digits.sdk.android.Digits;
import com.digits.sdk.android.DigitsAuthButton;
import com.digits.sdk.android.DigitsException;
import com.digits.sdk.android.DigitsSession;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "gN5ydNpGONZOjauIa4nm5OMkf";
    private static final String TWITTER_SECRET = "MGs5uEiKc1ga7IYUQZiyYIzOt7u5pmihbCr1PkZhd2fSId63QU";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new TwitterCore(authConfig), new Digits.Builder().build());
        setContentView(R.layout.activity_main);
        DigitsAuthButton digitsButton = (DigitsAuthButton) findViewById(R.id.auth_button);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("admin");
        digitsButton.setCallback(new AuthCallback() {
            @Override
            public void success(DigitsSession session, final String phoneNumber) {
                // TODO: associate the session userID with your user model
                Toast.makeText(getApplicationContext(), "Admin Authentication successful for "
                        + phoneNumber, Toast.LENGTH_LONG).show();
                myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String s = dataSnapshot.getValue(String.class);
                        if(s.contains(phoneNumber)){
                            Intent intent = new Intent(MainActivity.this,WelcomeAdmin.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"You are not an admin",Toast.LENGTH_SHORT).show();
                            TextView textView = (TextView)findViewById(R.id.textView);
                            textView.setText("You're not an admin");
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }

            @Override
            public void failure(DigitsException exception) {
                Log.d("Digits", "Sign in with Digits failure", exception);
            }
        });

    }
}
