package com.example.ahmed.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class Register extends AppCompatActivity {
    private EditText name;
    private EditText email;
    private EditText password;
    private EditText phoneNumber;
    private Button register;
    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    private DataBaseHelperUser databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.fullname);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        phoneNumber = findViewById(R.id.phone);
        register = findViewById(R.id.reg);
        radioSexGroup = findViewById(R.id.gender);

        databaseHelper = new DataBaseHelperUser(this);

        try {
            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    User user = new User();
                    user.setName(name.getText().toString().trim());
                    user.setEmail(email.getText().toString().trim());
                    user.setPassword(password.getText().toString().trim());
//                    user.setGender(radioSexButton.getText().toString().trim());
                    user.setPhoneNumber(phoneNumber.getText().toString().trim());
                    databaseHelper.addUser(user);

                    Intent accountsIntent = new Intent(Register.this, Login.class);
                    startActivity(accountsIntent);

                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
