package com.example.ahmed.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Login extends AppCompatActivity {
    private EditText email;
    private EditText pass;
    private Button login;
    private TextView message;
    private DataBaseHelperUser databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            email = findViewById(R.id.email);
            pass = findViewById(R.id.password);
            login = findViewById(R.id.login);
            message = findViewById(R.id.message);

            databaseHelper = new DataBaseHelperUser(this);

            try {
                login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        System.out.println(databaseHelper.checkUser(email.getText().toString().trim()));
//                        if (databaseHelper.checkUser(email.getText().toString().trim()
//                                , pass.getText().toString().trim())) {
//
//
                            Intent accountsIntent = new Intent(Login.this, Home.class);
                            accountsIntent.putExtra("EMAIL", email.getText().toString().trim());
                            startActivity(accountsIntent);
//
//                        } else {
//                            message.setText("invalid Email or Password");
//                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
    }

}
