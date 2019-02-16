package com.example.kalkausar.latihan;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kalkausar.latihan.helper.InputValidation;
import com.example.kalkausar.latihan.sql.DatabaseHelper;
import com.example.kalkausar.latihan.utils.PreferenceUtils;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    boolean doubleBackToExitPressedOnce = false;

    private final AppCompatActivity activity = LoginActivity.this;

    private NestedScrollView nestedScrollView;

    //Declaration EditTexts
    private TextInputEditText editTextEmail;
    private TextInputEditText editTextPassword;

    //Declaration TextInputLayout
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;

    //Declaration Button
    private Button buttonLogin;

    private TextView textViewCreateAccount;

    //Declaration DatabaseHelper
    private DatabaseHelper databaseHelper;
    private InputValidation inputValidation;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Pleas click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
        initListeners();
        initObjects();
    }

    private void initViews() {
        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);

        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.textInputLayoutPassword);

        editTextEmail = (TextInputEditText) findViewById(R.id.editTextEmail);
        editTextPassword = (TextInputEditText) findViewById(R.id.editTextPassword);

        buttonLogin = (Button) findViewById(R.id.buttonLogin);

        textViewCreateAccount = (TextView) findViewById(R.id.textViewCreateAccount);

        PreferenceUtils utils = new PreferenceUtils();

        if (utils.getEmail(this) != null) {
            Intent intent = new Intent(LoginActivity.this, Menu_Activity.class);
            startActivity(intent);
            finish();
        } else {

        }
    }

    private void initListeners() {
        buttonLogin.setOnClickListener(this);
        textViewCreateAccount.setOnClickListener(this);
    }

    private void initObjects() {
        databaseHelper = new DatabaseHelper(activity);
        inputValidation = new InputValidation(activity);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonLogin:
                verifyFromSQLite();
                break;
            case R.id.textViewCreateAccount:
                Intent intentRegister = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intentRegister);
                break;
        }
    }

    private void verifyFromSQLite() {
        if (!inputValidation.isInputEditTextFilled(editTextEmail, textInputLayoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextEmail(editTextEmail, textInputLayoutEmail, getString(R.string.error_message_email))) {
            return;
        }
        if (!inputValidation.isInputEditTextFilled(editTextPassword, textInputLayoutPassword, getString(R.string.error_message_email))) {
            return;
        }
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (databaseHelper.checkUser(email, password)) {
            PreferenceUtils.saveEmail(email, this);
            PreferenceUtils.savePassword(password, this);
            Intent accountsIntent = new Intent(activity, Menu_Activity.class);
            accountsIntent.putExtra("Email", editTextEmail.getText().toString().trim());
            emptyInputEditText();
            startActivity(accountsIntent);
            finish();
        } else {
            Snackbar.make(nestedScrollView, getString(R.string.error_valid_email_password), Snackbar.LENGTH_LONG).show();
        }
    }

    private void emptyInputEditText() {
        editTextEmail.setText(null);
        editTextPassword.setText(null);
    }
}
