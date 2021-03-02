package com.monicatifanyz.intan.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.monicatifanyz.intan.MainActivity;
import com.monicatifanyz.intan.R;

public class DataEvaluasiActivity extends Activity {

    Button btn;
    EditText etNamaLengkap, etNoAbsen, etKelas;
    ImageView imageViewHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_evaluasi);

        btn = findViewById(R.id.btnGo);
        etNamaLengkap = findViewById(R.id.editTextNama);
        etNoAbsen = findViewById(R.id.editTextAbsen);
        etKelas = findViewById(R.id.editTextKelas);

        imageViewHome = findViewById(R.id.ivHome);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = etNamaLengkap.getText().toString();
                String absen = etNoAbsen.getText().toString();
                String kelas = etKelas.getText().toString();

                if (etNamaLengkap.getText().toString().isEmpty() || etNoAbsen.getText().toString().isEmpty() || etKelas.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),
                            "Data tidak boleh kosong!",Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent(DataEvaluasiActivity.this, EvaluasiActivity.class);
                    i.putExtra("nama", nama);
                    i.putExtra("absen", absen);
                    i.putExtra("kelas", kelas);
                    startActivity(i);

                    menuSoalPG(btn);
                }


            }
        });
        imageViewHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuHome(imageViewHome);
            }
        });

    }

    public void menuSoalPG(View v){
        Intent pg = new Intent(this, EvaluasiActivity.class);
        startActivity(pg);
    }

    public void menuHome(View view){
        Intent menu = new Intent(this, MainActivity.class);
        startActivity(menu);
    }

}
