package br.com.digitalhouse.restaurantchallengeapp.login.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.Objects;

import br.com.digitalhouse.restaurantchallengeapp.R;
import br.com.digitalhouse.restaurantchallengeapp.restaurant.view.RestaurantActivity;
import br.com.digitalhouse.restaurantchallengeapp.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity {

    //Attributes declaration
    private TextInputLayout loginTextInputLayoutEmail;
    private TextInputLayout loginTextInputLayoutPassword;
    private CheckBox loginCheckBoxRememberMe;
    private Button loginButtonLogin;
    private Button loginButtonRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final SharedPreferences preferences = getSharedPreferences("DHFOODS", MODE_PRIVATE);

        initViews();

        try {
            Objects.requireNonNull(loginTextInputLayoutEmail.getEditText()).setText(preferences.getString("EMAIL", ""));
            Objects.requireNonNull(loginTextInputLayoutPassword.getEditText()).setText(preferences.getString("PASSWORD", ""));
        } catch (Exception e){
            e.printStackTrace();
        }

        loginValidation(preferences);

        callRegisterActivity();
    }

    private void loginValidation(final SharedPreferences preferences) {
        loginButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    String emailLog = Objects.requireNonNull(loginTextInputLayoutEmail.getEditText()).getText().toString();
                    String senhaLog = Objects.requireNonNull(loginTextInputLayoutPassword.getEditText()).getText().toString();

                    loginTextInputLayoutEmail.setError("");
                    loginTextInputLayoutPassword.setError("");

                    if (emailLog.isEmpty()) {
                        loginTextInputLayoutEmail.setError("Enter your email address");
                        return;
                    }

                    if (senhaLog.isEmpty()) {
                        loginTextInputLayoutPassword.setError("Inform your password");
                        return;
                    }

                    if (loginCheckBoxRememberMe.isChecked()){
                        preferences.edit().putString("EMAIL", emailLog).apply();
                        preferences.edit().putString("PASSWORD", senhaLog).apply();
                    }

                    //If all fields are typed, them liberate user to proceed
                    if (!(emailLog.isEmpty()) && !(senhaLog.isEmpty())){
                        Intent intent = new Intent(LoginActivity.this, RestaurantActivity.class);
                        startActivity(intent);
                    }

                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    private void initViews() {
        loginTextInputLayoutEmail = findViewById(R.id.loginTextInputLayoutEmail);
        loginTextInputLayoutPassword = findViewById(R.id.loginTextInputLayoutPassword);
        loginCheckBoxRememberMe = findViewById(R.id.loginCheckBoxRememberMe);
        loginButtonLogin = findViewById(R.id.loginButtonLogin);
        loginButtonRegister = findViewById(R.id.loginButtonRegister);
    }

    private void callRegisterActivity() {
        loginButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
