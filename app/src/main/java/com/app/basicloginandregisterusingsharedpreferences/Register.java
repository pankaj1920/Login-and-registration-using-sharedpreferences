package com.app.basicloginandregisterusingsharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText rigester_name = (EditText) findViewById(R.id.rigester_name);
        final EditText rigester_password = (EditText) findViewById(R.id.rigester_password);
        final EditText rigester_email = (EditText) findViewById(R.id.rigester_email);
        Button rigester_btn = (Button) findViewById(R.id.rigester_btn);

        rigester_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Converting Input data to string
                String name = rigester_name.getText().toString();
                String password = rigester_password.getText().toString();
                String email = rigester_email.getText().toString();

                SharedPreferences preferences = getSharedPreferences("MY_PREF", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();

                //storing data
                editor.putString("NAME", name);
                editor.putString("PASSWORD", password);
                editor.putString("EMAIL", email);
                //editor.putBoolean("IsLoggedIn",true);
                editor.commit();

                Toast.makeText(Register.this, "Rigestered", Toast.LENGTH_SHORT).show();

                //After Registering send user to login screen
                Intent intent = new Intent(Register.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
