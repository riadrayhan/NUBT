package com.musicplayer.nubt.Model2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.musicplayer.nubt.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MealActivity extends AppCompatActivity {

    TextView textView;
    private StringBuilder text = new StringBuilder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);

        BufferedReader reader = null;
        textView=(TextView) findViewById(R.id.id_about);

        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open("lunch.txt")));

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                text.append(mLine);
                text.append('\n');
            }
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(),"Error reading file!",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }

            TextView output= (TextView) findViewById(R.id.id_about);
            output.setText((CharSequence) text);

        }
    }
}
