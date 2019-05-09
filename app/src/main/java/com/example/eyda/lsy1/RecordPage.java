package com.example.eyda.lsy1;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.app.PendingIntent.getActivity;

public class RecordPage extends AppCompatActivity {

    private FirebaseAuth mAuth;
    TextView  txtKulAdi, txtParola, txtParolaTekrar;
    EditText edtKulAdi, edtParola, edtParolaTekrar;
    Button btnKaydol, btnLgn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_page);

        mAuth = FirebaseAuth.getInstance();
        init();

    }

    public void signUp(View v) {

         String kulAdi = edtKulAdi.getText().toString();
         String parola = edtParola.getText().toString();
         String parolaTekrar = edtParolaTekrar.getText().toString();

        if (kulAdi.equals("") || parola.equals("") || parolaTekrar.equals("")) {

            Toast.makeText(RecordPage.this, "Eksik alan bırakma..", Toast.LENGTH_LONG).show();

        }
        else if (parola.length() < 6) {
            Toast.makeText(RecordPage.this, "Parola en az 6 karakter olmalı..", Toast.LENGTH_LONG).show();

        }
        else if (!parolaTekrar.equals(parola)) {
            Toast.makeText(RecordPage.this, "Parolalar eşleşmiyor..", Toast.LENGTH_LONG).show();

        }


            mAuth.createUserWithEmailAndPassword(kulAdi, parola)
                    .addOnCompleteListener(RecordPage.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(RecordPage.this, "Kaydınız oldu..", Toast.LENGTH_LONG).show();
                                Intent i = new Intent(RecordPage.this, loginActivity.class);
                                startActivity(i);
                                finish();

                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(RecordPage.this, "Kaydınız olmadı..", Toast.LENGTH_LONG).show();

                            }

                            // ...
                        }
                    });



        }



    private void init() {

        txtKulAdi = findViewById(R.id.txtKullanici);
        txtParola = findViewById(R.id.txtPassword);
        txtParolaTekrar = findViewById(R.id.txtPasswordRepeat);
        edtKulAdi = findViewById(R.id.editKullanici);
        edtParola = findViewById(R.id.editPassword);
        edtParolaTekrar = findViewById(R.id.editPasswordRepeat);
        btnKaydol = findViewById(R.id.buttonKaydol);
    }


    @Override
    public void onBackPressed() {
        // Çalışmasını istediğiniz kodu buraya yazacağız

        Intent i = new Intent(RecordPage.this, WelcomeActivity.class);
        startActivity(i);
        finish();
        super.onBackPressed();

    }

}
