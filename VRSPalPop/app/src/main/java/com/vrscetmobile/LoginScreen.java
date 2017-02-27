package com.vrscetmobile;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class LoginScreen extends AppCompatActivity {

    private LinearLayout loginContentView;
    private TextInputLayout TILUsername, TILPassword;
    private EditText userNameET, passWordET;
    private Button btnStudentLogin, btnStaffLogin;
    private ImageView vrsIV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        loginContentView = (LinearLayout) findViewById(R.id.loginContentView);
        TILUsername = (TextInputLayout) findViewById(R.id.TILUsername);
        userNameET = (EditText) findViewById(R.id.userNameET);
        TILPassword = (TextInputLayout) findViewById(R.id.TILPassword);
        passWordET = (EditText) findViewById(R.id.passWordET);

        btnStudentLogin = (Button) findViewById(R.id.btnStudentLogin);
        btnStaffLogin = (Button) findViewById(R.id.btnStaffLogin);
        vrsIV = (ImageView) findViewById(R.id.vrsIV);

        btnStudentLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isLoginValid("student")) {
                    startActivity(new Intent(LoginScreen.this, StudentHomeScreen.class));
                }
            }
        });

        btnStaffLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isLoginValid("staff")) {
                    startActivity(new Intent(LoginScreen.this, StaffHomeScreen.class));
                }
            }
        });
    }

    private boolean isLoginValid(String who) {
        String userName = userNameET.getText().toString().trim();
        String passWrd = passWordET.getText().toString().trim();
        if(who.equals("student")){
            if (userName.equalsIgnoreCase("vrsStudent") && passWrd.equals("1234")) {
                TILPassword.setErrorEnabled(false);
                TILPassword.setError(null);
                TILUsername.setErrorEnabled(false);
                return true;
            } else {
                TILPassword.setErrorEnabled(true);
                TILUsername.setErrorEnabled(true);
                TILPassword.setError("Username or password is not valid. Please check");
            }
        }else{
            if (userName.equalsIgnoreCase("vrsStaff") && passWrd.equals("1234")) {
                TILPassword.setErrorEnabled(false);
                TILPassword.setError(null);
                TILUsername.setErrorEnabled(false);
                return true;
            } else {
                TILPassword.setErrorEnabled(true);
                TILUsername.setErrorEnabled(true);
                TILPassword.setError("Username or password is not valid. Please check");
            }
        }

        return false;
    }
}
