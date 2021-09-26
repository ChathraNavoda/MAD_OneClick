package com.example.foodie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.foodie.Database.ChefDB;



public class ChefProfileManagement extends AppCompatActivity {

    EditText chefName_pm,chefEmail_pm,chefPassword_pm;
    Button addProfilePic,addChef_pm,updateChef_pm;
    RadioButton chefMale_pm,chefFemale_pm;
    String genderChef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_profile_management);

        chefName_pm = (EditText)findViewById(R.id.chefName_pm);
        chefEmail_pm = (EditText)findViewById(R.id.chefEmail_pm);
        chefPassword_pm=(EditText) findViewById(R.id.chefPassword_pm);

        addProfilePic=(Button) findViewById(R.id.addProfilePic);
        addChef_pm=(Button)findViewById(R.id.addChef_pm);
        updateChef_pm=(Button)findViewById(R.id.updateChef_pm);

        chefMale_pm=(RadioButton)findViewById(R.id.chefMale_pm);
        chefFemale_pm=(RadioButton)findViewById(R.id.chefFemale_ep);

        //genderChef=(String)findViewById(R.id.genderChef);

        updateChef_pm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent updateChef_pm = new Intent(ChefProfileManagement.this,ChefEditProfile.class);
                updateChef_pm.putExtra("ProfileManagement","Profile");
                startActivity(updateChef_pm);
            }
        });

        addChef_pm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chefMale_pm.isChecked()){
                    genderChef = "Male";
                }
                else {
                    genderChef = "Female";
                }

               ChefDB  dbHandler = new   ChefDB (getApplicationContext());
                long newID = dbHandler.addInfo(chefName_pm.getText().toString(), chefEmail_pm.getText().toString(), chefPassword_pm.getText().toString(),genderChef);
                Toast.makeText(ChefProfileManagement.this, "User added and User ID is : "+newID ,Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(),ChefEditProfile.class);
                startActivity(i);
                chefName_pm.setText(null);
                chefEmail_pm.setText(null);
                chefPassword_pm.setText(null);
                chefMale_pm.setChecked(true);
                chefFemale_pm.setChecked(false);
            }
        });
    }
}
