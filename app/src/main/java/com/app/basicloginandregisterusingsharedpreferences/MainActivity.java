package com.app.basicloginandregisterusingsharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView display_text = (TextView)findViewById(R.id.display_text);
        Button logout = (Button)findViewById(R.id.logout);

        final SharedPreferences preferences = getSharedPreferences("MY_PREF",MODE_PRIVATE);
       final String name = preferences.getString("NAME","DEFAULT_NAME");
        display_text.setText("Welcome" +" "+ name);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preferences.edit().putBoolean("IsLoggedIn",false).commit();
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }
}
