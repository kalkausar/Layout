package com.example.kalkausar.latihan;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kalkausar.latihan.helper.InputValidation;
import com.example.kalkausar.latihan.sql.DatabaseHelper;
import com.example.kalkausar.latihan.model.User;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity=RegisterActivity.this;

    private NestedScrollView nestedScrollView;

    //Declaration EditTexts
    private TextInputEditText editTextUserName;
    private TextInputEditText editTextEmail;
    private TextInputEditText editTextPassword;
    private TextInputEditText editTextConfirmPassword;

    //Declaration TextInputLayout
    private TextInputLayout textInputLayoutUserName;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;
    private TextInputLayout textInputLayoutConfirmPassword;

    //Declaration Button
    private Button buttonRegister;
    private TextView textViewLogin;

    //Declaration DatabaseHelper
    private DatabaseHelper databaseHelper;
    private InputValidation inputValidation;
    private User user;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initViews();
        initListeners();
        initObjects();
    }

    private void initViews(){
        nestedScrollView=(NestedScrollView) findViewById(R.id.nestedScrollView);

        textInputLayoutUserName=(TextInputLayout)findViewById(R.id.textInputLayoutUserName);
        textInputLayoutEmail=(TextInputLayout)findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword=(TextInputLayout)findViewById(R.id.textInputLayoutPassword);
        textInputLayoutConfirmPassword=(TextInputLayout)findViewById(R.id.textInputConfirmPassword);

        editTextUserName=(TextInputEditText) findViewById(R.id.editTextUserName);
        editTextEmail=(TextInputEditText) findViewById(R.id.editTextEmail);
        editTextPassword=(TextInputEditText) findViewById(R.id.editTextPassword);
        editTextConfirmPassword=(TextInputEditText) findViewById(R.id.editTextConfirmPassword);

        buttonRegister=(Button)findViewById(R.id.buttonRegister);

        textViewLogin=(TextView)findViewById(R.id.textViewLogin);
    }

    private void initListeners(){
        buttonRegister.setOnClickListener(this);
        textViewLogin.setOnClickListener(this);
    }

    private void initObjects(){
        inputValidation=new InputValidation(activity);
        databaseHelper=new DatabaseHelper(activity);
        user=new User();
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.buttonRegister:
                postDataToSQLite();
                break;
            case R.id.textViewLogin:
                finish();
                break;
        }
    }

    private void postDataToSQLite(){
        if(!inputValidation.isInputEditTextFilled(editTextUserName, textInputLayoutUserName, getString(R.string.error_message_name))){
            return;
        }
        if(!inputValidation.isInputEditTextFilled(editTextEmail, textInputLayoutEmail, getString(R.string.error_message_email))){
            return;
        }
        if(!inputValidation.isInputEditTextEmail(editTextEmail, textInputLayoutEmail, getString(R.string.error_message_email))){
            return;
        }
        if (!inputValidation.isInputEditTextFilled(editTextPassword, textInputLayoutPassword,getString(R.string.error_message_password))){
            return;
        }
        if(!inputValidation.isInputEditTextMatches(editTextPassword,editTextConfirmPassword,
                textInputLayoutConfirmPassword,getString(R.string.error_password_match))){
            return;
        }

        if(!databaseHelper.checkUser(editTextEmail.getText().toString().trim())){

            user.setUserName(editTextUserName.getText().toString().trim());
            user.setEmail(editTextEmail.getText().toString().trim());
            user.setPassword(editTextPassword.getText().toString().trim());

            databaseHelper.addUser(user);

            Snackbar.make(nestedScrollView,getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
            emptyInputEditText();
        }else{
            Snackbar.make(nestedScrollView,getString(R.string.error_email_exists ), Snackbar.LENGTH_LONG).show();
        }
    }

    private void emptyInputEditText(){
        editTextUserName.setText(null);
        editTextEmail.setText(null);
        editTextPassword.setText(null);
        editTextConfirmPassword.setText(null);
    }
}