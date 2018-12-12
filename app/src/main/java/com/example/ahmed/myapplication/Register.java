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
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = (EditText)findViewById(R.id.editText3);
        email = (EditText)findViewById(R.id.editText4);
        password = (EditText)findViewById(R.id.editText5);
        phoneNumber = (EditText)findViewById(R.id.editText6);
        register = (Button)findViewById(R.id.button4);
        radioSexGroup = (RadioGroup) findViewById(R.id.gender);
        int selectedId = radioSexGroup.getCheckedRadioButtonId();
        radioSexButton = (RadioButton) findViewById(selectedId);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  if (!databaseHelper.checkUser(email.getText().toString().trim())) {

                    user.setName(name.getText().toString().trim());
                    user.setEmail(email.getText().toString().trim());
                    user.setPassword(password.getText().toString().trim());
                    user.setGender(radioSexButton.getText().toString().trim());
                    user.setPhoneNumber(phoneNumber.getText().toString().trim());
                    databaseHelper.addUser(user);

                    Intent accountsIntent = new Intent(Register.this, Login.class);
                    startActivity(accountsIntent);
              //  }

            }
        });

    }
}
