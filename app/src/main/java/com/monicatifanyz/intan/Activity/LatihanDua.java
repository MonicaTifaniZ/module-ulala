package com.monicatifanyz.intan.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.monicatifanyz.intan.MainActivity;
import com.monicatifanyz.intan.R;

public class LatihanDua extends Activity implements View.OnClickListener {

    ImageView imageViewHome, imageViewPrev;
    Button buttonKirim;
    TextInputEditText etNamaLengkap, etNoAbsen, etJawab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan_tiga);

        imageViewHome = (ImageView) findViewById(R.id.ivHome);
        imageViewPrev = (ImageView) findViewById(R.id.ivMateri);
        buttonKirim = (Button) findViewById(R.id.buttonGo);

        etNamaLengkap = (TextInputEditText) findViewById(R.id.editTextNama);
        etNoAbsen = (TextInputEditText) findViewById(R.id.editTextAbsen);
        etJawab = (TextInputEditText) findViewById(R.id.editTextJawab);

        imageViewHome.setOnClickListener(this);
        buttonKirim.setOnClickListener(this);
        imageViewPrev.setOnClickListener(this);
    }

    public void materi(View view){
        Intent sebelum = new Intent(this, MenuSatuActivity.class);
        startActivity(sebelum);
    }

    public void menuHome(View view){
        Intent menu = new Intent(this, MainActivity.class);
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
            String mycontent = "Nama Lengkap\t:\t" + nama + "\n" + "Nomor Absen\t\t\t\t: " + absen + "\n" + "Jawaban\t:\n " + jawab + "\n";
            i.putExtra(Intent.EXTRA_TEXT, mycontent);
            i.putExtra(Intent.EXTRA_SUBJECT, "Jawaban Latihan 2");
            try {
                startActivity(Intent.createChooser(i, "Send mail..."));
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(LatihanDua.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();

            }
        }


    }


    public void bersih(){
        etNamaLengkap.setText("");
        etNoAbsen.setText("");
        etJawab.setText("");
    }

    @Override
    public void onClick(View v) {
        if (v == imageViewPrev){
            materi(imageViewPrev);
        } else if(v == imageViewHome){
            menuHome(imageViewHome);
        } else if (v == buttonKirim){
            sendToEmail();
            bersih();
        }

    }
}
