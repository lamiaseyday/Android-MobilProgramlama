package com.example.eyda.lsy1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginActivity extends AppCompatActivity {

    EditText lgnUsername, lgnPasswd, edtLgnAdi;
    Button btnLgn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        mAuth = FirebaseAuth.getInstance();//firebase nesnelerini alıyoruz



    }

    public void login(View view) {
        String userName = lgnUsername.getText().toString().trim();
        String parola = lgnPasswd.getText().toString().trim();

        if (userName.equals("") || parola.equals("")) {
            Toast.makeText(loginActivity.this, "Boş alan bırakmayınız.",
                    Toast.LENGTH_SHORT).show();
        }else if(parola.length() < 6){
            Toast.makeText(loginActivity.this, "Parola en az 6 karakter olmalı.",
                    Toast.LENGTH_SHORT).show();

        } else{
            mAuth.signInWithEmailAndPassword(userName, parola)

                    .addOnCompleteListener(loginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(loginActivity.this, "giriş başarılı.",
                                        Toast.LENGTH_SHORT).show();
                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent i = new Intent(loginActivity.this, TanitimScreen.class);
                                startActivity(i);

                                Intent in = new Intent(loginActivity.this, TanitimScreen.class);
                                in.putExtra("veri",edtLgnAdi.getText().toString());
                                startActivity(in);
                                finish();
                            } else {
                                // If sign in fails, display a message to the user.

                                Toast.makeText(loginActivity.this, "giriş başarısız.",
                                        Toast.LENGTH_SHORT).show();
                            }


                        }
                    });
        }


    }

    private void init() {

        lgnUsername = findViewById(R.id.editloginKullanici);
        lgnPasswd = findViewById(R.id.editLoginPassword);
        btnLgn = findViewById(R.id.buttonLoginKaydol);
        edtLgnAdi = findViewById(R.id.editloginAdi);

    }
    @Override
    public void onBackPressed() {
        // Çalışmasını istediğiniz kodu buraya yazacağız
        super.onBackPressed();
        Intent i = new Intent(loginActivity.this, WelcomeActivity.class);
        startActivity(i);
        finish();

    }
}
