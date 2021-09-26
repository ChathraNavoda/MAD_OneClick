package com.example.foodie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ChefHome extends AppCompatActivity {

    EditText usernameChef_home,passwordChef_home;
    Button chefLogin_home,chefReg_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_home);

        usernameChef_home=(EditText)findViewById(R.id.usernameChef_home);
        passwordChef_home=(EditText) findViewById(R.id.passwordChef_home);
        chefLogin_home=(Button) findViewById(R.id.chefLogin_home);
        chefReg_home=(Button) findViewById(R.id.chefReg_home);

        chefReg_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chefReg_home = new Intent(ChefHome.this,ChefProfileManagement.class);
                chefReg_home.putExtra("ChefHome","Registration");
                startActivity(chefReg_home);
            }
        });

        chefLogin_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  chefLogin_home = new Intent(ChefHome.this,Chef.class);
                chefLogin_home.putExtra("ChefHome","Login");
                startActivity(chefLogin_home);
            }
        });


    }
}