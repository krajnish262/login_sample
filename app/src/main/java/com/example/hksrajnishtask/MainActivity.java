package com.example.hksrajnishtask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.util.regex.Pattern;

import com.example.hksrajnishtask.Network.RetrofitClient;
import com.example.hksrajnishtask.Ui.DashboardActivity;
import com.example.hksrajnishtask.Ui.SignUpActivity;
import com.example.hksrajnishtask.Ui.forgetPassword;
import com.example.hksrajnishtask.model.LoginResponse;
import com.example.hksrajnishtask.utils.SharedPrefManager;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import android.util.Patterns;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
        private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    "(?=.*[a-z])" +         //at least 1 lower case letter
                    "(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$");

    TextInputLayout text_email, text_password;
    TextInputEditText userName, password;
    Button signIn;
    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //hide actionbar
        getSupportActionBar().hide();

        //hide status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        signIn = findViewById(R.id.sign_in_button);
        text_email = findViewById(R.id.user_email);
        text_password = findViewById(R.id.user_password);

    }

    private boolean validateEmail() {
        String emailInput = text_email.getEditText().getText().toString().trim();

        if (emailInput.isEmpty()) {
            text_email.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            text_email.setError("Please enter a valid email address");
            return false;
        } else {
            text_email.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String passwordInput = text_password.getEditText().getText().toString().trim();

        if (passwordInput.isEmpty()) {
            text_password.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            text_password.setError("Password too weak");
            return false;
        } else {
            text_password.setError(null);
            return true;
        }
    }

    public void confirmInput(View v) {
      //  if (!validateEmail() | !validatePassword()) {
            Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
            startActivity(intent);

        }

    public void signUp(View view) {
        Intent intent=new Intent(MainActivity.this,SignUpActivity.class);
        startActivity(intent);
    }

//        String input = "Email: " + text_email.getEditText().getText().toString();
//        input += "\n";
//        input += "Password: " + text_password.getEditText().getText().toString();

        // Toast.makeText(this, input, Toast.LENGTH_SHORT).show();

    }




