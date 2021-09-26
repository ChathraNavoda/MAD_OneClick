package com.example.foodie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FoodGallery extends AppCompatActivity {

    Button piz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_gallery);


        piz = (Button)findViewById(R.id.pizza);

       piz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent piz = new Intent(FoodGallery.this,EditGallery.class);
                piz.putExtra("ChefHome","Login");
                startActivity(piz);
            }
        });
    }
}