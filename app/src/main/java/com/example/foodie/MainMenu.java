package com.example.foodie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    Button Login;
    Button Signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Login= (Button)findViewById(R.id.Login);
        Signup= (Button) findViewById(R.id.Signup);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Login = new Intent(MainMenu.this,ChooseOne.class);
                Login.putExtra("Home","Login");
                startActivity(Login);
               // finish();
            }

        });


    }
}