package com.example.foodie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_one);

        Button chef, delivery, customer;

        chef =(Button)findViewById(R.id.chef);
        delivery = (Button)findViewById(R.id.delivery);
        customer = (Button)findViewById(R.id.customer);


        chef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chef = new Intent(ChooseOne.this,ChefHome.class);
                chef.putExtra("HomeMenu","Chef");
                startActivity(chef);

            }

        });

        delivery.setOnClickListener(new View.OnClickListener() {
            @Override

           public void onClick(View view) {
                Intent delivery = new Intent(ChooseOne.this,DeliveryPersonHome.class);
                delivery.putExtra("HomeDelivery","Delivery");
               startActivity(delivery);
            }
        });

        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent customer = new Intent(ChooseOne.this,CustomerHome.class);
                customer.putExtra("HomeCustomer","Customer");
                startActivity(customer);
            }
        });
    }
}