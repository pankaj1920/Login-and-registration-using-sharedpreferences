package com.app.basicloginandregisterusingsharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText login_name_edittext = (EditText)findViewById(R.id.login_name);
        final EditText login_password_edittext = (EditText)findViewById(R.id.login_password);
        Button login = (Button)findViewById(R.id.login);
        Button rigester = (Button)findViewById(R.id.rigester);

        SharedPreferences preferences =getSharedPreferences("MY_PREF",MODE_PRIVATE);
        Boolean isloggedin = preferences.getBoolean("IsLoggedIn",false);

        //if user is logged in the when he open the app he should directly go to home page
        if(isloggedin)
        {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        final String Requried_Password = preferences.getString("PASSWORD","Default_password");
        final String Requrid_name = preferences.getString("NAME","Default_name");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login_name = login_name_edittext.getText().toString();
                String login_password= login_password_edittext.getText().toString();
                
                if (login_name.equals(Requrid_name)&&login_password.equals(Requried_Password)){
                    
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(LoginActivity.this, "Email or Password Wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //When user Click on rigester button
        rigester.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,Register.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
