package com.example.aba2naija.aba2naija;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.kaopiz.kprogresshud.KProgressHUD;
import com.example.aba2naija.aba2naija.jsonperser.UTILS.Utils;

public class Aba2NaijaMainActivity extends AppCompatActivity {
    final Utils util = new Utils();
    KProgressHUD hud;
    private EditText etUsername, etEmail, etPassword, etConfirmpassword, etPhone;
    private Button btnRegster, btnLogin;
    private String email, password, phone, username, confirmpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aba2_naija_main);

        etEmail = findViewById(R.id.et_email);
        etUsername = findViewById(R.id.et_user_name);
        etPassword = findViewById(R.id.et_password);
        etConfirmpassword = findViewById(R.id.et_confirm_password);
        etPhone = findViewById(R.id.et_phone);
        btnLogin = findViewById(R.id.btn_login);
        btnRegster = findViewById(R.id.btn_register);

        btnRegster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validation();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validation();
            }
        });

    }

    private void validation() {
        email = etEmail.getText().toString().toLowerCase().trim();
        password = etPassword.getText().toString().trim();
        phone = etPhone.getText().toString().trim();
        password = etPassword.getText().toString().trim();
        username = etUsername.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            etEmail.setError("Please enter a correct email");
            return;
        }
        if (TextUtils.isEmpty(username)) {
            etUsername.setError("please choose a username");
        }

        if (TextUtils.isEmpty(password) && password.length() != 8) {
            etPassword.setError("password cannot be empty or less than 8 digits");
        }

        if (TextUtils.isEmpty(phone) && phone.length() != 11) {
            etPhone.setError("phone number cannot be empty " +
                    "and phone number must be = 11 digits");
        }

        if (TextUtils.isEmpty(confirmpassword) && confirmpassword != password) {
            etConfirmpassword.setError("input did not match the password you entered");
        }

        if (util.isNetworkAvailable(getApplicationContext())) {
            try {
                new sendPostRequest().execute();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
    }
