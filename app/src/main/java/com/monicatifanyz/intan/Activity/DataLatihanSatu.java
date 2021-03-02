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

import com.google.android.material.textfield.TextInputEditText;
import com.monicatifanyz.intan.MainActivity;
import com.monicatifanyz.intan.R;

public class DataLatihanSatu extends Activity {

    Button btn;
    TextInputEditText etNamaLengkap, etNoAbsen;
    ImageView imageViewPrev, imageViewHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_latihan_satu);

        imageViewHome = findViewById(R.id.ivHome);
        imageViewPrev = findViewById(R.id.ivPrev);

        btn = (Button) findViewById(R.id.buttonGo) ;
        etNamaLengkap = (TextInputEditText) findViewById(R.id.editTextNama);
        etNoAbsen = (TextInputEditText) findViewById(R.id.editTextAbsen);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = etNamaLengkap.getText().toString();
                String absen = etNoAbsen.getText().toString();

                if (etNamaLengkap.getText().toString().isEmpty() || etNoAbsen.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),
                            "Data tidak boleh kosong!",Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent(DataLatihanSatu.this, LatihanSatuActivity.class);
                    i.putExtra("nama", nama);
                    i.putExtra("absen", absen);
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

        imageViewPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prev(imageViewPrev);
            }
        });
    }

    public void menuSoalPG(View v){
        Intent pg = new Intent(this, LatihanSatuActivity.class);
        startActivity(pg);
    }

    public void prev(View view){
        Intent sebelum = new Intent(this, MenuSatuActivity.class);
        startActivity(sebelum);
    }

    public void menuHome(View view){
        Intent menu = new Intent(this, MainActivity.class);
        startActivity(menu);
    }
}
