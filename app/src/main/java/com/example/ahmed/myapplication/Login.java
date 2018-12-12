package com.example.ahmed.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Login extends AppCompatActivity  {
    private EditText email;
    private EditText pass;
    private Button login;
    private TextView l;
    private DataBaseHelperUser databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText)findViewById(R.id.editText);
        pass = (EditText)findViewById(R.id.editText2);
        login = (Button)findViewById(R.id.button3);
        l = (TextView)findViewById(R.id.textView2);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (databaseHelper.checkUser(email.getText().toString().trim()
                        , pass.getText().toString().trim())) {


                    Intent accountsIntent = new Intent(Login.this, Home.class);
             //    accountsIntent.putExtra("EMAIL", email.getText().toString().trim());
                    startActivity(accountsIntent);

                }
                else{
                    l.setText("invalid Email or Password");
                }
            }
        });

    }


}
