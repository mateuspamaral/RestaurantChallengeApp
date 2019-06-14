package br.com.digitalhouse.restaurantchallengeapp.login.view;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.digitalhouse.restaurantchallengeapp.R;
import br.com.digitalhouse.restaurantchallengeapp.restaurant.view.RestaurantActivity;
import br.com.digitalhouse.restaurantchallengeapp.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity {

    //Attributes declaration
    private TextInputLayout loginTextInputLayoutEmail;
    private TextInputLayout loginTextInputLayoutPassword;
    private Button loginButtonLogin;
    private Button loginButtonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

        validateLogin();

        callRegisterActivity();
    }

    private void initViews() {
        loginTextInputLayoutEmail = findViewById(R.id.loginTextInputLayoutEmail);
        loginTextInputLayoutPassword = findViewById(R.id.loginTextInputLayoutPassword);
        loginButtonLogin = findViewById(R.id.loginButtonLogin);
        loginButtonRegister = findViewById(R.id.loginButtonRegister);
    }

    private void validateLogin() {
        loginButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailLog = loginTextInputLayoutEmail.getEditText().getText().toString();
                String senhaLog = loginTextInputLayoutPassword.getEditText().getText().toString();

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

                //If all fields are typed, them liberate user to proceed
                if (!(emailLog.isEmpty()) && !(senhaLog.isEmpty())){
                    Intent intent = new Intent(LoginActivity.this, RestaurantActivity.class);
                    startActivity(intent);
                }
            }
        });
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
