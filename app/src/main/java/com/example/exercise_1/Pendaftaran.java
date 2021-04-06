package com.example.exercise_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.exercise_1.MainActivity;
import com.example.exercise_1.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class Pendaftaran extends AppCompatActivity {

    EditText nama, email, alamat, pass, repass;
    Button btndaftar, btnbatal;
    CheckBox jnsklm, agama;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendaftaran);

        nama = findViewById(R.id.nama);
        email = findViewById(R.id.email);
        alamat = findViewById(R.id.alamat);
        pass = findViewById(R.id.password);
        repass = findViewById(R.id.repass);
        btndaftar = findViewById(R.id.btndaftar);
        btnbatal = findViewById(R.id.btnbatal);
        jnsklm = findViewById(R.id.checkBox);
        jnsklm = findViewById(R.id.checkBox2);

        btndaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nama.getText().toString().isEmpty() ||
                        email.getText().toString().isEmpty() ||
                        alamat.getText().toString().isEmpty() ||
                        pass.getText().toString().isEmpty() ||
                        repass.getText().toString().isEmpty() ||
                        jnsklm.getText().toString().isEmpty()||
                        agama.getText().toString().isEmpty())
                {
                    nama.setError("Masukkan Nama");
                    email.setError("Masukkan Email");
                    alamat.setError("Masukkan Alamat");
                    pass.setError("Masukkan Password");
                    repass.setError("Masukkan Re-Password");
                }
                else
                {
                    if (pass.getText().toString().equals(repass.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(), "registration is successful",
                                Toast.LENGTH_LONG).show();
                        Intent i =new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }
                    else
                    {
                        Snackbar.make(view, "password and repassword must be same",
                                Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });
        btnbatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

    }
}