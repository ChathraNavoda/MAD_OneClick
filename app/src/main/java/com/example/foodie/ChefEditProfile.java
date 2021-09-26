package com.example.foodie;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.foodie.Database.ChefDB;

import java.util.List;

public class ChefEditProfile extends AppCompatActivity {

    EditText username, email, password;
    Button edit, delete,search;
    RadioButton male, female;
    String gender;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_edit_profile);

        username = findViewById(R.id.chefName_ep);
        email = findViewById(R.id.chefEmail_ep);
        password = findViewById(R.id.chefPassword_ep);
        edit = findViewById(R.id.chefEdit_ep);
        delete = findViewById(R.id.chefDelete_pm);
        search = findViewById(R.id.chefSearch);
        male = findViewById(R.id.chefMale_ep);
        female = findViewById(R.id.chefFemale_ep);


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChefDB dbHandler = new ChefDB(getApplicationContext());
               List user = dbHandler.readAllInfo(username.getText().toString());
                if (user.isEmpty()){
                    Toast.makeText(ChefEditProfile.this, "No such user!", Toast.LENGTH_SHORT).show();
                    username.setText(null);
                }
                else{
                    Toast.makeText(ChefEditProfile.this, "User exists. The user is:"+user.get(0).toString(), Toast.LENGTH_SHORT).show();
                    username.setText(user.get(0).toString());
                    email.setText(user.get(1).toString());
                    password.setText(user.get(2).toString());
                    if(user.get(3).toString().equals("Male")){
                        male.setChecked(true);
                    }
                    else {
                        female.setChecked(true);
                    }
                }
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(male.isChecked()){
                    gender = "Male";
                }
                else {
                    gender = "Female";
                }
                ChefDB dbHandler = new  ChefDB (getApplicationContext());

                Boolean status = dbHandler.updateInfo(username.getText().toString(), email.getText().toString(), password.getText().toString(),gender);
                if(status){
                    Toast.makeText(ChefEditProfile.this, "User updated", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(ChefEditProfile.this, "Update failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               ChefDB dbHandler = new ChefDB(getApplicationContext());
                dbHandler.deleteInfo(username.getText().toString());
                Toast.makeText(ChefEditProfile.this, "User deleted", Toast.LENGTH_SHORT).show();

                username.setText(null);
                email.setText(null);
                password.setText(null);
                male.setChecked(false);
                female.setChecked(false);

            }
        });
    }
}















