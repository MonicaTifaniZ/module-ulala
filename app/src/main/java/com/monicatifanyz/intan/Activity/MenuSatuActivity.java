package com.monicatifanyz.intan.Activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.monicatifanyz.intan.MainActivity;
import com.monicatifanyz.intan.R;

public class MenuSatuActivity extends Activity implements View.OnClickListener{

    ImageView imageViewKotakInfo, imageViewCeritaSatu, imageViewCeritaDua, imageViewHome, imageViewMateri, ivSara, ivNina;
    Button buttonnLatihanSatu, buttonLatihanDua, buttonKirim;
    TextInputEditText etNamaLengkap, etNoAbsen, etJawab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_satu);

        imageViewCeritaDua = (ImageView) findViewById(R.id.ivCeritaDua);
        imageViewCeritaSatu = (ImageView) findViewById(R.id.ivCeritaSatu);
        imageViewKotakInfo = (ImageView) findViewById(R.id.ivKotakInfo);
        imageViewHome = (ImageView) findViewById(R.id.ivHome);
        imageViewMateri = (ImageView) findViewById(R.id.ivMateri);
        buttonLatihanDua = (Button) findViewById(R.id.btnLatihan2);
        buttonnLatihanSatu = (Button) findViewById(R.id.btnLatihan1);
        buttonKirim = (Button) findViewById(R.id.buttonGo);
        ivSara = (ImageView) findViewById(R.id.sara);
        ivNina = (ImageView) findViewById(R.id.nina);

        etNamaLengkap = (TextInputEditText) findViewById(R.id.editTextNama);
        etNoAbsen = (TextInputEditText) findViewById(R.id.editTextAbsen);
        etJawab = (TextInputEditText) findViewById(R.id.editTextJawab);

        imageViewMateri.setOnClickListener(this);
        imageViewHome.setOnClickListener(this);
        imageViewKotakInfo.setOnClickListener(this);
        imageViewCeritaSatu.setOnClickListener(this);
        imageViewCeritaDua.setOnClickListener(this);
        buttonnLatihanSatu.setOnClickListener(this);
        buttonLatihanDua.setOnClickListener(this);
        buttonKirim.setOnClickListener(this);
        ivSara.setOnClickListener(this);
        ivNina.setOnClickListener(this);


    }

    public void materi(View view){
        Intent sebelum = new Intent(this, MateriActivity.class);
        startActivity(sebelum);
    }

    public void menuHome(View view){
        Intent menu = new Intent(this, MainActivity.class);
        startActivity(menu);
    }

    public void menuKotak(View view){
        Intent menu = new Intent(this, KotakInfoSatuActivity.class);
        startActivity(menu);
    }

    public void ceritaSatu(View view){
        Intent menu = new Intent(this, CeritaSara.class);
        startActivity(menu);
    }

    public void ceritaDua(View view){
        Intent menu = new Intent(this, CeritaNina.class);
        startActivity(menu);
    }

    public void latihanSatu(View view){
        Intent menu = new Intent(this, DataLatihanSatu.class);
        startActivity(menu);
    }

    public void latihanDua(View view){
        Intent menu = new Intent(this, LatihanDua.class);
        startActivity(menu);
    }
    public void sendToEmail() {
        String nama = etNamaLengkap.getText().toString();
        String absen = etNoAbsen.getText().toString();
        String jawab = etJawab.getText().toString();

        if (etNamaLengkap.getText().toString().isEmpty() || etNoAbsen.getText().toString().isEmpty() || etJawab.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(),
                    "Data tidak boleh kosong!", Toast.LENGTH_SHORT).show();
        } else {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("aplication/octet-stream");// only email apps should handle this
            String mycontent = "Nama Lengkap\t:\t" + nama + "\n" + "Nomor Absen\t\t\t:" + absen + "\n" + "Jawaban\t:\n " + jawab + "\n";
            i.putExtra(Intent.EXTRA_TEXT, mycontent);
            i.putExtra(Intent.EXTRA_SUBJECT, "Jawaban Latihan 1");
            try {
                startActivity(Intent.createChooser(i, "Send mail..."));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                etNamaLengkap.setText("");
                etNoAbsen.setText("");
                etJawab.setText("");
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(MenuSatuActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();

            }
        }

    }

    @Override
    public void onClick(View v) {
        if (v == imageViewMateri){
            materi(imageViewMateri);
        } else if(v == imageViewHome){
            menuHome(imageViewHome);
        } else if (v == imageViewKotakInfo){
            menuKotak(imageViewKotakInfo);
        } else if (v == imageViewCeritaSatu){
            ceritaSatu(imageViewCeritaSatu);
        } else if (v == buttonnLatihanSatu){
            latihanSatu(buttonnLatihanSatu);
        } else if (v == buttonKirim){
            sendToEmail();
        } else if (v == imageViewCeritaDua){
            ceritaDua(imageViewCeritaDua);
        } else if (v == ivSara){
            ceritaSatu(ivSara);
        } else if (v == ivNina){
            ceritaDua(ivNina);
        } else if (v == buttonLatihanDua){
            latihanDua(buttonLatihanDua);
        }
    }


    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, DaftarMateriActivity.class);
        startActivity(i);
    }
}
