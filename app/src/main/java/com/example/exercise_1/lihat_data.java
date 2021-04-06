package com.example.exercise_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Switch;
import android.widget.TextView;

public class lihat_data extends AppCompatActivity {
    TextView tvnama, tvnomor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);

        tvnama = findViewById(R.id.tvNamaKontak);
        tvnomor = findViewById(R.id.tvNomorTelepon);

        Bundle bundle = getIntent().getExtras();

        String nama = bundle.getString("a");

        switch (nama)
        {
            case "Inayah":
                this.tvnama.setText("Inayah M");
                this.tvnomor.setText("0812987876");
                break;
            case "Ilham":
                this.tvnama.setText("Ilham R");
                this.tvnomor.setText("0813467986");
                break;
            case "Eris":
                this.tvnama.setText("M Eris");
                this.tvnomor.setText("0814375345");
                break;
            case "Fikri":
                this.tvnama.setText("FIkri D");
                this.tvnomor.setText("0815754785");
                break;
            case "Maul":
                this.tvnama.setText("Maul A");
                this.tvnomor.setText("0816976964");
                break;
            case "Intan":
                this.tvnama.setText("Intan R");
                this.tvnomor.setText("0817973256");
                break;
            case "Vina":
                this.tvnama.setText("Vina A");
                this.tvnomor.setText("0818654067");
                break;
            case "Gita":
                this.tvnama.setText("Gita M");
                this.tvnomor.setText("0819743869");
                break;
            case "Vian":
                this.tvnama.setText("Vian J");
                this.tvnomor.setText("0820764345");
                break;
            case "Lutfi":
                this.tvnama.setText("Lutfi M");
                this.tvnomor.setText("0821754854");
                break;
        }
    }
}