package com.musicplayer.nubt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.musicplayer.nubt.Model1.ItemActivity;

public class Login extends AppCompatActivity {
    EditText usernameEditText, passwordEditText;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.id_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredUsername = usernameEditText.getText().toString();
                String enteredPassword = passwordEditText.getText().toString();

                SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                String savedUsername = preferences.getString("username", "");
                String savedPassword = preferences.getString("password", "");
                String savedEmail = preferences.getString("email", "");

                if(enteredUsername.equals(savedUsername) && enteredPassword.equals(savedPassword)) {
                    Toast.makeText(Login.this, "Login successful", Toast.LENGTH_SHORT).show();
                    Intent m=new Intent(Login.this, ItemActivity.class);
                    startActivity(m);
                } else {
                    Toast.makeText(Login.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}