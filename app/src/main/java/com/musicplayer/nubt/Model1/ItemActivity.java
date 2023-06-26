package com.musicplayer.nubt.Model1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.musicplayer.nubt.Model2.MealActivity;
import com.musicplayer.nubt.R;

public class ItemActivity extends AppCompatActivity {
    Button burger,pizza,others,about,meal;
    TextView marquee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        burger=(Button) findViewById(R.id.id_burger);
        pizza=(Button) findViewById(R.id.id_pizza);
        others=(Button) findViewById(R.id.id_others);
        about=(Button) findViewById(R.id.id_about);
        meal=(Button) findViewById(R.id.id_meal);
        marquee=(TextView)findViewById(R.id.marqueeText);
        marquee.setSelected(true);

        burger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ItemActivity.this, com.musicplayer.nubt.Model1.MainActivity2.class);
                startActivity(i);

            }
        });
        pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ItemActivity.this, com.musicplayer.nubt.Model2.MainActivity22.class);
                startActivity(i);
            }
        });
        others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ItemActivity.this, com.musicplayer.nubt.Model2.OthersActivity.class);
                startActivity(i);
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ItemActivity.this, About.class);
                startActivity(i);
            }
        });
        meal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ItemActivity.this, MealActivity.class);
                startActivity(i);
            }
        });
    }
}